package com.astound.presentation.productreviews.repository;

import com.astound.presentation.productreviews.entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CategoryRepository
{
	private List<Category> categories = new ArrayList<>();

	public List<Category> getCategories()
	{
		return categories;
	}
}
