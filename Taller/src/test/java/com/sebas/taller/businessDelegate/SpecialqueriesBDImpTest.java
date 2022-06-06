package com.sebas.taller.businessDelegate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
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
import com.sebas.taller.bussinessDelegate.implementation.SpecialqueriesBDImp;
import com.sebas.taller.bussinessDelegate.implementation.StateprovinceBDImp;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.person.StateprovinceAndAddresses;
import com.sebas.taller.model.sales.Salesorderheader;
import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.model.sales.Salesterritory;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
@TestInstance(Lifecycle.PER_CLASS)
public class SpecialqueriesBDImpTest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private SpecialqueriesBDImp specialQueryBD;

	private static MockRestServiceServer mockBackEnd;
	private ObjectMapper mapper = new ObjectMapper();

	private final String URL = SpecialqueriesBDImp.getUrl();

	private List<StateprovinceAndAddresses> spaList;
	private List<Address> addressList;
	private Stateprovince s1;
	private Stateprovince s2;

	@BeforeAll
	void initialize() {

		// Start of entities for Query #1:
		spaList = new ArrayList<StateprovinceAndAddresses>();

		Salestaxrate tax1 = new Salestaxrate();
		
		s1 = new Stateprovince();
		s1.setStateprovinceid(1);
		s1.setCountryregion(new Countryregion());
		s1.setTerritoryid(11);
		s1.setStateprovincecode("98765");
		s1.setIsonlystateprovinceflag("N");
		s1.setName("Valle Del Cauca");
		List<Salestaxrate> taxList = new ArrayList<>();
		taxList.add(tax1);
		s1.setSalestaxrates(taxList);

		Address a1 = new Address();
		a1.setStateprovince(s1);

		Address a2 = new Address();
		a2.setStateprovince(s1);

		List<Address> addresses = new ArrayList<>();
		addresses.add(a1);
		addresses.add(a2);
		s1.setAddresses(addresses);

		StateprovinceAndAddresses spa1 = new StateprovinceAndAddresses();
		spa1.setSp(s1);
		spa1.setAddresses((long) s1.getAddresses().size());
		spaList.add(spa1);
		System.out.println(spaList.get(0).getSp().getAddresses().size() + ",as "+ spa1.getAddresses());

		s2 = new Stateprovince();
		s2.setStateprovinceid(2);
		s2.setCountryregion(new Countryregion());
		s2.setTerritoryid(22);
		s2.setStateprovincecode("12345");
		s2.setIsonlystateprovinceflag("N");
		s2.setName("Cundinamarca");

		Address a3 = new Address();
		a3.setStateprovince(s2);

		List<Address> addresses2 = new ArrayList<>();
		addresses2.add(a3);
		s2.setAddresses(addresses2);

		StateprovinceAndAddresses spa2 = new StateprovinceAndAddresses();
		spa2.setSp(s2);
		spa2.setAddresses((long) s2.getAddresses().size());

		spaList.add(spa2);
		
		// Start of entities for Query #2:
		addressList = new ArrayList<>();
		
		Address a = new Address();
		a.setAddressline1("si sirve");
		
		Stateprovince s = new Stateprovince();
		s.setName("Valle del Cauca");
		
		a.setStateprovince(s);
		
		List<Address> ls = new ArrayList<Address>();
		ls.add(a);
		s.setAddresses(ls);
		
		Salesterritory st = new Salesterritory();
		st.setTerritoryid(1);
		
		
		s.setTerritoryid(st.getTerritoryid());
		
		Salesorderheader h = new Salesorderheader();
		Salesorderheader h2 = new Salesorderheader();
		List<Salesorderheader> lh = new ArrayList<Salesorderheader>();
		lh.add(h2);
		lh.add(h);
		
		h.setSalesterritory(st);
		h2.setSalesterritory(st);
		
		st.setSalesorderheaders(lh);
		
		addressList.add(a);
		
		mockBackEnd = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void specialQueryOneTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + "stateprovince/1"))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(spaList))
				);

		System.out.println(s1.getAddresses().size() + ",qq "+ spaList.get(0).getSp().getAddresses().size());
		List<StateprovinceAndAddresses> listReturnedByServer = new ArrayList<>(specialQueryBD.findSpecialStateprovinces1());

		mockBackEnd.verify();
		System.out.println(listReturnedByServer.get(0).getSp().getAddresses().size());
		System.out.println(listReturnedByServer.get(1).getSp().getAddresses().size());
//		assertThat(spaList).usingRecursiveComparison().isEqualTo(listReturnedByServer);
		
		String previousName = null;
		boolean flag = false;
		int counter = 0;
		for (StateprovinceAndAddresses spArray : listReturnedByServer) {
			Stateprovince sp = spArray.getSp();
			long numOfAddresses = spArray.getAddresses();
			if (!flag) {
				previousName = sp.getName();
				flag = true;
			}
			
			assertEquals(sp.getTerritoryid(), spaList.get(counter).getSp().getTerritoryid());
			assertEquals(sp.getAddresses().size(), numOfAddresses);
			assertTrue(sp.getSalestaxrates().size() > 0);
			assertTrue(sp.getName().compareTo(previousName) >= 0);
			System.out.println(sp.getName());
			previousName = sp.getName();
			
			counter++;
		}
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void specialQueryTwoTest() throws JsonProcessingException {
//		mockBackEnd.expect(ExpectedCount.once(), 
//				requestTo(URL + "address/"))
//		.andExpect(method(HttpMethod.GET))
//		.andRespond(withStatus(HttpStatus.OK)
//				.contentType(MediaType.APPLICATION_JSON)
//				.body(mapper.writeValueAsString(addressList))
//				);
//
//		List<Address> listReturnedByServer = new ArrayList<Address>(specialQueryBD.findSpecialAddresses());
//
//		mockBackEnd.verify();
//		assertThat(addressList).usingRecursiveComparison().isEqualTo(listReturnedByServer);
	}
}
