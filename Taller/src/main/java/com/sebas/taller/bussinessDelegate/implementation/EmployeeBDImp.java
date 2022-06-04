package com.sebas.taller.bussinessDelegate.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sebas.taller.bussinessDelegate.interfaces.EmployeeBD;
import com.sebas.taller.model.hr.Employee;
import com.sebas.taller.model.person.Address;

@Component
public class EmployeeBDImp implements EmployeeBD{

	private final static String URL = "http://localhost:8080/api/employee/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public EmployeeBDImp() {
		restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public List<Employee> findAllEmployee() {
		return Arrays.asList(restTemplate.getForObject(URL, Employee[].class));
	}
	
	@Override
	public Employee findEmployeeById(Integer id) {
		return restTemplate.getForObject(URL+ id, Employee.class);
	}
	
	@Override
	public Employee addEmployee(Employee e) {
		HttpEntity<Employee> http = new HttpEntity<Employee>(e);
		return restTemplate.postForObject(URL, http, Employee.class);
	}
	
	@Override
	public Employee updateEmployee(Employee e) {
		HttpEntity<Employee> http = new HttpEntity<Employee>(e);
		return restTemplate.exchange(
				URL + e.getBusinessentityid(), 
				HttpMethod.PUT, 
				http, 
				Employee.class,
				e.getBusinessentityid())
				.getBody();
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		restTemplate.delete(URL + id, Integer.class);
	}

	public static String getUrl() {
		return URL;
	}
	
}
