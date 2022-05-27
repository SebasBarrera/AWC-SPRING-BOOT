package com.sebas.taller.web.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.taller.model.hr.Employee;
import com.sebas.taller.service.hr.EmployeeService;
import com.sebas.taller.web.interfaces.EmployeeRestController;

@RestController
public class EmployeeRestControllerImp implements EmployeeRestController {

	@Autowired
	private EmployeeService es;
	
	@Override
	@GetMapping("/api/employee/")
	public Iterable<Employee> findAll() {
		return es.findAll();
	}

	@Override
	@GetMapping("/api/employee/{id}")
	public Employee findById(@PathVariable("id") Integer id) {
		return es.findById(id);
	}

	@Override
	@PostMapping("/api/employee/")
	public void save(@RequestBody Employee e) {
		es.save(e);
	}

	@Override
	@PutMapping("/api/employee/{id}")
	public void update(@RequestBody Employee e, @PathVariable("id") Integer id) {
		es.update(e);
	}

	@Override
	@DeleteMapping("/api/employee/{id}")
	public void delete(@PathVariable("id") Integer id) {
		es.delete(es.findById(id));
	}

}
