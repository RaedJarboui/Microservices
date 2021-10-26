package com.service.personnels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
public class PersonnelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonnelApplication.class, args);
	}

	
}
