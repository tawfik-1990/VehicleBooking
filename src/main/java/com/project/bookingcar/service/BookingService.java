package com.project.bookingcar.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.project.bookingcar.jpa.domain.Booking;
import com.project.bookingcar.jpa.domain.Vehicle;
import com.project.bookingcar.jpa.repository.BookingRepository;
import com.project.bookingcar.jpa.repository.Userrepository;
import com.project.bookingcar.jpa.repository.VehicleRepository;


@Service
public class BookingService {
	
	@Autowired
    private BookingRepository bookingRepository;

	 @Autowired
	 private VehicleRepository vehicleRepository;

	  @Autowired
	  private Userrepository userRepository;

	 public List<Booking> findAll() {
	        return bookingRepository.findAll();
	    }

	 
	 public Optional<Booking> findById(final Long id) {
	      
	        return bookingRepository.findById(id);
	    }

	    
	 
	 
	    public Booking booking(final Booking booking) {

	        if (!isBookable(booking)) {
	            throw new IllegalArgumentException("User does not exist or vehicle cannot be booked.");
	        }

	        return bookingRepository.saveAndFlush(booking);
	    }
	 
	
	 
	 
	 private boolean isBookable(final Booking booking) {
	        final Long bookingId = booking.getUser().getId();
	        final Long vehicleId = booking.getVehicle().getId();
	        if (userRepository.existsById(bookingId) && vehicleRepository.existsById(vehicleId)) {
	            final Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);

	            return  !alreadyBooked(booking);
	        }

	        return false;
	    }

	 
	   private boolean alreadyBooked(final Booking pendingBooking) {
	      List <Booking> allBookingsForVehiclesWithStatus = bookingRepository.findByVehicle(pendingBooking.getVehicle());
	        for (final Booking booking : allBookingsForVehiclesWithStatus) {
	            if (booking.getBegin().after(pendingBooking.getBegin()) && booking.getBegin().before(pendingBooking.getEnd())) {
	                return true;
	            }
	        }
	        return false;
	    }
}
