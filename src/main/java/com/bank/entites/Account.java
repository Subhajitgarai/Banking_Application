package com.bank.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
    @Id
    private String accountNumber;
    private long accountBalance;
    private String accountType;

}
