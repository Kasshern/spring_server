package com.revature.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Boolean existsByUsername(String username);
    User findByUsernameIgnoreCase(String username);
	// JpaRepository's fluent API - Spring Data reads the method name, parses it for keywords
		// and automatically implements a method that works.
//		Page<User> save(Pageable pageable);
}
