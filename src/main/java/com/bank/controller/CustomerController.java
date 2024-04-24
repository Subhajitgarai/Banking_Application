package com.bank.controller;

import com.bank.payloads.CustomerDto;
import com.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/branch/{branchCode}")
    public ResponseEntity<CustomerDto> createNewCustomer(@RequestBody CustomerDto customerDto, @PathVariable int branchCode) {
        CustomerDto newCustomer = customerService.createNewCustomer(customerDto, branchCode);
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);

    }

    @GetMapping("/customer/")
    public ResponseEntity<?> getAllCustomerDetails() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerByCustomerId(@PathVariable int customerId) {
        CustomerDto customerById = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerById, HttpStatus.OK);
    }

    @GetMapping("/customer/account/{accountNumber}")
    public ResponseEntity<CustomerDto> getCustomerByAccountNumber(@PathVariable String accountNumber) {
        CustomerDto singleCustomerByAccountNumber = customerService.getSingleCustomerByAccountNumber(accountNumber);
        return new ResponseEntity<>(singleCustomerByAccountNumber, HttpStatus.OK);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable int customerId) {
        String msg = customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    //Deposit amount
    @PatchMapping("/customer/{accountNumber}/deposit")
    public ResponseEntity<String> depositBalance(@PathVariable String accountNumber, @Param("accountBalance") long accountBalance) {
        String msg = customerService.depositAmount(accountNumber, accountBalance);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    //Withdrawal amount
    @PatchMapping("/customer/{accountNumber}/withdraw")
    public ResponseEntity<String> withdrawAmount(@PathVariable String accountNumber, @Param("accountBalance") long accountBalance) {
        String msg = customerService.withdrawalAmount(accountNumber, accountBalance);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
