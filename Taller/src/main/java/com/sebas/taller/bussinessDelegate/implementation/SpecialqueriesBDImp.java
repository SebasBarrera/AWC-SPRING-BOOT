package com.sebas.taller.bussinessDelegate.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sebas.taller.bussinessDelegate.interfaces.SpecialqueriesBD;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.StateprovinceAndAddresses;

@Component
public class SpecialqueriesBDImp implements SpecialqueriesBD{

	private final static String URL = "http://localhost:8080/api/specialqueries/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public SpecialqueriesBDImp() {
		restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public List<StateprovinceAndAddresses> findSpecialStateprovinces() {
//		ResponseEntity<List<StateprovinceAndAddresses>> rateResponse =
//				restTemplate.exchange(URL + "stateprovince/",
//		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<StateprovinceAndAddresses>>() {
//		            });
//		List<StateprovinceAndAddresses> al = rateResponse.getBody();
		
//		List<StateprovinceAndAddresses> al = Arrays.asList(restTemplate.getForObject(URL + "stateprovince/", StateprovinceAndAddresses[].class));
//		int counter = 0;
//		for (StateprovinceAndAddresses currentSpa : al) {
//			Stateprovince sp = currentSpa.getSp();
//			System.out.println(sp.getName() + currentSpa.getAddresses());
//			counter++;
//		}
//		System.out.println(counter);
//		return al;
		return Arrays.asList(restTemplate.getForObject(URL + "stateprovince/1", StateprovinceAndAddresses[].class));
	}

	@Override
	public List<Address> findSpecialAddresses() {
//		List<Address> al = Arrays.asList(restTemplate.getForObject(URL + "stateprovince/", Address[].class));
		return Arrays.asList(restTemplate.getForObject(URL + "address/", Address[].class));
	}

	@Override
	public List<Integer> findspecialAmountAddressInStateprovince() {
		return Arrays.asList(restTemplate.getForObject(URL + "amount/", Integer[].class));
	}

	public static String getUrl() {
		return URL;
	}

}
