package com.sebas.taller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.taller.model.Users;
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
	public void save(Users user) {
		ur.save(user);
		
	}

	@Override
	public Optional<Users> findById(Integer id) {
		return ur.findById(id);
	}

	@Override
	public Iterable<Users> findAll() {
		return ur.findAll();
	}

	@Override
	public Iterable<Users> findAllAdmins() {
		return ur.findByType(UserType.administrator);
	}

	@Override
	public Iterable<Users> findAllOperators() {
		return ur.findByType(UserType.operator);
	}

	@Override
	public void delete(Users user) {
		ur.delete(user);
	}

	@Override
	public UserType[] getTypes() {
		return UserType.values();
	}

}
