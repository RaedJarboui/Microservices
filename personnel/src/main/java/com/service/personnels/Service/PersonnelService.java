package com.service.personnels.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.personnels.Repositorie.PersonnelRepository;
import java.util.List;
import com.service.personnels.entities.Personnel;

@Service
public class PersonnelService {

	@Autowired
	private PersonnelRepository personnelRepo;

	public Personnel addPersonnel(Personnel personnel) {
		return personnelRepo.save(personnel);
	}

	public Personnel updatePersonnel(int id ,Personnel newpersonnel) {
		if (personnelRepo.findById(id).isPresent()) {
			Personnel existingPersonnel=personnelRepo.findById(id).get();
			existingPersonnel.setNom(newpersonnel.getNom());
			existingPersonnel.setPrenom(newpersonnel.getPrenom());
			existingPersonnel.setAdresse(newpersonnel.getAdresse());
			existingPersonnel.setEmail(newpersonnel.getEmail());
			existingPersonnel.setNumTel(newpersonnel.getNumTel());
			existingPersonnel.setDepartement(newpersonnel.getDepartement());
			return personnelRepo.save(existingPersonnel);
		}else 
			return null;
	}


	public String deletePersonnel(int id) {
		if(personnelRepo.findById(id).isPresent()) {
			personnelRepo.deleteById(id);
			return "personnel supprimé";
		}
		else return "personnel non supprimé";

	}

	public Personnel getPersonnelById(int id) {
		Personnel personnel= personnelRepo.findById(id).get();
		return personnel;
	}


	public List<Personnel> getAllPersonnel() {
		List<Personnel> personnels= personnelRepo.findAll();
		return personnels;
	}
}
