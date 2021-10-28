package com.esprit.reservations.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.reservations.entity.Reservation;
import com.esprit.reservations.repository.ReservationRepository;

@Service
public class ReservationRestAPI {
	
	@Autowired ReservationRepository reservationRepository;
	

	public List<Reservation> getAeroports() {
		return reservationRepository.findAll();
	}

	public Reservation getAeroportById(int id) {
		return reservationRepository.findById(id).orElse(null);
	}
	
	public Reservation addReservation( Reservation reservation) {
		
		reservation.getIdClient();
		reservation.getIdVol();
		reservation.getDateReservation();
		
		return reservationRepository.save(reservation);
	}
	
	public Reservation updateReservation(int id, Reservation reservation) {
		if (reservationRepository.findById(id).isPresent()) {
			Reservation existingReservation = reservationRepository.findById(id).get();
			existingReservation.setDateReservation(reservation.getDateReservation());
			return reservationRepository.save(existingReservation);
		} else {
			return null;
		}
	}
	
	public String deleteReservation(int id) {
		if (reservationRepository.findById(id).isPresent()) {
			reservationRepository.deleteById(id);	
			return "Reservation supprimée.";
		} else {
			return "Reservation n'existe pas";
		}
	}
	


	public List<Reservation> getAllReservation() {
		List<Reservation> reservations= reservationRepository.findAll();
		return reservations;
	}
}	
