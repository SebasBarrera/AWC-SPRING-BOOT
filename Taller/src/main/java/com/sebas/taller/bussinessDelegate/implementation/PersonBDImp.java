package com.sebas.taller.bussinessDelegate.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sebas.taller.bussinessDelegate.interfaces.PersonBD;
import com.sebas.taller.model.person.Person;

@Component
public class PersonBDImp implements PersonBD{

	private final static String URL = "http://localhost:8080/api/person/";
	
	private RestTemplate restTemplate;
	
	public PersonBDImp() {
		restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public List<Person> findAllPerson() {
		return Arrays.asList(restTemplate.getForObject(URL, Person[].class));
	}

	@Override
	public Person findPersonById(Integer id) {
		return restTemplate.getForObject(URL+ id, Person.class);
	}

	@Override
	public Person addPerson(Person p) {
		HttpEntity<Person> http = new HttpEntity<Person>(p);
		return restTemplate.postForObject(URL, http, Person.class);
	}

	@Override
	public void updatePerson(Person p) {
		HttpEntity<Person> http = new HttpEntity<Person>(p);
		restTemplate.put(URL, http);
	}

	@Override
	public void deletePerson(Integer id) {
		restTemplate.delete(URL, Integer.class);
	}
}
