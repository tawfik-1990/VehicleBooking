package com.project.bookingcar.jpa.repository;


import com.project.bookingcar.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;



@Repository
public interface Userrepository extends JpaRepository<User, Long>{
	
	
	User findByEmail(String email);
	
    User findByLastName(String lastName);
	
    User findByFirstName(String lastName);

}
