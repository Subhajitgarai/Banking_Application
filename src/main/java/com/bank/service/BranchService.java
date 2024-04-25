package com.bank.service;

import com.bank.entites.Branch;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BranchService {
    public ResponseEntity<?> getAllBranchOfBank(int bankId);
    public Branch getSingleBranch(int bankId, int branchCode);
}
