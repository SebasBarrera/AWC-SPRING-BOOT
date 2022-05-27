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

import com.sebas.taller.model.person.Address;
import com.sebas.taller.service.person.AddressService;
import com.sebas.taller.web.interfaces.AddressRestController;

@RestController
@RequestMapping("/api/address")
public class AddressRestControllerImp implements AddressRestController {

	@Autowired
	private AddressService service;
	
	@Override
	@GetMapping("/")
	public Iterable<Address> findAll() {
		return service.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Address findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}

	@Override
	@PostMapping("/")
	public void save(@RequestBody Address a) {
		service.save(a);
	}

	@Override
	@PutMapping("/{id}")
	public void update(@RequestBody Address a, @PathVariable("id") Integer id) {
		service.update(a);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(service.findById(id));
	}

}
