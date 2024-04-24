package com.bank.controller;

import com.bank.entites.Branch;
import com.bank.payloads.BankDto;
import com.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {
    //Create bank
    @Autowired
    private BankService bankService;
    @PostMapping("/")
    public ResponseEntity<BankDto>addBank(@RequestBody BankDto bankDto){
        BankDto bank = bankService.createBank(bankDto);
        return new ResponseEntity<>(bank, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<BankDto>> getAllBanks(){
        List<BankDto> allBanks = bankService.getAllBanks();
        return new ResponseEntity<>(allBanks,HttpStatus.OK);
    }
    @GetMapping("/{bankId}")
    public ResponseEntity<BankDto> getBankById(@PathVariable int bankId){
        BankDto singleBank = bankService.getSingleBank(bankId);
        return new ResponseEntity<>(singleBank,HttpStatus.OK);
    }
    @PostMapping("/{bankId}/addBranch")
    public ResponseEntity<BankDto> addNewBranch(@PathVariable int bankId, @RequestBody Branch branch){
        BankDto bankDto = bankService.addBranch(bankId, branch);
        return new ResponseEntity<>(bankDto,HttpStatus.OK);
    }
    @DeleteMapping("/{bankId}/removeBranch/{branchCode}")
    public ResponseEntity<String> deleteBranch(@PathVariable int bankId, @PathVariable int branchCode){
        String msg = bankService.removeBranch(bankId, branchCode);
        return new ResponseEntity<>(msg,HttpStatus.OK);

    }
}
