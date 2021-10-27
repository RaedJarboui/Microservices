
package com.esprit.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entity.Aero;
import com.esprit.microservice.service.AeroService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/aero")
public class AeroController {
	private String title = "Hello,I'm the aero Microservice";
	@Autowired
	AeroService aeroService;

	@RequestMapping("/hello")
	public String sayHello() {

		System.out.println(title);
		return title;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Aero> createAero(@RequestBody Aero a) {

		return new ResponseEntity<>(aeroService.addAero(a), HttpStatus.OK);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Aero>> getAeros() {

		return new ResponseEntity<>(aeroService.getAllAero(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Aero updateAero(@PathVariable(value = "id") int id, @RequestBody Aero a) {

		return aeroService.updateAero(id, a);
	}

	@DeleteMapping("/{id}")
	public void deleteAero(@PathVariable(value = "id") int id) {

		aeroService.deleteAero(id);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Aero> getAeroById(@PathVariable("id") int id) {

		return new ResponseEntity<>(aeroService.AeroById(id), HttpStatus.OK);
	}

}
