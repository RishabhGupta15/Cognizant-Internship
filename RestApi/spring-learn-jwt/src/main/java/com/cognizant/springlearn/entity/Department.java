package com.cognizant.springlearn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Department {
    @NotNull
    private int id;
    @NotNull
    @Size(min = 1, max = 30)
    private String name;
}
