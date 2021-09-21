package com.cognizant.springlearn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private double salary;
    private boolean isPermanent;
    private Department department;

}
