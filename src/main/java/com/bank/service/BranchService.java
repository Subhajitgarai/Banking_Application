package com.bank.service;

import com.bank.entites.Branch;
import org.springframework.http.ResponseEntity;

public interface BranchService {
    public ResponseEntity<?> getAllBranchOfBank(int bankId);
    public Branch getSingleBranch(int bankId, int branchCode);
}
