package com.exxeta.ebm.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.exxeta.ebm.database.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	Page<User> findAll(Pageable pageable);
	
	User findByUsername(String username);

}
