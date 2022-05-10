package com.microservice.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBookApplication.class, args);
	}

}
