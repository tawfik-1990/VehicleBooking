package com.project.bookingcar.jpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookingcar.jpa.domain.Booking;
import com.project.bookingcar.jpa.domain.Vehicle;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	List <Booking> findByVehicle (Vehicle vehicle);

}
