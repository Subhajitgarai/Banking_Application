package com.bank.service;

import com.bank.entites.Account;
import com.bank.entites.Branch;
import com.bank.entites.Customer;
import com.bank.entites.Role;
import com.bank.exceptions.ResourceNotFound;
import com.bank.payloads.CustomerDto;
import com.bank.repository.AccountRepo;
import com.bank.repository.BranchRepo;
import com.bank.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private AccountRepo accountRepo;

    //Create new Customer
    @Override
    public CustomerDto createNewCustomer(CustomerDto customerDto, int branchCode) {
        Account account = new Account();
        account.setAccountBalance(0);
        account.setAccountType("Savings");
        account.setAccountNumber(UUID.randomUUID().toString());
        Branch branch = branchRepo.findById(branchCode).orElseThrow(() -> new ResourceNotFound("Branch", "branchCode", branchCode));
        List<Account> accountList = new ArrayList<>(branch.getAccounts());
        accountList.add(account);
        branch.setAccounts(accountList);
        branchRepo.save(branch);
        customerDto.setAccount(modelMapper.map(account, Account.class));
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Role role=new Role();
        role.setRoleId(2);
        role.setRoleName("ROLE_NORMAL");
        customer.setRoles(Collections.singletonList(role));
        customerRepo.save(customer);
        return customerDto;

    }

    //Get All Customer
    @Override
    public ResponseEntity<?> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        if (all.isEmpty()) {
            return new ResponseEntity<>("No Customer Present !!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
    }

    //Get Single Customer by CustomerId
    @Override
    public CustomerDto getCustomerById(int customerId) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFound("Customer", "customerId", customerId));
        return modelMapper.map(customer, CustomerDto.class);
    }

    //Get Customer by accountNumber
    @Override
    public CustomerDto getSingleCustomerByAccountNumber(String accountNumber) {
        Customer customerByAccountNumber = customerRepo.getCustomerByAccountNumber(accountNumber);
        return modelMapper.map(customerByAccountNumber, CustomerDto.class);
    }

    //Delete a Customer
    @Override
    public String deleteCustomer(int customerId) {
        customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFound("Customer", "customerId", customerId));
        customerRepo.deleteById(customerId);
        return "Customer with id " + customerId + " is deleted Successfully !!";
    }
    //Deposit Amount in bank account
    @Override
    public String depositAmount(String accountNumber, long accountBalance){
        Account account = accountRepo.findById(accountNumber).orElseThrow(() -> new ResourceNotFound("Account", "accountNumber", accountNumber));
        long currentBalance = account.getAccountBalance();
        long updatedBalance=currentBalance+accountBalance;
        account.setAccountNumber(account.getAccountNumber());
        account.setAccountBalance(updatedBalance);
        accountRepo.save(account);
        return "Balance Updated your Current balance is ="+updatedBalance+"\nYour Previous balance was ="+currentBalance;
    }
    //WithdrawalAmount
    @Override
    public String withdrawalAmount(String accountNumber, long accountBalance) {
        Account account = accountRepo.findById(accountNumber).orElseThrow(() -> new ResourceNotFound("Account", "accountNumber", accountNumber));
        long currentBalance = account.getAccountBalance();
        if (currentBalance<accountBalance){
            return "Low Balance Sorry !!";
        }
        else {
            long updatedBalance=currentBalance-accountBalance;
            account.setAccountNumber(account.getAccountNumber());
            account.setAccountBalance(updatedBalance);
            accountRepo.save(account);
            return "Balance Withdrawal Successful Your Current Balance is ="+updatedBalance+"\nYour Previous Balance was= "+currentBalance;
        }

    }

}
