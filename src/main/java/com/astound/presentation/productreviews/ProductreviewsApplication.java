package com.astound.presentation.productreviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.astound.presentation.productreviews.repository")
@EntityScan("com.astound.presentation.productreviews.entities")
public class ProductreviewsApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ProductreviewsApplication.class, args);
	}
}
