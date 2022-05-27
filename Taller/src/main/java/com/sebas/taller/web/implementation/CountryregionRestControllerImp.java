package com.sebas.taller.web.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.service.person.CountryregionService;
import com.sebas.taller.web.interfaces.CountryregionRestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CountryregionRestControllerImp implements CountryregionRestController {

	@Autowired
	private CountryregionService service;
	
	@Override
	@GetMapping("/countryregion/")
	public Iterable<Countryregion> findAll() {
		return service.findAll();
	}

	@Override
	@GetMapping("/countryregion/{id}")
	public Countryregion findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}

	@Override
	@PostMapping(value = "/countryregion/", consumes = "application/json" )
	public void save(@RequestBody Countryregion c) {
		service.save(c);
	}

	@Override
	@PutMapping("/countryregion/{id}")
	public void update(@RequestBody Countryregion c, @PathVariable("id") Integer id) {
		service.update(c);
	}

	@Override
	@DeleteMapping("/countryregion/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(service.findById(id));
	}

}
