package com.esprit.reservations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.reservations.entity.Reservation;
import com.esprit.reservations.repository.ReservationRepository;

@Service
public class ReservationRestAPI {
	
	@Autowired ReservationRepository reservationRepository;
	
	public Reservation addReservation( Reservation reservation) {
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
}	
