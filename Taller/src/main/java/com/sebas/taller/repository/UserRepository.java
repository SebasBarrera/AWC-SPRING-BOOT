package com.sebas.taller.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sebas.taller.model.Users;
import com.sebas.taller.model.UserType;

public interface UserRepository extends CrudRepository<Users, Integer> {
	
	List<Users> findByType(UserType type);
	
	List<Users> findByUsername(String username);

}
