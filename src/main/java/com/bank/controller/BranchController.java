package com.bank.controller;

import com.bank.entites.Branch;
import com.bank.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BranchController {
    @Autowired
    private BranchService branchService;
    @GetMapping("/bank/{bankId}/branch")
    public ResponseEntity<?> listOfAllBranch(@PathVariable int bankId){
       return branchService.getAllBranchOfBank(bankId);
    }
    @GetMapping("/bank/{bankId}/branch/{branchCode}")
    public Branch getSingleBranchOfBank(@PathVariable int bankId, @PathVariable int branchCode){
       return branchService.getSingleBranch(bankId,branchCode);
    }

}
