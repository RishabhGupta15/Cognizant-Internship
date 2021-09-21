package com.cognizant.springlearn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class Employee {
    @NotNull
    private int id;
    @NotNull
    @Size(min = 1, max = 30)
    private String name;
    @NotNull
    @Positive
    private double salary;
    @NotNull
    private boolean isPermanent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Department department;

}
