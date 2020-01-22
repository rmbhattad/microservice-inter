package com.infy.springboot.microservice.microserviceinter.springbootmicroserviceinterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.infy.springboot.microservice.microserviceinter.springbootmicroserviceinterservice")
public class SpringBootMicroserviceInterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceInterServiceApplication.class, args);
	}

}
