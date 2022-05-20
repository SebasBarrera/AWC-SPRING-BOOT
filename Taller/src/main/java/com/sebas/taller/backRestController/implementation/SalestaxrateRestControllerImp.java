package com.sebas.taller.backRestController.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.taller.backRestController.interfaces.SalestaxrateRestController;
import com.sebas.taller.dao.interfaces.SalestaxrateDao;
import com.sebas.taller.model.sales.Salestaxrate;

@RestController
@RequestMapping("/salestaxrate")
public class SalestaxrateRestControllerImp implements SalestaxrateRestController {

	@Autowired
	private SalestaxrateDao dao;
	
	@Override
	@GetMapping
	public Iterable<Salestaxrate> findAll() {
		return dao.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Salestaxrate findById(@PathVariable("id") Integer id) {
		return dao.findById(id);
	}

	@Override
	@PostMapping
	public void save(@RequestBody Salestaxrate s) {
		dao.save(s);
	}

	@Override
	@PutMapping
	public void update(@RequestBody Salestaxrate s) {
		dao.update(s);
	}

	@Override
	@DeleteMapping("/id")
	public void delete(@PathVariable("id") Integer id) {
		dao.delete(dao.findById(id));
	}

}
