package com.astound.presentation.productreviews;

import com.astound.presentation.productreviews.entities.Category;
import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.repository.CategoryRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;


@Component
public class AppStartupRunner implements ApplicationRunner
{
	@Override
	public void run(ApplicationArguments args)
	{
		Category category1 = Category.builder().id(1).name("Category 1").description("desc").build();

		Product product1 = Product.builder().id(1).name("Product 1").description("desc").build();
		Product product2 = Product.builder().id(2).name("Product 2").description("desc").build();
		Product product3 = Product.builder().id(3).name("Product 3").description("desc").build();

		product1.setReviews(new ArrayList<>());
		product2.setReviews(new ArrayList<>());
		product3.setReviews(new ArrayList<>());

		category1.setProducts(Arrays.asList(product1, product2, product3));

		CategoryRepository.getCategories().add(category1);
	}
}
