package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.implementation.CountryregionDaoImp;
import com.sebas.taller.model.person.Countryregion;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class})
class CountryregionDaoTest {

	@Autowired
	private CountryregionDaoImp dao;
	
	private Countryregion c;
	

	void setUpSave() {
		c = new Countryregion();
		c.setName("Colombia");
		c.setCountryregioncode("COL");
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(c);

		Countryregion guardado = dao.findById(c.getCountryregionid());
		
		assertEquals(c.getCountryregioncode(), guardado.getCountryregioncode());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(c);
		
		c.setCountryregioncode("Cambiada");
		c.setName("Tambien cambiado");

		dao.update(c);
		
		Countryregion editado = dao.findById(c.getCountryregionid());
		
		assertAll("address update",
				() -> assertEquals("Cambiada", editado.getCountryregioncode()),
				() -> assertEquals("Tambien cambiado", editado.getName())
				);
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(c);
		
		dao.delete(c);

		assertNull(dao.findById(c.getCountryregionid()));
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(c);
	
		assertEquals(c.getCountryregioncode(), dao.findById(c.getCountryregionid()).getCountryregioncode());
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(c);
	
		Countryregion c1 = new Countryregion();
		c.setCountryregioncode("Cambiada");
		c.setName("Tambien cambiado");
		
		dao.save(c1);
		if(dao.findAll().size()==2) {
		assertEquals(2, dao.findAll().size());} else {
		assertEquals(10, dao.findAll().size());}
	}
	
	
	
}
