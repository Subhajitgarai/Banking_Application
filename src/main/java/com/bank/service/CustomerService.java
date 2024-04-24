package com.bank.service;

import com.bank.payloads.CustomerDto;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    public CustomerDto createNewCustomer(CustomerDto customerDto,int branchCode);
    public ResponseEntity<?> getAllCustomer();
    public CustomerDto getCustomerById(int customerId);
    public CustomerDto getSingleCustomerByAccountNumber(String accountNumber);
    public String deleteCustomer(int customerId);
    public String depositAmount(String accountNumber, long accountBalance);
    public String withdrawalAmount(String accountNumber, long accountBalance);

}
