package com.esprit.reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReservationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationMsApplication.class, args);
	}

	
//	@Autowired
//	private ReservationRepository repository;
//	
//	@Bean
//	ApplicationRunner init() { 	//lancer lors de l'initialisation
//		return(args)->{
//			
//			String sDate="07-12-2021";  
//			Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(sDate);  
//			
//			repository.save(new Reservation(1,25,date1));
//			
//			//fetch
//			repository.findAll().forEach(System.out::println);
//			
//		};
//	}
}