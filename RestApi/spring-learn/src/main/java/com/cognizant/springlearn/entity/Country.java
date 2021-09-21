package com.cognizant.springlearn.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {
    @NotNull
    @Size(min = 2, max = 2, message = "country code should be two characters")
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
    