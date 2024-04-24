package com.bank.payloads;

import com.bank.entites.Account;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BranchDto {
    @Id
    private int branchCode;
    private String branchCity;
    private List<AccountDto>accounts;

}
