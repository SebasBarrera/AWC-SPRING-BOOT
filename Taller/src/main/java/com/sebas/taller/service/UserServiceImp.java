package com.sebas.taller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.taller.model.User;
import com.sebas.taller.model.UserType;
import com.sebas.taller.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	private UserRepository ur;
	
	@Autowired
	public UserServiceImp(UserRepository ur) {
		this.ur = ur;
	}
	
	@Override
	public void save(User user) {
		ur.save(user);
		
	}

	@Override
	public Optional<User> findById(Integer id) {
		return ur.findById(id);
	}

	@Override
	public Iterable<User> findAll() {
		return ur.findAll();
	}

	@Override
	public Iterable<User> findAllAdmins() {
		return ur.findByType(UserType.admin);
	}

	@Override
	public Iterable<User> findAllOperators() {
		return ur.findByType(UserType.operator);
	}

	@Override
	public void delete(User user) {
		ur.delete(user);
	}

	@Override
	public UserType[] getTypes() {
		return UserType.values();
	}

}
