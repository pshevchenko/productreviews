package com.astound.presentation.productreviews;

import com.astound.presentation.productreviews.entities.Customer;
import com.astound.presentation.productreviews.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@ConditionalOnProperty(value = "import.testdata.admin",
		havingValue = "true")
public class TestCustomerImporter implements ApplicationRunner
{
	private final CustomerRepository customerRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		customerRepository.add(Customer.builder().login("admin").password("nimda").name("God").build());
	}
}
