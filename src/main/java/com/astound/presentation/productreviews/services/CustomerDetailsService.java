package com.astound.presentation.productreviews.services;

import com.astound.presentation.productreviews.entities.Customer;
import com.astound.presentation.productreviews.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired private CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Customer> customer = repository.findByLogin(login);
        if (!customer.isPresent()) {
            throw new UsernameNotFoundException("User not found.");
        }
        return customer.get();
    }
}
