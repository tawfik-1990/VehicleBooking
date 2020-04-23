package com.project.bookingcar;

import com.project.bookingcar.jpa.domain.User;
import com.project.bookingcar.jpa.domain.Vehicle;
import com.project.bookingcar.jpa.domain.Booking;


import com.project.bookingcar.service.UserService;
import com.project.bookingcar.service.VehicleService;
import com.project.bookingcar.service.BookingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;


import java.text.ParseException;
import java.util.Date;
@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequiredArgsConstructor
public class TestData {
	
	@Autowired
    private UserService userService;
   
	@Autowired
    private VehicleService vehicleService;

	@Autowired
    private BookingService bookingService;
	
    @PostConstruct
    public void insertTestData() {
    	
    	User testUser1 = new User();
        testUser1.setEmail("tawfik@user.com");
        testUser1.setFirstName("Max");
        testUser1.setLastName("Power");
        testUser1.setBirthday(LocalDate.parse("1980-12-12"));

        userService.saveUser(testUser1);



        User testUser2 = new User();
        testUser2.setEmail("test2@user.com");
        testUser2.setFirstName("James");
        testUser2.setLastName("Bond");
        testUser2.setBirthday(LocalDate.parse("1985-12-12"));

        userService.saveUser(testUser2);
        
        
        Vehicle testVehicle1 = new Vehicle();
        testVehicle1.setLicensePlate("IN-1234");
        testVehicle1.setModel("S4");
        testVehicle1.setColor("red");
        testVehicle1.setActive(true);
        testVehicle1.setVin("8765-4321");
        testVehicle1.setValidTill(LocalDate.now().plusDays(1));

        vehicleService.saveVehicle(testVehicle1);


   
        Vehicle testVehicle2 = new Vehicle();
        testVehicle2.setLicensePlate("IN-5678");
        testVehicle2.setModel("Q3");
        testVehicle2.setColor("black");
        testVehicle2.setActive(true);
        testVehicle2.setVin("1234-4321");
        testVehicle2.setValidTill(LocalDate.now().plusDays(1));

        vehicleService.saveVehicle(testVehicle2);
        
        
        final Date NOW = new Date();
        final Booking booking = new Booking();
        booking.setUser(testUser2 );
        booking.setVehicle(testVehicle1);
        booking.setBegin(NOW);
        booking.setEnd(DateUtils.addHours(NOW, 24));
        bookingService.booking(booking);
        
    }

   
    
  
}
