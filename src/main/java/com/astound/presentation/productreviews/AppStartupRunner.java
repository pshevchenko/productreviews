package com.astound.presentation.productreviews;

import com.astound.presentation.productreviews.entities.Authority;
import com.astound.presentation.productreviews.entities.Category;
import com.astound.presentation.productreviews.entities.Customer;
import com.astound.presentation.productreviews.entities.Product;
import com.astound.presentation.productreviews.repository.CategoryRepository;
import com.astound.presentation.productreviews.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


@Component
@RequiredArgsConstructor
@ConditionalOnProperty(value = "import.testdata", havingValue = "true")
public class AppStartupRunner implements ApplicationRunner
{
	@PostConstruct
	public void onStartUp()
	{
		System.out.println(
				"--------------------------------AppStartupRunner loaded-------------------------------------------------------");
	}

	private final CategoryRepository categoryRepository;
	private final CustomerRepository customerRepository;
	private final PasswordEncoder encoder;

	@Override
	public void run(ApplicationArguments args)
	{
		System.out.println("test data imported");

		//Category 1
		Category category1 = Category.builder().id(1).name("Category 1").description("desc").build();

		Product product1 = Product.builder().id(1).name("Product 1").description("desc").build();
		Product product2 = Product.builder().id(2).name("Product 2").description("desc").build();
		Product product3 = Product.builder().id(3).name("Product 3").description("desc").build();

		product1.setReviews(new ArrayList<>());
		product2.setReviews(new ArrayList<>());
		product3.setReviews(new ArrayList<>());

		category1.setProducts(Arrays.asList(product1, product2, product3));

		categoryRepository.getCategories().add(category1);

		//Category 2
		Category category2 = Category.builder().id(2).name("Category 2").description("desc").build();

		Product product4 = Product.builder().id(4).name("Product 4").description("desc").build();
		Product product5 = Product.builder().id(5).name("Product 5").description("desc").build();

		product4.setReviews(new ArrayList<>());
		product5.setReviews(new ArrayList<>());

		category2.setProducts(Arrays.asList(product4, product5));

		categoryRepository.getCategories().add(category2);

		createCustomers();
		printRoles();
	}

	private void createCustomers() {
		Customer user = new Customer("user", "user", encoder.encode("user"), 1L, true);
		Customer support = new Customer("support", "support", encoder.encode("support"), 2L, true);
		Customer admin = new Customer("admin", "admin", encoder.encode("admin"), 7L, true);

		customerRepository.add(user);
		customerRepository.add(support);
		customerRepository.add(admin);
	}

	private void printRoles() {
		LongStream.range(1, 8).forEach(value -> {
			System.out.println("value: "+value+", roles: "+Arrays.stream(Authority.values())
					.filter(authority -> (value & (1 << authority.ordinal())) != 0)
					.collect(Collectors.toList()));
		});
	}
}
