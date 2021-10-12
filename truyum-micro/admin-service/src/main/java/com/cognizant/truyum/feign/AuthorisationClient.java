package com.cognizant.truyum.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
@FeignClient(name = "auth-service", url = "${AUTH_SERVICE:http://localhost:8084}")
public interface AuthorisationClient {

	@GetMapping("/auth/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);
}
