package com.bank.service;

import com.bank.entites.Bank;
import com.bank.entites.Branch;
import com.bank.exceptions.ResourceNotFound;
import com.bank.payloads.BankDto;
import com.bank.repository.BankRepo;
import com.bank.repository.BranchRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankServiceImpl implements BankService {
    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BranchRepo branchRepo;

    //Create a Bank
    public BankDto createBank(BankDto bankDto) {
        Bank bank = modelMapper.map(bankDto, Bank.class);
        Bank saved = bankRepo.save(bank);
        return modelMapper.map(saved, BankDto.class);
    }

    // Get all Banks
    public List<BankDto> getAllBanks() {
        List<Bank> allBanks = bankRepo.findAll();
        List<BankDto> bankDtos = new ArrayList<>();
        allBanks.forEach(bank -> {
            bankDtos.add(modelMapper.map(bank, BankDto.class));
        });
        return bankDtos;

    }

    //Get Single Bank
    public BankDto getSingleBank(int bankId) {
        Bank bank = bankRepo.findById(bankId).orElseThrow(() -> new ResourceNotFound("Bank", "bankId", bankId));
        return modelMapper.map(bank, BankDto.class);
    }

    //Add a branch
    public BankDto addBranch(int bankId, Branch branch) {
        Bank bank = bankRepo.findById(bankId).orElseThrow(() -> new ResourceNotFound("Bank", "bankId", bankId));
        List<Branch> branches = bank.getBranches();
        branches.add(branch);
        bank.setBranches(branches);
        Bank saved = bankRepo.save(bank);
        return modelMapper.map(saved, BankDto.class);
    }

    //Remove a branch
    public String removeBranch(int bankId, int branchCode) {
        Bank bank = bankRepo.findById(bankId).orElseThrow(() -> new ResourceNotFound("Bank", "bankId", bankId));
        Branch branch = branchRepo.findById(branchCode).orElseThrow(() -> new ResourceNotFound("Branch", "branchCode", branchCode));
        branchRepo.deleteById(branchCode);
        return "Branch with branchCode " + branchCode + " delete successfully !!";
    }
}
