package com.bank.service;

import com.bank.entites.Branch;
import com.bank.payloads.BankDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {
    public BankDto createBank(BankDto bankDto);
    public List<BankDto> getAllBanks();
    public BankDto getSingleBank(int bankId);
    public BankDto addBranch(int bankId, Branch branch);
    public String removeBranch(int bankId, int branchCode);

}
