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
import com.sebas.taller.bussinessDelegate.implementation.CountryregionBDImp;
import com.sebas.taller.model.person.Countryregion;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
public class CountryregionBDImpTest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CountryregionBDImp crBD;

	private static MockRestServiceServer mockBackEnd;
	private ObjectMapper mapper = new ObjectMapper();

	private final static String URL = CountryregionBDImp.getUrl();
	
	private List<Countryregion> crList;
	private Countryregion c1;
	private Countryregion c2;

	@BeforeEach
	void initialize() {
		mockBackEnd = MockRestServiceServer.createServer(restTemplate);
		
		crList = new ArrayList<Countryregion>();

		c1 = new Countryregion();
		c1.setCountryregionid(1);
		c1.setCountryregioncode("COL");
		c1.setName("Colombia");
		crList.add(c1);

		c2 = new Countryregion();
		c1.setCountryregionid(2);
		c2.setCountryregioncode("CAN");
		c2.setName("Canada");
		crList.add(c2);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllCountryregionTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(crList))
				);

		List<Countryregion> listReturnedByServer = new ArrayList<Countryregion>(crBD.findAllCountryregion());

		mockBackEnd.verify();
		assertThat(crList).usingRecursiveComparison().isEqualTo(listReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findCountryregionByIdTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + c1.getCountryregionid()))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(c1))
				);

		Countryregion crReturnedByServer = crBD.findCountryregionById(c1.getCountryregionid());

		mockBackEnd.verify();
		assertThat(c1).usingRecursiveComparison().isEqualTo(crReturnedByServer);
	}

	  @Test
		@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public void addCountryregionTest() throws JsonProcessingException {
			mockBackEnd.expect(ExpectedCount.once(), 
					requestTo(URL))
			.andExpect(method(HttpMethod.POST))
			.andRespond(withStatus(HttpStatus.CREATED)
					.contentType(MediaType.APPLICATION_JSON)
					.body(mapper.writeValueAsString(c1))
					);

			Countryregion crReturnedByServer = crBD.addCountryregion(c1);
			
			mockBackEnd.verify();
			assertThat(c1).usingRecursiveComparison().isEqualTo(crReturnedByServer);
		}
		
		@Test
		@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public void updateCountryregionTest() throws JsonProcessingException {
			mockBackEnd.expect(ExpectedCount.once(), 
					requestTo(URL + c1.getCountryregionid()))
			.andExpect(method(HttpMethod.PUT))
			.andRespond(withStatus(HttpStatus.OK)
					.contentType(MediaType.APPLICATION_JSON)
					.body(mapper.writeValueAsString(c1))
					);

			Countryregion crReturnedByServer = crBD.updateCountryregion(c1);
			
			mockBackEnd.verify();
			assertThat(c1).usingRecursiveComparison().isEqualTo(crReturnedByServer);
		}
		
		@Test
		@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public void deleteCountryregionTest() {
			int idOfCr = c1.getCountryregionid();
			
			mockBackEnd.expect(ExpectedCount.once(), 
					requestTo(URL + idOfCr))
			.andExpect(method(HttpMethod.DELETE))
			.andRespond(withStatus(HttpStatus.OK));

			crBD.deleteCountryregion(idOfCr);

			mockBackEnd.verify();
		}
}
