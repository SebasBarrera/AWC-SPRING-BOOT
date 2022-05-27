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

import com.sebas.taller.bussinessDelegate.interfaces.StateprovinceBD;
import com.sebas.taller.model.person.Stateprovince;

@Component
public class StateprovinceBDImp implements StateprovinceBD{

	private final static String URL = "http://localhost:8080/api/stateprovince/";
	
	private RestTemplate restTemplate;
	
	public StateprovinceBDImp() {
		restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public List<Stateprovince> findAllStateprovince() {
		return Arrays.asList(restTemplate.getForObject(URL, Stateprovince[].class));
	}

	@Override
	public Stateprovince findStateprovinceById(Integer id) {
		return restTemplate.getForObject(URL+ id, Stateprovince.class);
	}
	
	@Override
	public Stateprovince addStateprovince(Stateprovince s) {
		HttpEntity<Stateprovince> http = new HttpEntity<Stateprovince>(s);
		return restTemplate.postForObject(URL, http, Stateprovince.class);
	}

	@Override
	public void updateStateprovince(Stateprovince s) {
		HttpEntity<Stateprovince> http = new HttpEntity<Stateprovince>(s);
		restTemplate.put(URL + s.getStateprovinceid(), http);
	}
	@Override
	public void deleteStateprovince(Integer id) {
		restTemplate.delete(URL + id, Integer.class);
	}
}
