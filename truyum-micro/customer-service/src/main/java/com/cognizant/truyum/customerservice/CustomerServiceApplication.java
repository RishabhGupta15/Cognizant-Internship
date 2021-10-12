package com.cognizant.truyum.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate() {

		HttpComponentsClientHttpRequestFactory fac = new HttpComponentsClientHttpRequestFactory();
		fac.setConnectTimeout(5000);
		return new RestTemplate(fac);
	}

}
