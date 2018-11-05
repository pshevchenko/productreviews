package com.astound.presentation.productreviews.repository;

import com.astound.presentation.productreviews.entities.Product;

import java.util.List;
import java.util.stream.Collectors;


public class ProductRepository
{

	public static List<Product> getProducts()
	{
		return CategoryRepository.getCategories().stream().flatMap(category -> category.getProducts().stream())
				.collect(Collectors.toList());
	}

}
