package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.entities.Review;
import com.astound.presentation.productreviews.repository.ProductRepository;
import com.astound.presentation.productreviews.repository.ReviewRepository;
import com.astound.presentation.productreviews.repository.stub.ProductRepositoryStub;
import com.astound.presentation.productreviews.repository.stub.ReviewRepositoryStub;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.ERROR_PAGE;
import static com.astound.presentation.productreviews.controllers.ControllerConstants.PRODUCT_PAGE;


@Controller
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController
{
	@Autowired
	private final ProductRepository productRepository;
	@Autowired
	private final ReviewRepository reviewRepository;

	@GetMapping(value = "/{productId}")
	public String getProduct(@PathVariable Integer productId, Model model)
	{
		Product product = productRepository.getProductById(productId);
		if (product != null)
		{
			model.addAttribute("product", product);
			model.addAttribute("review", new Review());
		}
		else
		{
			return ERROR_PAGE;
		}
		return PRODUCT_PAGE;
	}

	@PostMapping(value = "/{productId}/reviews")
	public String addReview(@PathVariable Integer productId, Review review, Model model)
	{

		Product product = productRepository.getProductById(productId);

		if (product != null)
		{
			reviewRepository.save(review);
			product.getReviews().add(review);
			productRepository.save(product);
			model.addAttribute("product", product);
			model.addAttribute("review", new Review());
		}
		else
		{
			return ERROR_PAGE;
		}
		return PRODUCT_PAGE;
	}

}
