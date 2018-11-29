package com.astound.presentation.productreviews.services.config;

import com.astound.presentation.productreviews.repository.ProductRepository;
import com.astound.presentation.productreviews.repository.ReviewRepository;
import com.astound.presentation.productreviews.services.ProductService;
import com.astound.presentation.productreviews.services.impl.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.astound.presentation.productreviews.repository")
public class ProductServiceImplTestConfig
{
	@Bean
	public ProductService productService(ProductRepository productRepository, ReviewRepository reviewRepository){
		return new ProductServiceImpl(productRepository, reviewRepository);
	}
}
