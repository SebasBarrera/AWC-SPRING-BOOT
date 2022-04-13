package com.sebas.taller.service;

import java.util.Optional;

import com.sebas.taller.model.User;
import com.sebas.taller.model.UserType;

public interface UserService {
	
	public void save(User user);

	public Optional<User> findById(Integer id);

	public Iterable<User> findAll();

	public Iterable<User> findAllAdmins();

	public Iterable<User> findAllOperators();

	public void delete(User user);

	public UserType[] getTypes();

	//public boolean confirmPassword(Integer id, String);
}
