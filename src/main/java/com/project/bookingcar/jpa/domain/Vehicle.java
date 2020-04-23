package com.project.bookingcar.jpa.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Vehicle implements Serializable , Persistable <Long>{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @Column(unique = true)
    private String licensePlate;
   
    private String vin;
    
    private String model;
    
    @NotNull(message = "Value may not be null")
    private Boolean active;
  
    
    private String color;
    @NotNull(message = "Value may not be null")
    @Future(message = "Date should be in the future")
    private LocalDate validTill;

   

    public Vehicle() {
    }
    
    
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
    
    
    public Vehicle(final String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(final String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(final String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public LocalDate getValidTill() {
        return validTill;
    }

    public void setValidTill(final LocalDate validTill) {
        this.validTill = validTill;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Vehicle vehicle = (Vehicle) o;
        return Objects.equals(licensePlate, vehicle.licensePlate) &&
                Objects.equals(vin, vehicle.vin) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(active, vehicle.active) &&
                Objects.equals(color, vehicle.color) &&
                Objects.equals(validTill, vehicle.validTill);
    }

  



    @JsonIgnore
    public boolean isNew() {
        return null == getId();
    }
}