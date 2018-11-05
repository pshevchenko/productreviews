package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Category;
import com.astound.presentation.productreviews.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.CATEGORY_PAGE;
import static com.astound.presentation.productreviews.controllers.ControllerConstants.ERROR_PAGE;


@Controller
@RequestMapping(value = "/category")
public class CategoryController
{
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getCategory(@RequestParam String id, Model model)
	{
		Optional<Category> category = CategoryRepository.getCategories().stream()
				.filter(cat -> cat.getId().equals(Integer.valueOf(id))).findAny();
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
