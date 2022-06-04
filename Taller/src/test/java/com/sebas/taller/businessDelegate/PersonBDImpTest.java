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
import com.sebas.taller.bussinessDelegate.implementation.PersonBDImp;
import com.sebas.taller.model.person.Person;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
public class PersonBDImpTest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PersonBDImp personBD;

	private static MockRestServiceServer mockBackEnd;
	private ObjectMapper mapper = new ObjectMapper();

	private final String URL = PersonBDImp.getUrl();

	private List<Person> personList;
	private Person p1;
	private Person p2;

	@BeforeEach
	void initialize() {
		mockBackEnd = MockRestServiceServer.createServer(restTemplate);

		personList = new ArrayList<Person>();

		p1 = new Person();
		p1.setBusinessentityid(1);
		p1.setFirstname("Guy");
		p1.setLastname("Fawkes");
		personList.add(p1);

		p2 = new Person();
		p2.setBusinessentityid(1);
		p2.setFirstname("Lady");
		p2.setLastname("Gaga");
		personList.add(p2);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllPersonTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(personList))
				);

		List<Person> listReturnedByServer = new ArrayList<Person>(personBD.findAllPerson());

		mockBackEnd.verify();
		assertThat(personList).usingRecursiveComparison().isEqualTo(listReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findPersonByIdTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + p1.getBusinessentityid()))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(p1))
				);

		Person personReturnedByServer = personBD.findPersonById(p1.getBusinessentityid());

		mockBackEnd.verify();
		assertThat(p1).usingRecursiveComparison().isEqualTo(personReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addPersonTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.POST))
		.andRespond(withStatus(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(p1))
				);

		Person personReturnedByServer = personBD.addPerson(p1);

		mockBackEnd.verify();
		assertThat(p1).usingRecursiveComparison().isEqualTo(personReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updatePersonTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + p1.getBusinessentityid()))
		.andExpect(method(HttpMethod.PUT))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(p1))
				);

		Person personReturnedByServer = personBD.updatePerson(p1);

		mockBackEnd.verify();
		assertThat(p1).usingRecursiveComparison().isEqualTo(personReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deletePersonTest() {
		int idOfPerson = p1.getBusinessentityid();

		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + idOfPerson))
		.andExpect(method(HttpMethod.DELETE))
		.andRespond(withStatus(HttpStatus.OK));

		personBD.deletePerson(idOfPerson);

		mockBackEnd.verify();
	}
}
