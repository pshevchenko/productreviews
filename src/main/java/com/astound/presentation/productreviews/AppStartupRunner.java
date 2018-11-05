package com.astound.presentation.productreviews;

import com.astound.presentation.productreviews.entities.Category;
import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;


@Component
@RequiredArgsConstructor
public class AppStartupRunner implements ApplicationRunner
{
	private final CategoryRepository categoryRepository;

	@Override
	public void run(ApplicationArguments args)
	{
		//Category 1
		Category category1 = Category.builder().id(1).name("Category 1").description("desc").build();

		Product product1 = Product.builder().id(1).name("Product 1").description("desc").build();
		Product product2 = Product.builder().id(2).name("Product 2").description("desc").build();
		Product product3 = Product.builder().id(3).name("Product 3").description("desc").build();

		product1.setReviews(new ArrayList<>());
		product2.setReviews(new ArrayList<>());
		product3.setReviews(new ArrayList<>());

		category1.setProducts(Arrays.asList(product1, product2, product3));

		categoryRepository.getCategories().add(category1);

		//Category 2
		Category category2 = Category.builder().id(2).name("Category 2").description("desc").build();

		Product product4 = Product.builder().id(4).name("Product 4").description("desc").build();
		Product product5 = Product.builder().id(5).name("Product 5").description("desc").build();

		product4.setReviews(new ArrayList<>());
		product5.setReviews(new ArrayList<>());

		category2.setProducts(Arrays.asList(product4, product5));

		categoryRepository.getCategories().add(category2);
	}
}
