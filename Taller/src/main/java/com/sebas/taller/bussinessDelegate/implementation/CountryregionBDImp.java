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

import com.sebas.taller.bussinessDelegate.interfaces.CountryregionBD;
import com.sebas.taller.model.person.Countryregion;

@Component
public class CountryregionBDImp implements CountryregionBD {
	
	private final static String URL = "http://localhost:8080/api/countryregion/";
	
	private RestTemplate restTemplate;
	
	public CountryregionBDImp() {
		restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public List<Countryregion> findAllCountryregion() {
		return Arrays.asList(restTemplate.getForObject(URL, Countryregion[].class));
	}
	
	@Override
	public Countryregion findCountryregionById(Integer id) {
		return restTemplate.getForObject(URL+ id, Countryregion.class);
	}
	
	@Override
	public Countryregion addCountryregion(Countryregion c) {
		HttpEntity<Countryregion> http = new HttpEntity<Countryregion>(c);
		return restTemplate.postForObject(URL, http, Countryregion.class);
	}
	
	@Override
	public void updateCountryregion(Countryregion c) {
		HttpEntity<Countryregion> http = new HttpEntity<Countryregion>(c);
		restTemplate.put(URL + c.getCountryregionid(), http);
	}
	
	@Override
	public void deleteCountryregion(Integer id) {
		restTemplate.delete(URL + id, Integer.class);
	}
	
	
}
