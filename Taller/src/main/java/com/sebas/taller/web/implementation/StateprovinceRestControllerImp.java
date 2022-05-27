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

import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.service.person.StateprovinceService;
import com.sebas.taller.web.interfaces.StateprovinceRestController;

@RestController
@RequestMapping("/api/stateprovince")
public class StateprovinceRestControllerImp implements StateprovinceRestController {

	@Autowired
	private StateprovinceService service;
	
	@Override
	@GetMapping("/")
	public Iterable<Stateprovince> findAll() {
		return service.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Stateprovince findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}

	@Override
	@PostMapping("/")
	public void save(@RequestBody Stateprovince s) {
		service.save(s);
	}

	@Override
	@PutMapping("/{id}")
	public void update(@RequestBody Stateprovince s, @PathVariable("id") Integer id) {
		service.update(s);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(service.findById(id));
	}

}
