package com.bank.repository;

import com.bank.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    @Query("SELECT c FROM Customer c WHERE c.account.accountNumber = :accountNumber")
    public Customer getCustomerByAccountNumber(String accountNumber);
    public Optional<Customer>findByCustomerPh(String customerPh);
}
