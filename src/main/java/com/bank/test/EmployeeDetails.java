package com.bank.test;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EmployeeDetails {
    private int employeeID;
    private String employeeName;
    private String employeeDept;
    private Long salary;
}
