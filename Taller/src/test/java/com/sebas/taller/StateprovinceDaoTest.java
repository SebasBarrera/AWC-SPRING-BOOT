package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.taller.dao.implementation.CountryregionDaoImp;
import com.sebas.taller.dao.implementation.SalestaxrateDaoImp;
import com.sebas.taller.dao.implementation.StateprovinceDaoImp;
import com.sebas.taller.dao.interfaces.AddressDao;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.repository.sales.SalesterritoryRepository;

@SpringBootTest
@ContextConfiguration(classes = {TallerApplication.class}) 
class StateprovinceDaoTest {

	@Autowired
	private StateprovinceDaoImp dao;
	
	@Autowired 
	private CountryregionDaoImp daoCountryregion;
	
	@Autowired
	private SalesterritoryRepository tr;
	
	@Autowired
	private SalestaxrateDaoImp taxDao;
	
	@Autowired
	private AddressDao addDao;
	
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
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByfindByTerritoryIdAtLeastOneSalestaxrateOrderedByNameTest() {
		
		assertNotNull(dao);
		
		assertNotNull(daoCountryregion);
		
		Address city = new Address();
		addDao.save(city);
		Address city1 = new Address();
		addDao.save(city1);
		Address city2 = new Address();
		addDao.save(city2);
		Address city3 = new Address();
		addDao.save(city3);
		Address city4 = new Address();
		addDao.save(city4);
		Address city5 = new Address();
		addDao.save(city5);
		Address city6 = new Address();
		addDao.save(city6);
		Address city7 = new Address();
		addDao.save(city7);
		Address city8 = new Address();
		addDao.save(city8);
		Address city9 = new Address();
		addDao.save(city9);
		Address city10 = new Address();
		addDao.save(city10);
		
		Salestaxrate tax1 =new Salestaxrate();
		taxDao.save(tax1);
		Salestaxrate tax2 =new Salestaxrate();
		taxDao.save(tax2);
		Salestaxrate tax3 =new Salestaxrate();
		taxDao.save(tax3);
		Salestaxrate tax4 =new Salestaxrate();
		taxDao.save(tax4);
		
		Salesterritory t1= new Salesterritory();
		tr.save(t1);
		Salesterritory t2= new Salesterritory();
		tr.save(t2);
		Salesterritory t3= new Salesterritory();
		tr.save(t3);
		Salesterritory t4= new Salesterritory();
		tr.save(t4);
		
		Stateprovince s1 = new Stateprovince();
		s1.setName("Valle del Cauca");
		dao.save(s1);
		Stateprovince s2 = new Stateprovince();
		s2.setName("Cundinamarca");
		dao.save(s2);
		Stateprovince s3 = new Stateprovince();
		s3.setName("Boyaca");
		dao.save(s3);
		Stateprovince s4 = new Stateprovince();
		s4.setName("Atlantico");
		dao.save(s4);
		Stateprovince s5 = new Stateprovince();
		s5.setName("Antioquia");
		dao.save(s5);
		
		s1.setTerritoryid(t1.getTerritoryid());
		s2.setTerritoryid(t2.getTerritoryid());
		s3.setTerritoryid(t1.getTerritoryid());
		s4.setTerritoryid(t2.getTerritoryid());
		
//		tax1.setStateprovince(s5);
//		tax2.setStateprovince(s4);
//		tax3.setStateprovince(s3);
//		tax4.setStateprovince(s2);
		
		List<Salestaxrate> lstr1 = new ArrayList<Salestaxrate>();
		lstr1.add(tax1);
		List<Salestaxrate> lstr2 = new ArrayList<Salestaxrate>();
		lstr1.add(tax2);
		List<Salestaxrate> lstr3 = new ArrayList<Salestaxrate>();
		lstr1.add(tax3);
		List<Salestaxrate> lstr4 = new ArrayList<Salestaxrate>();
		lstr1.add(tax4);
		
		s5.setSalestaxrates(lstr1);
		s4.setSalestaxrates(lstr2);
		s3.setSalestaxrates(lstr3);
		s2.setSalestaxrates(lstr4);
		
		List<Address> la = new ArrayList<Address>();
		la.add(city);
		List<Address> la1 = new ArrayList<Address>();
		la1.add(city1);
		
		s1.setAddresses(la);
		s5.setAddresses(la1);
		
		List<Address> la2 = new ArrayList<Address>();
		la2.add(city2);
		la2.add(city3);
		la2.add(city4);
		List<Address> la3 = new ArrayList<Address>();
		la3.add(city5);
		la3.add(city6);
		la3.add(city7);
		la3.add(city8);
		List<Address> la4 = new ArrayList<Address>();
		la4.add(city9);
		la4.add(city10);
		
		s2.setAddresses(la2);
		s3.setAddresses(la3);
		s4.setAddresses(la4);
		
		city.setStateprovince(s1);
		city1.setStateprovince(s5);
		
		city2.setStateprovince(s2);
		city3.setStateprovince(s2);
		city4.setStateprovince(s2);
		
		city5.setStateprovince(s3);
		city6.setStateprovince(s3);
		city7.setStateprovince(s3);
		city8.setStateprovince(s3);
		
		city9.setStateprovince(s4);
		city10.setStateprovince(s4);
		
		List<Object[]> stAd = dao.findByTerritoryIdAtLeastOneSalestaxrateOrderedByName(t2.getTerritoryid());
		
		String previousName = null;
		boolean flag = false;
		for (Object[] spArray : stAd) {
			Stateprovince sp = (Stateprovince) spArray[0];
			long numOfAddresses = (long) spArray[1];
			if (!flag) {
				previousName = sp.getName();
				flag = true;
			}
			
			assertEquals(sp.getTerritoryid(), t2.getTerritoryid());
			assertEquals(sp.getAddresses().size(), numOfAddresses);
			assertTrue(sp.getSalestaxrates().size() > 0);
			assertTrue(sp.getName().compareTo(previousName) >= 0);
			
			previousName = sp.getName();
		}
	
	}
	
	
	


}
