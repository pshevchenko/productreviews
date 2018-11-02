package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/product")
public class ProductController
{
	@RequestMapping(value = "/get")
	public String getProduct(@RequestParam String id, Model model)
	{

		model.addAttribute("id", id);

		Product product = Product.builder().name("aaa").description("").build();
		product.setPrice(1212d);

		System.out.println(product.getName());



		return "product";


	}

}
