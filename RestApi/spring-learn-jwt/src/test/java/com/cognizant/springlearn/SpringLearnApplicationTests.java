package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

	@Autowired
	private CountryController countryController;

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(countryController);
	}

	@Test
	public void testGetCountries() throws Exception {
		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/countries/country"));
		actions.andExpect(MockMvcResultMatchers.status().isOk());
		actions.andExpect(MockMvcResultMatchers.jsonPath("$.code").exists());
		actions.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("IN"));
	}

//	@Test
//	public void testGetCountryException() throws Exception{
//		ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/country"));
//		actions.andExpect(MockMvcResultMatchers.status().isBadRequest());
//		actions.andExpect(MockMvcResultMatchers.status().reason("Country not found"));
//	}

}
