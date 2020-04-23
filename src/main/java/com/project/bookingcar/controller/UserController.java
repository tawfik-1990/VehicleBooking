package com.project.bookingcar.controller;


import com.project.bookingcar.jpa.domain.User;
import com.project.bookingcar.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/v1/users")


public class UserController {
	
	 private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
       log.debug("Getting all users");
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        Optional<User> optionalUser = userService.findById(id);
        return optionalUser.orElseThrow(
                () -> new NoSuchElementException("No user found with id " + id)
        );
    }
    
    @RequestMapping(params = "lastName", method = RequestMethod.GET)
    public User getByLastName(@RequestParam("lastName") final String lastName) {
        log.debug("Get user by last name");
        return userService.findByLastName(lastName);
    }


}
