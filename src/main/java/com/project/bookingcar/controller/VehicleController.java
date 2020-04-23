package com.project.bookingcar.controller;


import com.project.bookingcar.jpa.domain.Vehicle;
import com.project.bookingcar.service.VehicleService;

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
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

   

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> fetchAll() {
        return vehicleService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Vehicle> fetchById(@PathVariable("id")  Long id) {
        return vehicleService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle save(@RequestBody final Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }
}