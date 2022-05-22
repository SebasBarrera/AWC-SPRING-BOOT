package com.sebas.taller.web.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.taller.dao.interfaces.AddressDao;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.web.interfaces.AddressRestController;

@RestController
@RequestMapping("/address")
public class AddressRestControllerImp implements AddressRestController {

	@Autowired
	private AddressDao dao;
	
	@Override
	@GetMapping
	public Iterable<Address> findAll() {
		return dao.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Address findById(@PathVariable("id") Integer id) {
		return dao.findById(id);
	}

	@Override
	@PostMapping
	public void save(@RequestBody Address a) {
		dao.save(a);
	}

	@Override
	@PutMapping
	public void update(@RequestBody Address a) {
		dao.update(a);
	}

	@Override
	@DeleteMapping("/id")
	public void delete(@PathVariable("id") Integer id) {
		dao.delete(dao.findById(id));
	}

}
