package com.astound.presentation.productreviews.repository;

import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.repository.stub.CategoryRepositoryStub;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class ProductRepository
{
	private final CategoryRepositoryStub categoryRepository;

	public List<Product> getAllProducts()
	{
		return categoryRepository.getCategories().stream().flatMap(category -> category.getProducts().stream())
				.collect(Collectors.toList());
	}

	public Product getProductById(Integer productId)
	{
		return getAllProducts().stream().filter(product -> product.getId().equals(productId)).findAny().orElse(null);

	}

}
