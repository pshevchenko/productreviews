package com.astound.presentation.productreviews.repository;

import com.astound.presentation.productreviews.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomerRepository
{
	private List<Customer> customers = new ArrayList<>();

	public List<Customer> getAllCustomers()
	{
		return customers;
	}

	public void add(Customer customer)
	{
		customers.add(customer);
	}

}
