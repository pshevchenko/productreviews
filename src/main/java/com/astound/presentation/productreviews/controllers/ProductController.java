package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.ERROR_PAGE;
import static com.astound.presentation.productreviews.controllers.ControllerConstants.PRODUCT_PAGE;
import static com.astound.presentation.productreviews.repository.ProductRepository.products;


@Controller
@RequestMapping(value = "/product")
public class ProductController
{

	@RequestMapping(value = "/get")
	public String getProduct(@RequestParam String id, Model model)
	{

		Optional<Product> product = products.stream().filter(p -> p.getId().equals(id)).findAny();
		if (product.isPresent())
		{
			model.addAttribute("product", product);
		}else{
			//return ERROR_PAGE;
		}
		return PRODUCT_PAGE;

	}
}
