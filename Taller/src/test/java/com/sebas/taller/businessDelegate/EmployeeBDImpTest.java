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
import com.sebas.taller.bussinessDelegate.implementation.EmployeeBDImp;
import com.sebas.taller.model.hr.Employee;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
public class EmployeeBDImpTest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EmployeeBDImp employeeBD;

	private static MockRestServiceServer mockBackEnd;
	private ObjectMapper mapper = new ObjectMapper();

	private final static String URL = EmployeeBDImp.getUrl();

	private List<Employee> employeeList;
	private Employee e1;
	private Employee e2;

	@BeforeEach
	void initialize() {
		mockBackEnd = MockRestServiceServer.createServer(restTemplate);

		employeeList = new ArrayList<Employee>();

		e1 = new Employee();
		e1.setBusinessentityid(1);
		e1.setJobtitle("Inspector");
		employeeList.add(e1);

		e2 = new Employee();
		e2.setBusinessentityid(2);
		e2.setJobtitle("Operator");
		employeeList.add(e2);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllEmployeeTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(employeeList))
				);

		List<Employee> listReturnedByServer = new ArrayList<Employee>(employeeBD.findAllEmployee());

		mockBackEnd.verify();
		assertThat(employeeList).usingRecursiveComparison().isEqualTo(listReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findEmployeeByIdTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + e1.getBusinessentityid()))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(e1))
				);

		Employee employeeReturnedByServer = employeeBD.findEmployeeById(e1.getBusinessentityid());

		mockBackEnd.verify();
		assertThat(e1).usingRecursiveComparison().isEqualTo(employeeReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addAddressTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL))
		.andExpect(method(HttpMethod.POST))
		.andRespond(withStatus(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(e1))
				);

		Employee employeeReturnedByServer = employeeBD.addEmployee(e1);

		mockBackEnd.verify();
		assertThat(e1).usingRecursiveComparison().isEqualTo(employeeReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateAddressTest() throws JsonProcessingException {
		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + e1.getBusinessentityid()))
		.andExpect(method(HttpMethod.PUT))
		.andRespond(withStatus(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(mapper.writeValueAsString(e1))
				);

		Employee employeeReturnedByServer = employeeBD.updateEmployee(e1);

		mockBackEnd.verify();
		assertThat(e1).usingRecursiveComparison().isEqualTo(employeeReturnedByServer);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteEmployeeTest() {
		int idOfEmployee = e1.getBusinessentityid();

		mockBackEnd.expect(ExpectedCount.once(), 
				requestTo(URL + idOfEmployee))
		.andExpect(method(HttpMethod.DELETE))
		.andRespond(withStatus(HttpStatus.OK));

		employeeBD.deleteEmployee(idOfEmployee);

		mockBackEnd.verify();
	}
}
