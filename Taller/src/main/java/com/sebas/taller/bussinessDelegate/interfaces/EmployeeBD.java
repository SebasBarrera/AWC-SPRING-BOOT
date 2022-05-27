package com.sebas.taller.bussinessDelegate.interfaces;

import java.util.List;

import com.sebas.taller.model.hr.Employee;

public interface EmployeeBD {

	public List<Employee> findAllEmployee();
	public Employee findEmployeeById(Integer id);
	public Employee addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(Integer id);
	
}
