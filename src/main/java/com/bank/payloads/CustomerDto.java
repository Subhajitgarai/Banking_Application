package com.bank.payloads;

import com.bank.entites.Account;
import com.bank.entites.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerPh;
    private String customerPass;
    private Account account;

}
