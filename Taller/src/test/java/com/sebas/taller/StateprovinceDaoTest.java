package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.implementation.CountryregionDaoImp;
import com.sebas.taller.dao.implementation.StateprovinceDaoImp;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salesterritory;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class}) 
class StateprovinceDaoTest {

	@Autowired
	private StateprovinceDaoImp dao;
	
	@Autowired 
	private CountryregionDaoImp daoCountryregion;
	
	private Stateprovince s;
	

	void setUpSave() {
		s = new Stateprovince();
		s.setStateprovincecode("12345");
		s.setIsonlystateprovinceflag("Y");
		s.setName("Valle del cauca");
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);

		Stateprovince guardado = dao.findById(s.getStateprovinceid());
		
		assertEquals(s.getName(), guardado.getName());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);
		
		s.setStateprovincecode("Cambiada");
		s.setIsonlystateprovinceflag("N");
		s.setName("Cundinamarca");

		dao.update(s);
		
		Stateprovince editado = dao.findById(s.getStateprovinceid());
		
		assertAll("address update",
				() -> assertEquals("Cambiada", editado.getStateprovincecode()),
				() -> assertEquals("N", editado.getIsonlystateprovinceflag()),
				() -> assertEquals("Cundinamarca", editado.getName())
				);
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);
		
		dao.delete(s);

		assertNull(dao.findById(s.getStateprovinceid()));
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);
	
		assertEquals(s.getName(), dao.findById(s.getStateprovinceid()).getName());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findAllTest() {

		assertNotNull(dao);
		
		setUpSave();
		
		dao.save(s);
	
		Stateprovince a1 = new Stateprovince();
		s.setStateprovincecode("65432");
		s.setIsonlystateprovinceflag("N");
		s.setName("Cundinamarca"); 
		
		dao.save(a1);
		
		assertEquals(2, dao.findAll().size());
		
	}
	
	
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByCountryTest() {

		assertNotNull(dao);
		
		assertNotNull(daoCountryregion);
		
		Countryregion c = new Countryregion();
		c.setCountryregioncode("COL");
		Countryregion c1 = new Countryregion();
		c1.setCountryregioncode("VEN");
		daoCountryregion.save(c);
		daoCountryregion.save(c1);
		Stateprovince a1 = new Stateprovince();
		a1.setStateprovincecode("65432");
		a1.setIsonlystateprovinceflag("N");
		a1.setName("Maracaibo"); 
		a1.setCountryregion(c1);
		
		Stateprovince a2 = new Stateprovince();
		a2.setStateprovincecode("64815");
		a2.setIsonlystateprovinceflag("N");
		a2.setName("Cundinamarca"); 
		a2.setCountryregion(c);
		
		setUpSave();
		s.setCountryregion(c);
		dao.save(s);
		dao.save(a1);
		dao.save(a2);
		
		
		assertEquals("Valle del cauca", dao.findByCountryregionId(c.getCountryregionid()).get(0).getName());
		assertEquals("Maracaibo", dao.findByCountryregionId(c1.getCountryregionid()).get(0).getName());
		assertEquals("Cundinamarca", dao.findByCountryregionId(c.getCountryregionid()).get(1).getName());
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByTerritoryTest() {

		assertNotNull(dao);
		
		assertNotNull(daoCountryregion);
		
		Salesterritory t1= new Salesterritory();
		t1.setTerritoryid(1);
		Salesterritory t2= new Salesterritory();
		t2.setTerritoryid(1);
		Salesterritory t3= new Salesterritory();
		t3.setTerritoryid(1);
		Salesterritory t4= new Salesterritory();
		t4.setTerritoryid(1);
		
		Countryregion c = new Countryregion();
		c.setCountryregioncode("COL");
		Countryregion c1 = new Countryregion();
		c1.setCountryregioncode("VEN");
		daoCountryregion.save(c);
		daoCountryregion.save(c1);
		Stateprovince a1 = new Stateprovince();
		a1.setStateprovincecode("65432");
		a1.setIsonlystateprovinceflag("N");
		a1.setName("Maracaibo"); 
		a1.setCountryregion(c1);
		
		Stateprovince a2 = new Stateprovince();
		a2.setStateprovincecode("64815");
		a2.setIsonlystateprovinceflag("N");
		a2.setName("Cundinamarca"); 
		a2.setCountryregion(c);
		
		
		
		a1.setTerritoryid(2);
		a2.setTerritoryid(1);
		
		setUpSave();
		s.setCountryregion(c);
		s.setTerritoryid(1);
		dao.save(s);
		dao.save(a1);
		dao.save(a2);
		
		assertEquals("Cundinamarca", dao.findByTerritoryId(1).get(1).getName());
		assertEquals("Maracaibo", dao.findByTerritoryId(2).get(0).getName());
		assertThrows(IndexOutOfBoundsException.class, () -> dao.findByTerritoryId(3).get(0));
		
	}

	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByNameTest() {

		assertNotNull(dao);
		
		assertNotNull(daoCountryregion);
		
		Salesterritory t1= new Salesterritory();
		t1.setTerritoryid(1);
		Salesterritory t2= new Salesterritory();
		t2.setTerritoryid(1);
		Salesterritory t3= new Salesterritory();
		t3.setTerritoryid(1);
		Salesterritory t4= new Salesterritory();
		t4.setTerritoryid(1);
		
		Countryregion c = new Countryregion();
		c.setCountryregioncode("COL");
		Countryregion c1 = new Countryregion();
		c1.setCountryregioncode("VEN");
		daoCountryregion.save(c);
		daoCountryregion.save(c1);
		Stateprovince a1 = new Stateprovince();
		a1.setStateprovincecode("65432");
		a1.setIsonlystateprovinceflag("N");
		a1.setName("Maracaibo"); 
		a1.setCountryregion(c1);
		
		Stateprovince a2 = new Stateprovince();
		a2.setStateprovincecode("64815");
		a2.setIsonlystateprovinceflag("N");
		a2.setName("Cundinamarca"); 
		a2.setCountryregion(c);
		
		
		
		a1.setTerritoryid(2);
		a2.setTerritoryid(1);
		
		setUpSave();
		s.setCountryregion(c);
		s.setTerritoryid(1);
		dao.save(s);
		dao.save(a1);
		dao.save(a2);
		
		assertEquals("64815", dao.findByName("Cundinamarca").get(0).getStateprovincecode());
		assertEquals("65432", dao.findByName("Maracaibo").get(0).getStateprovincecode());
		assertEquals("12345", dao.findByName("Valle del cauca").get(0).getStateprovincecode());
	}
	
//	@Test
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//	public void findByfindByTerritoryIdAtLeastOneSalestaxrateOrderedByNameTest() {
//
//		assertNotNull(dao);
//		
//		assertNotNull(daoCountryregion);
//		
//		Salesterritory t1= new Salesterritory();
//		t1.setTerritoryid(1);
//		Salesterritory t2= new Salesterritory();
//		t2.setTerritoryid(1);
//		Salesterritory t3= new Salesterritory();
//		t3.setTerritoryid(1);
//		Salesterritory t4= new Salesterritory();
//		t4.setTerritoryid(1);
//		
//		Countryregion c = new Countryregion();
//		c.setCountryregioncode("COL");
//		Countryregion c1 = new Countryregion();
//		c1.setCountryregioncode("VEN");
//		daoCountryregion.save(c);
//		daoCountryregion.save(c1);
//		Stateprovince a1 = new Stateprovince();
//		a1.setStateprovincecode("65432");
//		a1.setIsonlystateprovinceflag("N");
//		a1.setName("A"); 
//		a1.setCountryregion(c1);
//		
//		Stateprovince a2 = new Stateprovince();
//		a2.setStateprovincecode("64815");
//		a2.setIsonlystateprovinceflag("N");
//		a2.setName("B"); 
//		a2.setCountryregion(c);
//		
//		
//		
//		a1.setTerritoryid(1);
//		a2.setTerritoryid(1);
//		
//		
//		dao.save(a1);
//		dao.save(a2);
//		ArrayList<Stateprovince> a = (ArrayList) dao.findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(1).get(0);
//		assertEquals("Cundinamarca", "");
//		assertEquals("Maracaibo", dao.findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(2).get(1));
//		}
	
	
}
