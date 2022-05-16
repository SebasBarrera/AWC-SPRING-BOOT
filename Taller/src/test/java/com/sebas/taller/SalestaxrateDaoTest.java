package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.implementation.SalestaxrateDaoImp;
import com.sebas.taller.dao.implementation.StateprovinceDaoImp;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
class SalestaxrateDaoTest {

	@Autowired
	private SalestaxrateDaoImp dao;
	
	@Autowired 
	private StateprovinceDaoImp daoStateprovince;
	
	private Salestaxrate s;
	

	void setUpSave() {
		s = new Salestaxrate();
		s.setTaxrate(0.0);
		s.setName("Impuesto al consumo");
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);

		Salestaxrate guardado = dao.findById(s.getSalestaxrateid());
		
		assertEquals(s.getTaxrate(), guardado.getTaxrate());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);
		
		s.setTaxrate(1.1);
		s.setName("Cambiada");

		dao.update(s);
		
		Salestaxrate editado = dao.findById(s.getSalestaxrateid());
		
		assertAll("address update",
				() -> assertEquals(1.1, editado.getTaxrate()),
				() -> assertEquals("Cambiada", editado.getName())
				);
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);
		
		dao.delete(s);

		assertNull(dao.findById(s.getSalestaxrateid()));
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);
	
		assertEquals(s.getTaxrate(), dao.findById(s.getSalestaxrateid()).getTaxrate());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);
	
		Salestaxrate a1 = new Salestaxrate();
		a1.setTaxrate(1.1);
		a1.setName("Impuesto al consumo");
		
		dao.save(a1);
		
		assertEquals(2, dao.findAll().size());
		
	}
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByStateprovinceTest() {

		assertNotNull(dao);
		
		assertNotNull(daoStateprovince);
		
		Stateprovince sp = new Stateprovince();
		
		daoStateprovince.save(sp);
		
		Salestaxrate a1 = new Salestaxrate();
		a1.setTaxrate(6.5);
		a1.setName("eseeee");
		a1.setStateprovince(sp);
		
		setUpSave();
		
		dao.save(s);
		dao.save(a1);
		
		assertEquals("eseeee", dao.findByStateprovinceId(sp.getStateprovinceid()).get(0).getName());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByNameTest() {

		assertNotNull(dao);
		
		assertNotNull(daoStateprovince);
		
		Stateprovince sp = new Stateprovince();
		
		daoStateprovince.save(sp);
		
		Salestaxrate a1 = new Salestaxrate();
		a1.setTaxrate(6.5);
		a1.setName("eseeee");
		a1.setStateprovince(sp);
		
		setUpSave();
		
		dao.save(s);
		dao.save(a1);
		
		assertEquals(6.5, dao.findByName("eseeee").get(0).getTaxrate());
		assertEquals(0.0, dao.findByName("Impuesto al consumo").get(0).getTaxrate());
	}

}
