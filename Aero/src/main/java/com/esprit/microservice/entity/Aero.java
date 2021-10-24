/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.esprit.microservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Entity

public class Aero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3090249096008711398L;
	@Id
	@GeneratedValue
	private int id;
	private String nom, pays, ville;

	/**
	 * @return the id
	 */
	public int getId() {

		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {

		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {

		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {

		this.nom = nom;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {

		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {

		this.pays = pays;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {

		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {

		this.ville = ville;
	}

	/**
	 * @param id
	 * @param nom
	 * @param pays
	 * @param ville
	 */
	public Aero(int id, String nom, String pays, String ville) {

		super();
		this.id = id;
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
	}

	public Aero() {

		super();
	}

}
