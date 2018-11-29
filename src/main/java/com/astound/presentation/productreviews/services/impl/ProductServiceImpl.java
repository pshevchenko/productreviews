package com.astound.presentation.productreviews.services.impl;

import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.entities.Review;
import com.astound.presentation.productreviews.repository.ProductRepository;
import com.astound.presentation.productreviews.repository.ReviewRepository;
import com.astound.presentation.productreviews.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.ERROR_PAGE;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private final ProductRepository productRepository;
	@Autowired
	private final ReviewRepository reviewRepository;


	@Override
	public Product addReview(int i, Review review)
	{
		Product product = productRepository.getProductById(i);

		if (product != null)
		{
			reviewRepository.save(review);
			product.getReviews().add(review);
			productRepository.save(product);
		}
		else
		{
			return null;
		}

		return product;
	}

	@Override
	public Product getProductById(int i)
	{
		return productRepository.getProductById(i);
	}
}
