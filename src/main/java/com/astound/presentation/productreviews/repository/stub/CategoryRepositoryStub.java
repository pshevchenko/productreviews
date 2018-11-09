package com.astound.presentation.productreviews.repository.stub;

import com.astound.presentation.productreviews.entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CategoryRepositoryStub
{
	private List<Category> categories = new ArrayList<>();

	public List<Category> getCategories()
	{
		return categories;
	}
}
