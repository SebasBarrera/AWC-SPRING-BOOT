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

import com.sebas.taller.bussinessDelegate.interfaces.AddressBD;
import com.sebas.taller.model.person.Address;

@Component
public class AddressBDImp implements AddressBD {

	private final static String URL = "http://localhost:8080/api/address/";

	private RestTemplate restTemplate;
	
	public AddressBDImp() {
		restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public List<Address> findAllAddress() {
		return Arrays.asList(restTemplate.getForObject(URL, Address[].class));
	}
	
	@Override
	public Address findAddressById(Integer id) {
		return restTemplate.getForObject(URL+ id, Address.class);
	}
	
	@Override
	public Address addAddress(Address a) {
		HttpEntity<Address> http = new HttpEntity<Address>(a);
		return restTemplate.postForObject(URL, http, Address.class);
	}
	
	@Override
	public void updateAddress(Address a) {
		HttpEntity<Address> http = new HttpEntity<Address>(a);
		restTemplate.put(URL + a.getAddressid(), http);
	}
	
	@Override
	public void deleteAddress(Integer id) {
		restTemplate.delete(URL + id, Integer.class);
	}
	
	
}
