package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.implementation.AddressDaoImp;
import com.sebas.taller.dao.implementation.StateprovinceDaoImp;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salesorderheader;
import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.repository.sales.SalesorderheaderRepository;
import com.sebas.taller.repository.sales.SalesterritoryRepository;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
class AddressDaoTest {
	
	@Autowired
	private AddressDaoImp dao;
	
	@Autowired 
	private StateprovinceDaoImp daoStateprovince;
	
	@Autowired
	private SalesterritoryRepository sr;
	
	@Autowired
	private SalesorderheaderRepository hr;
	
	private Address a;
	

	void setUpSave() {
		a = new Address();
		a.setAddressline1("Cra 68 # 16 - 07");
		a.setCity("Cali");
		a.setPostalcode("760033");
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(a);

		Address guardado = dao.findById(a.getAddressid());
		
		assertEquals(a.getAddressline1(), guardado.getAddressline1());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(a);
		
		a.setAddressline1("Cambiada");
		a.setCity("Tambien cambiado");
		a.setPostalcode("456987");

		dao.update(a);
		
		Address editado = dao.findById(a.getAddressid());
		
		assertAll("address update",
				() -> assertEquals("Cambiada", editado.getAddressline1()),
				() -> assertEquals("Tambien cambiado", editado.getCity()),
				() -> assertEquals("456987", editado.getPostalcode())
				);
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(a);
		
		dao.delete(a);

		assertNull(dao.findById(a.getAddressid()));
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(a);
	
		assertEquals(a.getAddressline1(), dao.findById(a.getAddressid()).getAddressline1());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(a);
	
		Address a1 = new Address();
		a1.setAddressline1("Cra 68 # 16 - 07");
		a1.setCity("Cali");
		a1.setPostalcode("760033");
		
		dao.save(a1);
		
		assertEquals(2, dao.findAll().size());
		
	}
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByStateprovinceTest() {

		assertNotNull(dao);
		
		assertNotNull(daoStateprovince);
		
		Stateprovince s = new Stateprovince();
		
		daoStateprovince.save(s);
		
		Address a1 = new Address();
		a1.setAddressline1("nuevaaaa");
		a1.setCity("asie");
		a1.setPostalcode("123456");
		a1.setStateprovince(s);
		
		Address a2 = new Address();
		a2.setAddressline1("otra nueva");
		a2.setCity("adfdsdf");
		a2.setPostalcode("523456");
		a2.setStateprovince(s);
		
		setUpSave();
		
		dao.save(a);
		dao.save(a1);
		dao.save(a2);
		
		
		assertEquals("nuevaaaa", dao.findByStateprovinceId(s.getStateprovinceid()).get(0).getAddressline1());
		assertEquals("otra nueva", dao.findByStateprovinceId(s.getStateprovinceid()).get(1).getAddressline1());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByCityTest() {

		assertNotNull(dao);
		
		assertNotNull(daoStateprovince);
		
		Stateprovince s = new Stateprovince();
		
		daoStateprovince.save(s);
		
		Address a1 = new Address();
		a1.setAddressline1("Soy de otra ciudad");
		a1.setCity("Bogota");
		a1.setPostalcode("123456");
		a1.setStateprovince(s);
		
		Address a2 = new Address();
		a2.setAddressline1("Esta tambien es de Cali");
		a2.setCity("Cali");
		a2.setPostalcode("523456");
		a2.setStateprovince(s);
		
		setUpSave();
		
		dao.save(a);
		dao.save(a1);
		dao.save(a2);
		
		
		assertEquals("Cra 68 # 16 - 07", dao.findByCity("Cali").get(0).getAddressline1());
		assertEquals("Esta tambien es de Cali", dao.findByCity("Cali").get(1).getAddressline1());
		assertEquals("Soy de otra ciudad", dao.findByCity("Bogota").get(0).getAddressline1());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByAtLeastTwoSalesorderheadersTest() {

		assertNotNull(dao);
		
		assertNotNull(daoStateprovince);
		
		Address a = new Address();
		a.setAddressline1("si sirve");
		dao.save(a);
		
		Stateprovince s = new Stateprovince();
		s.setName("Valle del Cauca");
		daoStateprovince.save(s);
		
		a.setStateprovince(s);
		
		List<Address> ls = new ArrayList<Address>();
		ls.add(a);
		s.setAddresses(ls);
		
		Salesterritory st = new Salesterritory();
		st.setTerritoryid(1);
		sr.save(st);
		
		
		s.setTerritoryid(st.getTerritoryid());
		
		Salesorderheader h = new Salesorderheader();
		hr.save(h);
		Salesorderheader h2 = new Salesorderheader();
		hr.save(h2);
		List<Salesorderheader> lh = new ArrayList<Salesorderheader>();
		lh.add(h2);
		lh.add(h);
		
		h.setSalesterritory(st);
		h2.setSalesterritory(st);
		
		st.setSalesorderheaders(lh);
		
		assertEquals("si sirve", dao.findByAtLeastTwoSalesorderheaders().get(0).getAddressline1());
		
	}
	

}
