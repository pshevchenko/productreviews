package com.astound.presentation.productreviews.repository;

import com.astound.presentation.productreviews.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class ProductRepository
{
	private final CategoryRepository categoryRepository;

	public List<Product> getProducts()
	{
		return categoryRepository.getCategories().stream().flatMap(category -> category.getProducts().stream())
				.collect(Collectors.toList());
	}

}
