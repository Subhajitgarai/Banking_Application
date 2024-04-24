package com.bank.payloads;

import com.bank.entites.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankDto {
    private int bankId;
    private String bankName;
    private String bankCode;
    private List<BranchDto>branches;

}
