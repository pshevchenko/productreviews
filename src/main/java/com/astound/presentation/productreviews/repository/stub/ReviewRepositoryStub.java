package com.astound.presentation.productreviews.repository.stub;

import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.entities.Review;
import org.springframework.stereotype.Component;


@Component
public class ReviewRepositoryStub
{
	public void addReview(Product product, Review review)
	{
		product.getReviews().add(review);
	}
}
