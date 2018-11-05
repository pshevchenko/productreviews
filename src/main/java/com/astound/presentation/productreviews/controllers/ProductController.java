package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.ERROR_PAGE;
import static com.astound.presentation.productreviews.controllers.ControllerConstants.PRODUCT_PAGE;


@Controller
@RequestMapping(value = "/product")
public class ProductController
{

	@RequestMapping(value = "/get")
	public String getProduct(@RequestParam String id, Model model)
	{
		Optional<Product> product = ProductRepository.getProducts().stream().filter(p -> p.getId().equals(Integer.valueOf(id)))
				.findAny();
		if (product.isPresent())
		{
			model.addAttribute("product", product.get());
		}
		else
		{
			return ERROR_PAGE;
		}
		return PRODUCT_PAGE;
	}
}
