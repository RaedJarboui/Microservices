package com.esprit.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.reservations.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
}
