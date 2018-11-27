package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Customer;
import com.astound.presentation.productreviews.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.REGISTRATION_PAGE;


@Controller
@RequiredArgsConstructor
public class CustomerController
{
	private final CustomerRepository customerRepository;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationPage(Model model)
	{
		model.addAttribute("customer", new Customer());
		model.addAttribute("customers", customerRepository.getAllCustomers());
		return REGISTRATION_PAGE;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(Customer customer, Model model)
	{
		customerRepository.add(customer);
		return registrationPage(model);
	}
}
