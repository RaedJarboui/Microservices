package com.esprit.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CandidateMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateMsApplication.class, args);
	}
	
/*	@Autowired
	private CandidatRepository repository;
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save
			repository.save(new Candidat("Mariem", "Ch", "ma@esprit.tn"));
			repository.save(new Candidat("Sarra", "ab", "sa@esprit.tn"));
			repository.save(new Candidat("Mohamed", "ba", "mo@esprit.tn"));
			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}
*/
}
