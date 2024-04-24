package com.bank.service;

import com.bank.entites.Branch;
import com.bank.exceptions.ResourceNotFound;
import com.bank.repository.BankRepo;
import com.bank.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private BankRepo bankRepo;

    //Get All Branch
    public ResponseEntity<?> getAllBranchOfBank(int bankId) {
        bankRepo.findById(bankId).orElseThrow(() -> new ResourceNotFound("Bank", "bankId", bankId));
        List<Branch> all = branchRepo.findAll();
        if (all.isEmpty()) {
            return new ResponseEntity<>("Sorry no branches of that bank is present !!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }

    }

    //Get Single-branch of a bank
    public Branch getSingleBranch(int bankId, int branchCode) {
        bankRepo.findById(bankId).orElseThrow(() -> new ResourceNotFound("Bank", "bankId", bankId));
        return branchRepo.findById(branchCode).orElseThrow(() -> new ResourceNotFound("Branch", "branchCode", branchCode));

    }

}
