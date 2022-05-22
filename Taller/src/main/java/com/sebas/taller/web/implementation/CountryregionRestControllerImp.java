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

import com.sebas.taller.dao.interfaces.CountryregionDao;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.web.interfaces.CountryregionRestController;

@RestController
@RequestMapping("/countryregion")
public class CountryregionRestControllerImp implements CountryregionRestController {

	@Autowired
	private CountryregionDao dao;
	
	@Override
	@GetMapping
	public Iterable<Countryregion> findAll() {
		return dao.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Countryregion findById(@PathVariable("id") Integer id) {
		return dao.findById(id);
	}

	@Override
	@PostMapping
	public void save(@RequestBody Countryregion c) {
		dao.save(c);
	}

	@Override
	@PutMapping
	public void update(@RequestBody Countryregion c) {
		dao.update(c);
	}

	@Override
	@DeleteMapping("/id")
	public void delete(@PathVariable("id") Integer id) {
		dao.delete(dao.findById(id));
	}

}
