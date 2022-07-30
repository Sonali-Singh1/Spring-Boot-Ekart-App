package com.user;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.user.dto.UserDto;
import com.user.service.UserService;

@SpringBootApplication
@EnableDiscoveryClient
public class UserMsApplication implements CommandLineRunner {
    @Autowired
    UserService service;
	public static void main(String[] args) {
		SpringApplication.run(UserMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserDto user=new UserDto(1,"John",9616567834L,"john@abc.com","john123","M",LocalDate.of(1998, 05, 23),"Delhi","Delhi","India",567892L);
		service.addData(user);
	}
	

} 
