package com.learn.customer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "customer-service");
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
