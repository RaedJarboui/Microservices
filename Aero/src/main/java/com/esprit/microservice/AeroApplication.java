package com.esprit.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.esprit.microservice.controller", "com.esprit.microservice.service"})
@EntityScan("com.esprit.microservice.entity")
@EnableJpaRepositories("com.esprit.microservice.repository")
public class AeroApplication {

	public static void main(String[] args) {

		SpringApplication.run(AeroApplication.class, args);
	}

}
