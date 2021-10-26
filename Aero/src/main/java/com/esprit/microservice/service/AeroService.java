/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entity.Aero;
import com.esprit.microservice.repository.AeroRepository;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class AeroService {
	@Autowired
	private AeroRepository aeroRepository;

	public Aero addAero(Aero a) {

		return aeroRepository.save(a);

	}

	public List<Aero> getAllAero() {

		return aeroRepository.findAll();
	}

	public String deleteAero(int id) {

		if (aeroRepository.findById(id).isPresent()) {
			aeroRepository.deleteById(id);
			return "aero supprimé";
		}
		else
			return " aero non supprimé";
	}

	public Aero updateAero(int id, Aero a) {

		if (aeroRepository.findById(id).isPresent()) {
			Aero existingAero = aeroRepository.findById(id).get();
			existingAero.setNom(a.getNom());
			existingAero.setPays(a.getPays());
			existingAero.setVille(a.getVille());
			return aeroRepository.save(existingAero);

		}
		else
			return null;

	}
	public Aero getAeroById(int id) {
		Aero aero= aeroRepository.findById(id).get();
		return aero;
	}

}
