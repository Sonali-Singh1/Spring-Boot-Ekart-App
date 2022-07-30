package com.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("/userServiceFallback")
	public String UserServiceFallback() {
		return "User service is down at this time !!";
	}
	@GetMapping("/productServiceFallback")
	public String ProductServiceFallback() {
		return "Product service is down at this time !!";
	}
	@GetMapping("/cardServiceFallback")
	public String CardServiceFallback() {
		return "Card service is down at this time !!";
	}
}
