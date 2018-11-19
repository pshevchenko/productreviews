package com.astound.presentation.productreviews.integration.configuration;

import com.astound.presentation.productreviews.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.jpa.dsl.Jpa;
import org.springframework.integration.jpa.support.PersistMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import javax.persistence.EntityManagerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@EnableIntegration
public class BasicIntegrationConfiguration {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private Function<String, Category> mapToCategory = (line) -> {
        String[] p = line.split(",");
        Category category = new Category();
        category.setDescription(p[0]);
        category.setName(p[1]);
        return category;
    };

    @Bean
    IntegrationFlow files(@Value("${input.directory:${HOME}/presentation/in}") File in) {
        GenericTransformer<File, Message<List<Category>>> fileToReviewTransformer = (File csvFile) ->
        {
            List<Category> reviewList = processInputFile(csvFile);
            return MessageBuilder.withPayload(reviewList)
                    .setHeader(FileHeaders.FILENAME, csvFile.getAbsoluteFile().getName())
                    .build();
        };
        return IntegrationFlows
                .from(Files.inboundAdapter(in).autoCreateDirectory(true).patternFilter("*.csv"),
                        poller -> poller.poller(pm -> pm.fixedRate(1000)))
                .transform(File.class, fileToReviewTransformer)
                .split()
                .handle(Jpa.outboundAdapter(entityManagerFactory)
                                .entityClass(Category.class)
                                .persistMode(PersistMode.PERSIST),
                        e -> e.transactional())
                .get();
    }

    private List<Category> processInputFile(File inputFile) {
        List<Category> inputList = new ArrayList<Category>();
        try {
            InputStream inputFS = new FileInputStream(inputFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().map(mapToCategory).collect(Collectors.toList());
            br.close();
        } catch (Exception e) {
            System.out.println("Bad Error Handling" + e.getMessage());
        }
        return inputList;
    }

}
