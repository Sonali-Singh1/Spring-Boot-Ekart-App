package com.simZipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SimZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimZipkinApplication.class, args);
	}

}
