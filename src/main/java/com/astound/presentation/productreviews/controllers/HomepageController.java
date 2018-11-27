package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Category;
import com.astound.presentation.productreviews.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.ERROR_PAGE;
import static com.astound.presentation.productreviews.controllers.ControllerConstants.HOME_PAGE;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class HomepageController
{
	private final CategoryRepository categoryRepository;

	@GetMapping
	public String getProduct(Model model)
	{
		List<Category> categories = categoryRepository.getCategories();
		if (!categories.isEmpty())
		{
			model.addAttribute("categories", categories);
		}
		else
		{
			return ERROR_PAGE;
		}

		return HOME_PAGE;
	}

	@RequestMapping(value = "/thanks")
	public String getThanks()
	{
		return "thanks";
	}
}
