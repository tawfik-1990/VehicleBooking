package com.project.bookingcar.jpa.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class Booking implements Serializable , Persistable <Long>{
	
	
	
	 
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	 @NotNull(message = "Value may not be null")
	    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	    private Vehicle vehicle;
	    @NotNull(message = "Value may not be null")
	    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	    private User user;
	   
	    @NotNull(message = "Value may not be null")
	    private Date begin;
	    @NotNull(message = "Value may not be null")
	    private Date end;
	    
	    public Booking () {
	    }
	    
	    @Override
	    public Long getId() {
	        return id;
	    }

	    public void setId(final Long id) {
	        this.id = id;
	    }

	    public Vehicle getVehicle() {
	        return vehicle;
	    }

	    public void setVehicle(final Vehicle vehicle) {
	        this.vehicle = vehicle;
	    }

	    public User getUser() {
	        return user;
	    }

	    public void setUser(final User user) {
	        this.user = user;
	    }


	    public Date getBegin() {
	        return begin;
	    }

	    public void setBegin(final Date begin) {
	        this.begin = begin;
	    }

	    public Date getEnd() {
	        return end;
	    }

	    public void setEnd(final Date end) {
	        this.end = end;
	    }

	 
	    @JsonIgnore
	    public boolean isNew() {
	        return null == getId();
	    } 
}	    
	    
