package com.bank.security;

import com.bank.entites.Customer;
import com.bank.exceptions.ResourceNotFound;
import com.bank.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepo.findByCustomerPh(username).orElseThrow(() -> new ResourceNotFound("Customer", "customerPh", username));
    }
}
