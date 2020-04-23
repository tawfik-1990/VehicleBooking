package com.project.bookingcar.service;


import com.project.bookingcar.jpa.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.bookingcar.jpa.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
	
	
	@Autowired
    private VehicleRepository vehicleRepository;
	
	
	public Vehicle saveVehicle(final Vehicle vehicle) {
        Assert.notNull(vehicle);
        return vehicleRepository.saveAndFlush(vehicle);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findOne(final Long id) {
        Assert.notNull(id);
        return vehicleRepository.findById(id);
    }

    public Vehicle findByLicensePlate(final String licensePlate) {
        Assert.hasLength(licensePlate);
        return vehicleRepository.findByLicensePlate(licensePlate);
    }
	
	
	

}
