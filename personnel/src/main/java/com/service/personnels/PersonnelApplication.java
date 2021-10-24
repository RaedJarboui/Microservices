package com.service.personnels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.service.personnels.controller", "com.service.personnels.Service"})
@EntityScan("com.service.personnels.entities")
@EnableJpaRepositories("com.service.personnels.Repositorie")
@EnableEurekaClient
public class PersonnelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonnelApplication.class, args);
	}

	
}
