package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.entities.Review;
import com.astound.presentation.productreviews.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.ERROR_PAGE;
import static com.astound.presentation.productreviews.controllers.ControllerConstants.PRODUCT_PAGE;


@Controller
@RequestMapping(value = "/products")
public class ProductController
{

	@RequestMapping(value = "/{productId}")
	public String getProduct(@PathVariable Integer productId, Model model)
	{
		Optional<Product> product = ProductRepository.getProducts().stream()
				.filter(p -> p.getId().equals(Integer.valueOf(productId)))
				.findAny();
		if (product.isPresent())
		{
			model.addAttribute("product", product.get());
			model.addAttribute("review", new Review());
		}
		else
		{
			return ERROR_PAGE;
		}
		return PRODUCT_PAGE;
	}

	@RequestMapping(value = "/{productId}/reviews")
	public String writeReview(@PathVariable Integer productId, Review review, Model model)
	{
		Optional<Product> productOptional = ProductRepository.getProducts().stream()
				.filter(p -> p.getId().equals(productId))
				.findAny();
		if (productOptional.isPresent())
		{
			Product product = productOptional.get();
			product.getReviews().add(review.getText());
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
