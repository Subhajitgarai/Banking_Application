package com.bank.entites;

import com.bank.payloads.BranchDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;
    private String bankName;
    private String bankCode;
    @OneToMany(targetEntity = Branch.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id",referencedColumnName = "bankId")
    private List<Branch>branches;
}
