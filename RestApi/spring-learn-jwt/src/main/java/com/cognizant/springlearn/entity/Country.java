package com.cognizant.springlearn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Country {
    @NotNull
    @Size(min = 2, max = 2, message = "country code should be two characters")
    private String code;
    private String name;

}
