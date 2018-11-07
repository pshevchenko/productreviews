package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Category;
import com.astound.presentation.productreviews.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.CATEGORY_PAGE;
import static com.astound.presentation.productreviews.controllers.ControllerConstants.ERROR_PAGE;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
public class CategoryController
{
	private final CategoryRepository categoryRepository;

	@GetMapping(value = "/{categoryId}")
	public String getCategory(@PathVariable Integer categoryId, Model model)
	{
		Optional<Category> category = categoryRepository.getCategories().stream()
				.filter(cat -> cat.getId().equals(categoryId)).findAny();
		if (category.isPresent())
		{
			model.addAttribute("category", category.get());
		}
		else
		{
			return ERROR_PAGE;
		}
		return CATEGORY_PAGE;
	}
}
