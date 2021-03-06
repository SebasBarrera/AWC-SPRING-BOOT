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

import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.service.sales.SalestaxrateService;
import com.sebas.taller.web.interfaces.SalestaxrateRestController;

@RestController
@RequestMapping("/api/salestaxrate")
public class SalestaxrateRestControllerImp implements SalestaxrateRestController {

	@Autowired
	private SalestaxrateService service;
	
	@Override
	@GetMapping("/")
	public Iterable<Salestaxrate> findAll() {
		return service.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Salestaxrate findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}

	@Override
	@PostMapping("/")
	public void save(@RequestBody Salestaxrate s) {
		service.save(s);
	}

	@Override
	@PutMapping("/{id}")
	public void update(@RequestBody Salestaxrate s, @PathVariable("id") Integer id) {
		System.out.println("called put"+s.getTaxrate());
		service.update(s);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(service.findById(id));
	}

}
