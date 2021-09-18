package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Country {

	private String code;
	private String name;
	@Override
	public String toString() {
		return "\n code=" + code + ", name=" + name;
	}
	
}
