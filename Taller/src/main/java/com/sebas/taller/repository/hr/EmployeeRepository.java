package com.sebas.taller.repository.hr;

import org.springframework.data.repository.CrudRepository;

import com.sebas.taller.model.hr.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
