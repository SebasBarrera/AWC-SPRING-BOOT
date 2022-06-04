package com.sebas.taller.businessDelegate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebas.taller.TallerApplication;
import com.sebas.taller.bussinessDelegate.implementation.StateprovinceBDImp;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
public class StateprovinceBDImpTest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StateprovinceBDImp stateProvBD;

	private static MockRestServiceServer mockBackEnd;
	private ObjectMapper mapper = new ObjectMapper();

	private final String URL = StateprovinceBDImp.getUrl();

	private List<Stateprovince> stateProvList;
	private Stateprovince s1;
	private Stateprovince s2;

	@BeforeEach
	void initialize() {
		mockBackEnd = MockRestServiceServer.createServer(restTemplate);

		stateProvList = new ArrayList<Stateprovince>();

		s1 = new Stateprovince();
		s1.setStateprovinceid(1);
		s1.setCountryregion(new Countryregion());
		s1.setTerritoryid(1);
		s1.setStateprovincecode("98765");
		s1.setIsonlystateprovinceflag("N");
		s1.setName("Valle Del Cauca");
		stateProvList.add(s1);

		s2 = new Stateprovince();
		s2.setStateprovinceid(2);
		s2.setCountryregion(new Countryregion());
		s2.setTerritoryid(2);
		s2.setStateprovincecode("12345");
		s2.setIsonlystateprovinceflag("N");
		s2.setName("Cundinamarca");
		stateProvList.add(s2);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllStateprovinceTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(stateProvList))
				);

		List<Stateprovince> listReturnedByServer = new ArrayList<Stateprovince>(stateProvBD.findAllStateprovince());

		mockBackEnd.verify();
		assertThat(stateProvList).usingRecursiveComparison().isEqualTo(listReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findStateprovinceByIdTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + s1.getStateprovinceid()))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(s1))
				);

		Stateprovince stateProvReturnedByServer = stateProvBD.findStateprovinceById(s1.getStateprovinceid());

		mockBackEnd.verify();
		assertThat(s1).usingRecursiveComparison().isEqualTo(stateProvReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addStateprovinceTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.POST))
		.andRespond(withStatus(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(s1))
				);

		Stateprovince stateProvReturnedByServer = stateProvBD.addStateprovince(s1);

		mockBackEnd.verify();
		assertThat(s1).usingRecursiveComparison().isEqualTo(stateProvReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateStateprovinceTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + s1.getStateprovinceid()))
		.andExpect(method(HttpMethod.PUT))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(s1))
				);

		Stateprovince stateProvReturnedByServer = stateProvBD.updateStateprovince(s1);

		mockBackEnd.verify();
		assertThat(s1).usingRecursiveComparison().isEqualTo(stateProvReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteStateprovinceTest() {
		int idOfStateprov = s1.getStateprovinceid();

		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + idOfStateprov))
		.andExpect(method(HttpMethod.DELETE))
		.andRespond(withStatus(HttpStatus.OK));

		stateProvBD.deleteStateprovince(idOfStateprov);

		mockBackEnd.verify();
	}
}
