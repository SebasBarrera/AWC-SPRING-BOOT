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
import com.sebas.taller.bussinessDelegate.implementation.SalestaxrateBDImp;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
public class SalestaxrateBDImpTest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private SalestaxrateBDImp salesTrBD;

	private static MockRestServiceServer mockBackEnd;
	private ObjectMapper mapper = new ObjectMapper();

	private final String URL = SalestaxrateBDImp.getUrl();

	private List<Salestaxrate> salesTrList;
	private Salestaxrate str1;
	private Salestaxrate str2;

	@BeforeEach
	void initialize() {
		mockBackEnd = MockRestServiceServer.createServer(restTemplate);

		salesTrList = new ArrayList<Salestaxrate>();

		str1 = new Salestaxrate();
		str1.setSalestaxrateid(1);
		str1.setTaxrate(0.1);
		str1.setStateprovince(new Stateprovince());
		salesTrList.add(str1);

		str2 = new Salestaxrate();
		str2.setSalestaxrateid(2);
		str2.setTaxrate(0.2);
		str2.setStateprovince(new Stateprovince());
		salesTrList.add(str2);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllSalestaxrateTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(salesTrList))
				);

		List<Salestaxrate> listReturnedByServer = new ArrayList<Salestaxrate>(salesTrBD.findAllSalestaxrate());

		mockBackEnd.verify();
		assertThat(salesTrList).usingRecursiveComparison().isEqualTo(listReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findStrByIdTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + str1.getSalestaxrateid()))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(str1))
				);

		Salestaxrate strReturnedByServer = salesTrBD.findSalestaxrateById(str1.getSalestaxrateid());

		mockBackEnd.verify();
		assertThat(str1).usingRecursiveComparison().isEqualTo(strReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addStrTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.POST))
		.andRespond(withStatus(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(str1))
				);

		Salestaxrate strReturnedByServer = salesTrBD.addSalestaxrate(str1);

		mockBackEnd.verify();
		assertThat(str1).usingRecursiveComparison().isEqualTo(strReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updatePersonTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + str1.getSalestaxrateid()))
		.andExpect(method(HttpMethod.PUT))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(str1))
				);

		Salestaxrate strReturnedByServer = salesTrBD.updateSalestaxrate(str1);

		mockBackEnd.verify();
		assertThat(str1).usingRecursiveComparison().isEqualTo(strReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deletePersonTest() {
		int idOfStr = str1.getSalestaxrateid();

		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + idOfStr))
		.andExpect(method(HttpMethod.DELETE))
		.andRespond(withStatus(HttpStatus.OK));

		salesTrBD.deleteSalestaxrate(idOfStr);

		mockBackEnd.verify();
	}
}
