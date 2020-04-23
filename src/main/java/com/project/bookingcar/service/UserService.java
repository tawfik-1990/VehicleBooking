package com.project.bookingcar.service;

import com.project.bookingcar.jpa.domain.User;
import com.project.bookingcar.jpa.repository.Userrepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import javax.ws.rs.NotFoundException;


@Service

public class UserService {

	
	@Autowired
    private Userrepository userRepository;

	    public User saveUser(User user) {
	        Assert.notNull(user, "User must not be null");
	        return userRepository.saveAndFlush(user);
	    }

	    public List<User> findAll() {
	        return userRepository.findAll();
	    }

	    public Optional<User> findById(Long id) {
	        Assert.notNull(id, "Id must not be null");
	        return userRepository.findById(id);
	    }

	    public User findByEmail(String email) {
	        Assert.hasLength(email, "Email must not be empty");
	        return userRepository.findByEmail(email);
	    }
	    
	    public User findByLastName(final String lastName) {
	    	Assert.hasLength(lastName, "lastName must not be empty");
	        final User UserLastName = userRepository.findByLastName(lastName);
	        if (UserLastName == null) {
	            throw new NotFoundException("No user with this last name.");
	        } else {
	            return UserLastName;
	        }
	    }
	    
	    
	    public User findByFirstName(final String lastName) {
	    	Assert.hasLength(lastName, "lastName must not be empty");
	        final User UserLastName = userRepository.findByLastName(lastName);
	        if (UserLastName == null) {
	            throw new NotFoundException("No user with this last name.");
	        } else {
	            return UserLastName;
	        }
	    }
}
