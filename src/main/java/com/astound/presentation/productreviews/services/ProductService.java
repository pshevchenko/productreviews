package com.astound.presentation.productreviews.services;

import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.entities.Review;
import org.springframework.stereotype.Service;


@Service
public interface ProductService
{
	Product addReview(int i, Review review);

	Product getProductById(int i);
}
