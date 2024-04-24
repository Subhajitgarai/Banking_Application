package com.bank.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Branch {
    @Id
    private int branchCode;
    private String branchCity;
    @OneToMany(targetEntity = Account.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_code",referencedColumnName ="branchCode")
    private List<Account>accounts;
}
