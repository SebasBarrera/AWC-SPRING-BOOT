package com.sebas.taller.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sebas.taller.model.User;
import com.sebas.taller.model.UserType;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	List<User> findByType(UserType type);
	
	List<User> findByUsername(String username);

}
