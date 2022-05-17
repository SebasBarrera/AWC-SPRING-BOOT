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
//		Address city = new Address();
//		Address city1 = new Address();
//		Address city2 = new Address();
//		Address city3 = new Address();
//		Address city4 = new Address();
//		Address city5 = new Address();
//		Address city6 = new Address();
//		Address city7 = new Address();
//		Address city8 = new Address();
//		Address city9 = new Address();
//		Address city10 = new Address();
//		
//		Salestaxrate s1 =new Salestaxrate();
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
//		a1.setName("Z"); 
//		a1.setCountryregion(c1);
//		
//		Stateprovince a2 = new Stateprovince();
//		a2.setStateprovincecode("64815");
//		a2.setIsonlystateprovinceflag("N");
//		a2.setName("X"); 
//		a2.setCountryregion(c);
//		
//		
//		setUpSave();
//		s.setCountryregion(c);
//		s.setTerritoryid(1);
//		a1.setTerritoryid(1);
//		a2.setTerritoryid(1);
//		
//		Stateprovince a3 = new Stateprovince();
//		a3.setTerritoryid(3);
//		a3.setName("M");
//		Stateprovince a4 = new Stateprovince();
//		a4.setTerritoryid(3);
//		a4.setName("AAAAA");;
//		Stateprovince a5 = new Stateprovince();
//		a5.setName("A");
//		a5.setTerritoryid(3);
//		
//		s1.setStateprovince(a5);
//		
//		s1.setStateprovince(s);
//		s1.setStateprovince(a2);
//		
//		city.setStateprovince(s);
//		city1.setStateprovince(s);
//		city2.setStateprovince(a1);
//		city3.setStateprovince(a2);
//		city4.setStateprovince(a2);
//		city5.setStateprovince(a3);
//		city6.setStateprovince(a4);
//		city7.setStateprovince(a5);
//		city8.setStateprovince(a4);
//		city9.setStateprovince(a3);
//		city10.setStateprovince(a2);
//		
//		dao.save(a5);
//		dao.save(a4);
//		dao.save(s);
//		dao.save(a3);
//		dao.save(a1);
//		dao.save(a2);
//		
//		ArrayList<Stateprovince> territory1SateprovinceList =  (ArrayList<Stateprovince>) dao.findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(1).get(0);
//		ArrayList<Stateprovince> territory3SateprovinceList =  (ArrayList<Stateprovince>) dao.findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(3).get(0);
//		Integer territory1CitiesAmount = (Integer) dao.findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(1).get(1);
//		Integer territory3CitiesAmount = (Integer) dao.findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(3).get(1);
//		
//		assertEquals(5, territory1CitiesAmount);
//	
//	}
	
	
	


}
