package com.eurekha.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SimEurekhaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimEurekhaDiscoveryServerApplication.class, args);
	}

}
