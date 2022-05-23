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

import com.sebas.taller.model.person.Person;
import com.sebas.taller.service.person.PersonService;
import com.sebas.taller.web.interfaces.PersonRestController;

@RestController
@RequestMapping("/api/person")
public class PersonRestControllerImp implements PersonRestController {

	@Autowired
	private PersonService ps;
	
	@Override
	@RequestMapping
	public Iterable<Person> findAll() {
		return ps.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Integer id) {
		return ps.findById(id);
	}

	@Override
	@PostMapping("/")
	public void save(@RequestBody Person p) {
		ps.save(p);
	}

	@Override
	@PutMapping("/")
	public void update(@RequestBody Person p) {
		ps.update(p);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		ps.delete(ps.findById(id));
	}

}
