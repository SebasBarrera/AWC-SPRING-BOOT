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
import com.sebas.taller.bussinessDelegate.implementation.AddressBDImp;
import com.sebas.taller.model.person.Address;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
public class AddressBDImpTest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AddressBDImp addressBD;

	private static MockRestServiceServer mockBackEnd;
	private ObjectMapper mapper = new ObjectMapper();

	private final static String URL = AddressBDImp.getUrl();
	
	private List<Address> addressList;
	private Address a1;
	private Address a2;

	@BeforeEach
	void initialize() {
		mockBackEnd = MockRestServiceServer.createServer(restTemplate);
		
		addressList = new ArrayList<Address>();

		a1 = new Address();
		a1.setAddressid(1);
		a1.setAddressline1("Cra 68 # 16 - 07");
		a1.setPostalcode("760033");
		a1.setCity("Cali");
		addressList.add(a1);

		a2 = new Address();
		a2.setAddressid(2);
		a2.setAddressline1("Cra 1 # 1 - 72");
		a2.setPostalcode("760045");
		a2.setCity("Cali");
		addressList.add(a2);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllAddressTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(addressList))
				);

		List<Address> listReturnedByServer = new ArrayList<Address>(addressBD.findAllAddress());

		mockBackEnd.verify();
		assertThat(addressList).usingRecursiveComparison().isEqualTo(listReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAddressByIdTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + a1.getAddressid()))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(a1))
				);

		Address addressReturnedByServer = addressBD.findAddressById(a1.getAddressid());

		mockBackEnd.verify();
		assertThat(a1).usingRecursiveComparison().isEqualTo(addressReturnedByServer);
	}

	  @Test
		@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public void addAddressTest() throws JsonProcessingException {
			mockBackEnd.expect(ExpectedCount.once(), 
					requestTo(URL))
			.andExpect(method(HttpMethod.POST))
			.andRespond(withStatus(HttpStatus.CREATED)
					.contentType(MediaType.APPLICATION_JSON)
					.body(mapper.writeValueAsString(a1))
					);

			Address addressReturnedByServer = addressBD.addAddress(a1);
			
			mockBackEnd.verify();
			assertThat(a1).usingRecursiveComparison().isEqualTo(addressReturnedByServer);
		}
		
		@Test
		@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public void updateAddressTest() throws JsonProcessingException {
			mockBackEnd.expect(ExpectedCount.once(), 
					requestTo(URL + a1.getAddressid()))
			.andExpect(method(HttpMethod.PUT))
			.andRespond(withStatus(HttpStatus.OK)
					.contentType(MediaType.APPLICATION_JSON)
					.body(mapper.writeValueAsString(a1))
					);

			Address addressReturnedByServer = addressBD.updateAddress(a1);
			
			mockBackEnd.verify();
			assertThat(a1).usingRecursiveComparison().isEqualTo(addressReturnedByServer);
		}
		
		@Test
		@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
		public void deleteAddressTest() {
			int idOfAddress = a1.getAddressid();
			
			mockBackEnd.expect(ExpectedCount.once(), 
					requestTo(URL + idOfAddress))
			.andExpect(method(HttpMethod.DELETE))
			.andRespond(withStatus(HttpStatus.OK));

			addressBD.deleteAddress(idOfAddress);
			
			mockBackEnd.verify();
		}
}
