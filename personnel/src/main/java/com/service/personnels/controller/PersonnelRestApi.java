package com.service.personnels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.service.personnels.Service.PersonnelService;
import com.service.personnels.entities.Personnel;

@RestController
//@RequestMapping(value="/api/personnels")
public class PersonnelRestApi {



	@Autowired
	private PersonnelService personnelService;



	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Personnel> createPersonnel(@RequestBody Personnel personnel){
		return new ResponseEntity<>(personnelService.addPersonnel(personnel),HttpStatus.OK);
	}

	@GetMapping(value="personnel/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Personnel>  getPersonnelById(@PathVariable("id") int id){
		return new ResponseEntity<>(personnelService.getPersonnelById(id),HttpStatus.OK);
		}
	
	
	/*@GetMapping(value="/getAllpersonnels")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Personnel> getAllPersonnel(){
		return new ResponseEntity<>(personnelService.getAllPersonnel(),HttpStatus.OK);
		}*/

	@PutMapping(value="personnel/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Personnel> updatePersonnel(@PathVariable(value="id") int id, @RequestBody Personnel  personnel){
		return new ResponseEntity<>(personnelService.updatePersonnel(id, personnel),HttpStatus.OK);
	}

	@DeleteMapping(value="personnel/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deletepersonnel(@PathVariable(value="id") int id){
		return new ResponseEntity<>(personnelService.deletePersonnel(id),HttpStatus.OK);
	}
}
