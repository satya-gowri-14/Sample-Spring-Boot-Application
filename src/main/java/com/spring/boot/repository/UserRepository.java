package com.spring.boot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.boot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

	
	List<User> findByDesignation(String designation);


	List<User> findByActive(boolean active);

	

}
