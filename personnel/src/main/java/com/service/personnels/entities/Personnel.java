package com.service.personnels.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Personnel implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom, prenom, email, adresse, departement;
	private int numTel;

	public Personnel(String nom, String prenom, String email, String adresse, String departement,
			int numTel) {

		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.departement = departement;
		this.numTel = numTel;
	}

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
	 * @return the prenom
	 */
	public String getPrenom() {

		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {

		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {

		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {

		this.email = email;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {

		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {

		this.adresse = adresse;
	}

	/**
	 * @return the departement
	 */
	public String getDepartement() {

		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(String departement) {

		this.departement = departement;
	}

	/**
	 * @return the numTel
	 */
	public int getNumTel() {

		return numTel;
	}

	/**
	 * @param numTel the numTel to set
	 */
	public void setNumTel(int numTel) {

		this.numTel = numTel;
	}

}
