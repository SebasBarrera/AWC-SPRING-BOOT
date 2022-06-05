package com.sebas.taller.service;

import java.util.Optional;

import com.sebas.taller.model.Users;
import com.sebas.taller.model.UserType;

public interface UserService {
	
	public void save(Users user);

	public Optional<Users> findById(Integer id);

	public Iterable<Users> findAll();

	public Iterable<Users> findAllAdmins();

	public Iterable<Users> findAllOperators();

	public void delete(Users user);

	public UserType[] getTypes();

	//public boolean confirmPassword(Integer id, String);
}
