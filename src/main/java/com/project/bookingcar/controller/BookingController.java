package com.project.bookingcar.controller;


import com.project.bookingcar.jpa.domain.Booking;
import com.project.bookingcar.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
	
	
	@Autowired
    private BookingService bookingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Booking> fetchAll() {
        return bookingService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Booking> fetchById(@PathVariable final Long id) {
        return bookingService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Booking save(@RequestBody final Booking booking) {
        return bookingService.booking(booking);
    }
    
    
    
}
