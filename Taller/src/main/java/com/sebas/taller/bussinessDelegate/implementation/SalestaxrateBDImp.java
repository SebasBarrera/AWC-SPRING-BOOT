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

import com.sebas.taller.bussinessDelegate.interfaces.SalestaxrateBD;
import com.sebas.taller.model.sales.Salestaxrate;

@Component
public class SalestaxrateBDImp implements SalestaxrateBD{

	private final static String URL = "http://localhost:8080/api/salestaxrate/";
	
	private RestTemplate restTemplate;
	
	public SalestaxrateBDImp() {
		restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public List<Salestaxrate> findAllSalestaxrate() {
		return Arrays.asList(restTemplate.getForObject(URL, Salestaxrate[].class));
	}
	
	@Override
	public Salestaxrate findSalestaxrateById(Integer id) {
		return restTemplate.getForObject(URL+ id, Salestaxrate.class);
	}
	
	@Override
	public Salestaxrate addSalestaxrate(Salestaxrate s) {
		HttpEntity<Salestaxrate> http = new HttpEntity<Salestaxrate>(s);
		return restTemplate.postForObject(URL, http, Salestaxrate.class);
	}
	
	@Override
	public void updateSalestaxrate(Salestaxrate s) {
		HttpEntity<Salestaxrate> http = new HttpEntity<Salestaxrate>(s);
		restTemplate.put(URL, http);
	}

	@Override
	public void deleteSalestaxrate(Integer id) {
		restTemplate.delete(URL, Integer.class);
	}
}
