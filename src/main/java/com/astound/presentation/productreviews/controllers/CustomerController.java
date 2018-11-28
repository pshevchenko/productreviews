package com.astound.presentation.productreviews.controllers;

import com.astound.presentation.productreviews.entities.Customer;
import com.astound.presentation.productreviews.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static com.astound.presentation.productreviews.controllers.ControllerConstants.ERROR_PAGE;
import static com.astound.presentation.productreviews.controllers.ControllerConstants.REGISTRATION_PAGE;


@Controller
@RequiredArgsConstructor
public class CustomerController
{
	private final CustomerRepository customerRepository;
	private final PasswordEncoder encoder;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationPage(Model model)
	{
		model.addAttribute("customer", new Customer());
		return REGISTRATION_PAGE;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(Customer customer, Model model, HttpSession session) throws IOException {
		boolean loginIsBusy = customerRepository.getAllCustomers().stream()
				.anyMatch(customer1 -> customer1.getLogin().equals(customer.getLogin()));

		if (loginIsBusy)
		{
			return ERROR_PAGE;
		}

		customer.setBinaryRoles(1);
		customer.setEnable(true);
		customer.setPassword(encoder.encode(customer.getPassword()));
		customerRepository.add(customer);
		System.out.println("registered successfully");

		Authentication authentication = new UsernamePasswordAuthenticationToken(customer, null, customer.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		session.setAttribute("username", customer.getLogin());
		return registrationPage(model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
}
