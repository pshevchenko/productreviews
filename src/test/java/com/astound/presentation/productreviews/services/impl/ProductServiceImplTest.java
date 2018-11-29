package com.astound.presentation.productreviews.services.impl;

import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.entities.Review;
import com.astound.presentation.productreviews.repository.ProductRepository;
import com.astound.presentation.productreviews.repository.ReviewRepository;
import com.astound.presentation.productreviews.services.ProductService;
import com.astound.presentation.productreviews.services.config.ProductServiceImplTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductServiceImplTestConfig.class)
public class ProductServiceImplTest
{
	@Autowired
	ProductService productService;
	@MockBean
	ReviewRepository reviewRepository;
	@MockBean
	ProductRepository productRepository;

	@Before
	public void setUp()
	{
		Product product1 = Product.builder().name("Product 1").description("desc1").reviews(new ArrayList<>()).build();
		Mockito.when(productRepository.getProductById(1)).thenReturn(product1);
	}

	@Test
	public void getProductById() {
		Product product = productService.getProductById(1);
		Mockito.verify(productRepository,Mockito.times(1)).getProductById(1);
		assertEquals("Product 1", product.getName());
	}

	@Test
	public void addReview() {
		Product productById = productService.getProductById(1);
		Review review = new Review(55, 1, "omnom");
		productService.addReview(1,review)	;
		Mockito.verify(productRepository,Mockito.times(1)).save(productById);
		Mockito.verify(reviewRepository, Mockito.times(1)).save(review);
	}

}
