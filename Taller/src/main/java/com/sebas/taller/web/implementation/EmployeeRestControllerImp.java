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

import com.sebas.taller.model.hr.Employee;
import com.sebas.taller.service.hr.EmployeeService;
import com.sebas.taller.web.interfaces.EmployeeRestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestControllerImp implements EmployeeRestController {

	@Autowired
	private EmployeeService es;
	
	@Override
	@GetMapping("/")
	public Iterable<Employee> findAll() {
		return es.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Integer id) {
		return es.findById(id);
	}

	@Override
	@PostMapping("/")
	public void save(@RequestBody Employee e) {
		es.save(e);
	}

	@Override
	@PutMapping("/")
	public void update(@RequestBody Employee e) {
		es.update(e);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		es.delete(es.findById(id));
	}

}
