package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.repository.hr.EmployeeRepository;
import com.sebas.taller.repository.person.AddressRepository;
import com.sebas.taller.repository.person.BusinessentityRepository;
import com.sebas.taller.repository.person.CountryregionRepository;
import com.sebas.taller.repository.person.StateprovinceRepository;
import com.sebas.taller.repository.sales.SalestaxrateRepository;
import com.sebas.taller.repository.sales.SalesterritoryRepository;
import com.sebas.taller.service.person.AddressService;
import com.sebas.taller.service.person.AddressServiceImp;
import com.sebas.taller.service.person.CountryregionService;
import com.sebas.taller.service.person.CountryregionServiceImp;
import com.sebas.taller.service.person.StateprovinceService;
import com.sebas.taller.service.person.StateprovinceServiceImp;
import com.sebas.taller.service.sales.SalestaxrateService;
import com.sebas.taller.service.sales.SalestaxrateServiceImp;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {AddressService.class, CountryregionService.class, StateprovinceService.class, SalestaxrateService.class})
class UnitTest {

	
	
	@MockBean
	private AddressRepository ar;
	@MockBean
	private EmployeeRepository er;
	@MockBean
	private SalestaxrateRepository tr;
	@MockBean
	private StateprovinceRepository pr;
	@MockBean 
	private SalesterritoryRepository sr;
	@MockBean
	private BusinessentityRepository br;
	@MockBean
	private CountryregionRepository cr;
	
	
	@InjectMocks
	private AddressServiceImp as;
	@InjectMocks
	private CountryregionServiceImp cs;
	@InjectMocks
	private StateprovinceServiceImp ps;
	@InjectMocks
	private SalestaxrateServiceImp ts;
	
	
	
	private Countryregion c1;
	private Salesterritory t1;
	private Stateprovince s1;
	private Stateprovince p1;
	private Salestaxrate tax1;
	private Address a1;
	
	//------------------------------COUNTRY REGION------------------------------
	
	void setUpUpdateCr() {
		c1 = new Countryregion();
		c1.setCountryregionid(123);
		c1.setCountryregioncode("COL");
		c1.setName("Colombia");
		when(cr.findById(123)).thenReturn(Optional.ofNullable(c1));
		cr.save(c1);
		verify(cr).save(c1);
	}
	
	
	

	
	@Test
	@Tag("CountryRegionService")
	@Tag("Save")
	void saveNullCrTest() {
		Countryregion c = null;
		assertThrows(NullPointerException.class, () -> cs.save(c));
		verifyNoInteractions(cr);
	}
	
	@Test
	@Tag("CountryRegionService")
	@Tag("Save")
	void saveVoidCrTest() {
		Countryregion c = new Countryregion();
		assertThrows(NullPointerException.class, () -> cs.save(c));
		verifyNoInteractions(cr);
	}
	
	
	/*
	@Test
	@Tag("CountryRegionService")
	@Tag("Save")
	void saveMinCodeCrTest() {
		Countryregion c = new Countryregion();
		c.setCountryregioncode(12);
		c.setName("Colombia");
		assertThrows(IllegalArgumentException.class, () -> cs.save(c));
		verifyNoInteractions(cr);
	}
	*/
	
	@Test
	@Tag("CountryRegionService")
	@Tag("Save")
	void saveMaxCodeCrTest() {
		Countryregion c = new Countryregion();
		c.setCountryregioncode("Colom");
		c.setCountryregionid(123);
		c.setName("Colombia");
		assertThrows(IllegalArgumentException.class, () -> cs.save(c));
		verifyNoInteractions(cr);
	}
	
	@Test
	@Tag("CountryRegionService")
	@Tag("Save")
	void saveMinNameCrTest() {
		Countryregion c = new Countryregion();
		c.setCountryregioncode("COL");
		c.setCountryregionid(123);
		c.setName("Colo");
		assertThrows(IllegalArgumentException.class, () -> cs.save(c));
		verifyNoInteractions(cr);
	}
	

	

	
	@Test
	@Tag("CountryRegionService")
	@Tag("Update")
	void updateNullCrTest() {
		setUpUpdateCr();
		Countryregion c = null;
		assertThrows(NullPointerException.class, () -> cs.update(c));
		verifyNoMoreInteractions(cr);
	}
	
	@Test
	@Tag("CountryRegionService")
	@Tag("Update")
	void updateVoidCrTest() {
		setUpUpdateCr();
		c1 = new Countryregion();
		when(cr.findById(c1.getCountryregionid())).thenReturn(Optional.ofNullable(c1));
		when(cr.existsById(c1.getCountryregionid())).thenReturn(true);
		assertThrows(NullPointerException.class, () -> cs.update(c1));
		verifyNoMoreInteractions(cr);
	}
	
	/*
	@Test
	@Tag("CountryRegionService")
	@Tag("Update")
	void updateMinCodeCrTest() {
		setUpUpdateCr();
		c1.setCountryregioncode(Integer.parseInt(""));
		c1.setName("Colombia");
		when(cr.findById(c1.getCountryregioncode())).thenReturn(Optional.ofNullable(c1));
		when(cr.existsById(c1.getCountryregioncode())).thenReturn(true);
		assertThrows(IllegalArgumentException.class, () -> cs.update(c1));
		verify(cr).existsById(c1.getCountryregioncode());
		verify(cr).findById(c1.getCountryregioncode());
		verifyNoMoreInteractions(cr);
	}
	*/
	
	@Test
	@Tag("CountryRegionService")
	@Tag("Update")
	void updateMaxCodeCrTest() {
		setUpUpdateCr();
		c1.setCountryregionid(12345);
		c1.setCountryregioncode("COLOM");
		c1.setName("Colombia");
		when(cr.findById(c1.getCountryregionid())).thenReturn(Optional.ofNullable(c1));
		when(cr.existsById(c1.getCountryregionid())).thenReturn(true);
		assertThrows(NullPointerException.class, () -> cs.update(c1));
		verifyNoMoreInteractions(cr);
	}
	

	
	//------------------------------COUNTRY REGION------------------------------
	
	
	
	
	//---------------------------------ADDRESS---------------------------------
	
	void setUpA() {
		s1 = new Stateprovince();
		s1.setStateprovinceid(1);
		pr.save(s1);
	}
	
	void setUpUpdateA() {

		setUpA();
		a1 = new Address();
		a1.setAddressid(1);
		a1.setAddressline1("Cra 68 # 16 - 07");
		a1.setCity("Cali");
		a1.setPostalcode("760033");
		a1.setStateprovince(s1);
		when(pr.existsById(s1.getStateprovinceid())).thenReturn(true);
		when(pr.findById(s1.getStateprovinceid())).thenReturn(Optional.ofNullable(s1));
		when(ar.findById(a1.getAddressid())).thenReturn(Optional.ofNullable(a1));
		ar.save(a1);
		
	}
	
	
	
	
	@Test
	@Tag("Address")
	@Tag("Save")
	void saveNullATest() {
		setUpA();
		Address a = null;
		assertThrows(NullPointerException.class, () -> as.save(a));
		verifyNoInteractions(ar);
	}
	
	@Test
	@Tag("Address")
	@Tag("Save")
	void saveVoidTest() {
		setUpA();
		Address a = new Address();
		assertThrows(NullPointerException.class, () -> as.save(a));
		verifyNoMoreInteractions(ar);
	}
	
	@Test
	@Tag("Address")
	@Tag("Save")
	void saveNoStateATest() {
		setUpA();
		Address a = new Address();
		a.setAddressline1("Cra 68 # 16 - 07");
		a.setCity("Cali");
		a.setPostalcode("760033");
		
		assertThrows(NullPointerException.class, () -> as.save(a));
		verifyNoMoreInteractions(ar);
	}
	
	@Test
	@Tag("Address")
	@Tag("Save")
	void saveLine1NullATest() {
		setUpA();
		Address a = new Address();
		a.setCity("Cali");
		a.setPostalcode("760033");
		a.setStateprovince(s1);
		
		when(pr.existsById(a.getStateprovince().getStateprovinceid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> as.save(a));
		
		verifyNoMoreInteractions(ar);
	}
	
	@Test
	@Tag("Address")
	@Tag("Save")
	void saveMinCityATest() {
		setUpA();
		Address a = new Address();
		a.setAddressline1("Cra 68 # 16 - 07");
		a.setCity("Ca");
		a.setPostalcode("760033");
		a.setStateprovince(s1);
		
		when(pr.existsById(a.getStateprovince().getStateprovinceid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> as.save(a));
		
		
		
		verifyNoMoreInteractions(ar);
	}
	

	
	
	@Test
	@Tag("Address")
	@Tag("Save")
	void saveNoExistStateATest() {
		
		Address a = new Address();
		a.setAddressline1("Cra 68 # 16 - 07");
		a.setCity("Cali");
		a.setPostalcode("760033");
		a.setStateprovince(null);
		
		
		assertThrows(NullPointerException.class, () -> as.save(a));
		verifyNoInteractions(ar);
	}
	
	
	
	
	
	@Test
	@Tag("Address")
	@Tag("Update")
	void updateNullATest() {
		setUpUpdateA();
		Address a = null;
		assertThrows(NullPointerException.class, () -> as.update(a));
	}
	
	@Test
	@Tag("Address")
	@Tag("Update")
	void updateVoidTest() {
		setUpUpdateA();
		Address a = new Address();
		assertThrows(NullPointerException.class, () -> as.update(a));
	}
	
	@Test
	@Tag("Address")
	@Tag("Update")
	void updateNoStateATest() {
		setUpUpdateA();
		a1.setAddressline1("Cra 68 # 16 - 07");
		a1.setCity("Cali");
		a1.setPostalcode("760033");
		assertThrows(NullPointerException.class, () -> as.update(a1));
	}
	
	
	@Test
	@Tag("Address")
	@Tag("Update")
	void updateNoExistATest() {
		setUpUpdateA();
		Address a2 = new Address();
		a2.setAddressline1("Cra 6 # 1 - 00");
		a2.setCity("Bogota");
		a2.setPostalcode("110033");
		a2.setStateprovince(s1);
		
		when(ar.existsById(a2.getAddressid())).thenReturn(false);
		
		assertThrows(NullPointerException.class, () -> as.update(a1));
	}
	
	@Test
	@Tag("Address")
	@Tag("Update")
	void updateLine1NullATest() {
		setUpUpdateA();
		a1.setAddressline1(null);
		a1.setCity("Cali");
		a1.setPostalcode("760033");
		a1.setStateprovince(s1);
		
		when(ar.findById(a1.getAddressid())).thenReturn(Optional.ofNullable(a1));
		when(ar.existsById(a1.getAddressid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> as.update(a1));
		verifyNoMoreInteractions(sr);
	}
	
	
	
	@Test
	@Tag("Address")
	@Tag("Update")
	void updateMinCityATest() {
		setUpUpdateA();
		a1.setAddressline1("Cra 68 # 16 - 07");
		a1.setCity("Ca");
		a1.setPostalcode("760033");
		a1.setStateprovince(s1);
		
		when(ar.findById(a1.getAddressid())).thenReturn(Optional.ofNullable(a1));
		when(sr.existsById(a1.getStateprovince().getStateprovinceid())).thenReturn(true);
		when(ar.existsById(a1.getAddressid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> as.update(a1));
	}
	
	@Test
	@Tag("Address")
	@Tag("Update")
	void updateMaxPostalTest() {
		setUpUpdateA();
		a1.setAddressline1("Cra 68 # 16 - 07");
		a1.setCity("Cali");
		a1.setPostalcode("7600330");
		a1.setStateprovince(s1);
		
		when(ar.findById(a1.getAddressid())).thenReturn(Optional.ofNullable(a1));
		when(sr.existsById(a1.getStateprovince().getStateprovinceid())).thenReturn(true);
		when(ar.existsById(a1.getAddressid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> as.update(a1));
	}
	
	@Test
	@Tag("Address")
	@Tag("Update")
	void updateNoExistStateATest() {
		setUpUpdateA();
		Stateprovince s2 = new Stateprovince();
		a1.setAddressline1("Cra 68 # 16 - 07");
		a1.setCity("Cali");
		a1.setPostalcode("760033");
		a1.setStateprovince(s2);
		
		when(sr.existsById(a1.getStateprovince().getStateprovinceid())).thenReturn(false);
		
		
		assertThrows(NullPointerException.class, () -> as.update(a1));
	}
	
	//---------------------------------ADDRESS---------------------------------
	
	
	
	
	
	//------------------------------STATE PROVINCE------------------------------

	private void setUpP() {
		c1 = new Countryregion();
		c1.setCountryregioncode("COL");
		c1.setCountryregionid(123);
		t1 = new Salesterritory();
		t1.setTerritoryid(1);
		cr.save(c1);
		sr.save(t1);
	}
	
	private void setupUpdateP() {
		setUpP();
		p1 = new Stateprovince();
		p1.setStateprovinceid(1);
		pr.save(p1);
		
	}
	
	
	
	
	@Test
	@Tag("State Province")
	@Tag("Save")
	void saveNullPTest() {
		Stateprovince p = null;
		assertThrows(NullPointerException.class, () -> ps.save(p));
		verifyNoInteractions(pr);
	}
	
	@Test
	@Tag("State Province")
	@Tag("Save")
	void saveNoCountryPTest() {
		setUpP();
		
		Stateprovince p = new Stateprovince();
		p.setCountryregion(null);
		p.setTerritoryid(t1.getTerritoryid());
		p.setStateprovincecode("VALLE");
		p.setName("Valle del Cauca");
		p.setIsonlystateprovinceflag("Y");
		assertThrows(NullPointerException.class, () -> ps.save(p));
		verifyNoInteractions(pr);
	}
	
	@Test
	@Tag("State Province")
	@Tag("Save")
	void saveNoTerritoryPTest() {
		setUpP();
		
		Stateprovince p = new Stateprovince();
		p.setCountryregion(c1);
		p.setTerritoryid(null);
		p.setStateprovincecode("VALLE");
		p.setName("Valle del Cauca");
		p.setIsonlystateprovinceflag("Y");
		assertThrows(NullPointerException.class, () -> ps.save(p));
		verifyNoInteractions(pr);
	}
	
	@Test
	@Tag("State Province")
	@Tag("Save")
	void saveNoCountryExistPTest() {
		setUpP();
		Countryregion c2 = new Countryregion();
		Stateprovince p = new Stateprovince();
		p.setCountryregion(c2);
		p.setTerritoryid(t1.getTerritoryid());
		p.setStateprovincecode("VALLE");
		p.setName("Valle del Cauca");
		p.setIsonlystateprovinceflag("Y");
		
		when(cr.existsById(p.getCountryregion().getCountryregionid())).thenReturn(false);
		
		assertThrows(NullPointerException.class, () -> ps.save(p));
		verifyNoInteractions(pr);
	}
	
	@Test
	@Tag("State Province")
	@Tag("Save")
	void saveNoTerritoryExistPTest() {
		setUpP();
		Salesterritory t2 = new Salesterritory();
		Stateprovince p = new Stateprovince();
		p.setCountryregion(c1);
		p.setTerritoryid(t2.getTerritoryid());
		p.setStateprovincecode("VALLE");
		p.setName("Valle del Cauca");
		p.setIsonlystateprovinceflag("Y");
		when(tr.existsById(p.getTerritoryid())).thenReturn(true);
		assertThrows(NullPointerException.class, () -> ps.save(p));
		verifyNoInteractions(pr);
	}
	
	@Test
	@Tag("State Province")
	@Tag("Save")
	void saveMinStateProvinceCodetPTest() {
		setUpP();
		Stateprovince p = new Stateprovince();
		p.setCountryregion(c1);
		p.setTerritoryid(t1.getTerritoryid());
		p.setStateprovincecode("VALL");
		p.setName("Valle del Cauca");
		p.setIsonlystateprovinceflag("Y");
		
		when(pr.findById(p.getStateprovinceid())).thenReturn(Optional.ofNullable(p));
		when(cr.existsById(p.getCountryregion().getCountryregionid())).thenReturn(true);
		when(sr.existsById(p.getTerritoryid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.save(p));
		verifyNoInteractions(pr);
	}
	
	@Test
	@Tag("State Province")
	@Tag("Save")
	void saveMaxStateProvinceCodetPTest() {
		setUpP();
		Stateprovince p = new Stateprovince();
		p.setCountryregion(c1);
		p.setTerritoryid(t1.getTerritoryid());
		p.setStateprovincecode("VALLEC");
		p.setName("Valle del Cauca");
		p.setIsonlystateprovinceflag("Y");
		
		when(pr.findById(p.getStateprovinceid())).thenReturn(Optional.ofNullable(p));
		when(cr.existsById(p.getCountryregion().getCountryregionid())).thenReturn(true);
		when(sr.existsById(p.getTerritoryid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.save(p));
	}
	
	@Test
	@Tag("State Province")
	@Tag("Save")
	void saveMinNamePTest() {
		setUpP();
		Stateprovince p = new Stateprovince();
		p.setCountryregion(c1);
		p.setTerritoryid(t1.getTerritoryid());
		p.setStateprovincecode("VALLE");
		p.setName("Vall");
		p.setIsonlystateprovinceflag("Y");
		
		when(pr.findById(p.getStateprovinceid())).thenReturn(Optional.ofNullable(p));
		when(cr.existsById(p.getCountryregion().getCountryregionid())).thenReturn(true);
		when(sr.existsById(p.getTerritoryid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.save(p));
	}
	
	@Test
	@Tag("State Province")
	@Tag("Save")
	void saveFlagPTest() {
		setUpP();
		Stateprovince p = new Stateprovince();
		p.setCountryregion(c1);
		p.setTerritoryid(t1.getTerritoryid());
		p.setStateprovincecode("VALLE");
		p.setName("Valle del Cauca");
		p.setIsonlystateprovinceflag("Yes");
		
		when(pr.findById(p.getStateprovinceid())).thenReturn(Optional.ofNullable(p));
		when(cr.existsById(p.getCountryregion().getCountryregionid())).thenReturn(true);
		when(sr.existsById(p.getTerritoryid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.save(p));
	}
	
	
	

	
	@Test
	@Tag("State Province")
	@Tag("Update")
	void updateNullPTest() {
		Stateprovince p = null;
		assertThrows(NullPointerException.class, () -> ps.update(p));
	}
	
	void updateNoExistPTest() {
		Stateprovince p3 = new Stateprovince();
		Countryregion c3 = new Countryregion();
		Salesterritory t3 = new Salesterritory();
		cr.save(c3);
		sr.save(t3);
		
		p1.setCountryregion(c3);
		p1.setTerritoryid(t3.getTerritoryid());
		p1.setStateprovincecode("CUNDI");
		p1.setName("Cundinamarca");
		p1.setIsonlystateprovinceflag("N");
		
		when(pr.findById(p1.getStateprovinceid())).thenReturn(Optional.ofNullable(p1));
		when(cr.existsById(p1.getCountryregion().getCountryregionid())).thenReturn(true);
		when(tr.existsById(p1.getTerritoryid())).thenReturn(true);
		when(pr.existsById(p1.getStateprovinceid())).thenReturn(false);
		
		assertThrows(NullPointerException.class, () -> ps.update(p3));
	}
	

	
	@Test
	@Tag("State Province")
	@Tag("Update")
	void updateNoCountryExistPTest() {
		setupUpdateP();
		Countryregion c2 = new Countryregion();
		p1.setCountryregion(c2);
		p1.setTerritoryid(t1.getTerritoryid());
		p1.setStateprovincecode("VALLE");
		p1.setName("Valle del Cauca");
		p1.setIsonlystateprovinceflag("Y");
		
		when(pr.findById(p1.getStateprovinceid())).thenReturn(Optional.ofNullable(p1));
		when(cr.existsById(p1.getCountryregion().getCountryregionid())).thenReturn(false);
		when(tr.existsById(p1.getTerritoryid())).thenReturn(true);
		when(pr.existsById(p1.getStateprovinceid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.update(p1));
	}
	
	@Test
	@Tag("State Province")
	@Tag("Update")
	void updateNoTerritoryExistPTest() {
		setupUpdateP();
		Salesterritory t2 = new Salesterritory();
		p1.setCountryregion(c1);
		p1.setTerritoryid(t2.getTerritoryid());
		p1.setStateprovincecode("VALLE");
		p1.setName("Valle del Cauca");
		p1.setIsonlystateprovinceflag("Y");
		
		when(pr.findById(p1.getStateprovinceid())).thenReturn(Optional.ofNullable(p1));
		when(cr.existsById(p1.getCountryregion().getCountryregionid())).thenReturn(true);
		when(tr.existsById(p1.getTerritoryid())).thenReturn(false);
		when(pr.existsById(p1.getStateprovinceid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.update(p1));
	}
	
	@Test
	@Tag("State Province")
	@Tag("Update")
	void updateMinStateProvinceCodetPTest() {
		setupUpdateP();
		p1.setCountryregion(c1);
		p1.setTerritoryid(t1.getTerritoryid());
		p1.setStateprovincecode("VALL");
		p1.setName("Valle del Cauca");
		p1.setIsonlystateprovinceflag("Y");
		
		when(pr.findById(p1.getStateprovinceid())).thenReturn(Optional.ofNullable(p1));
		when(cr.existsById(p1.getCountryregion().getCountryregionid())).thenReturn(true);
		when(sr.existsById(p1.getTerritoryid())).thenReturn(true);
		when(pr.existsById(p1.getStateprovinceid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.update(p1));
	}
	
	@Test
	@Tag("State Province")
	@Tag("Update")
	void updateMaxStateProvinceCodetPTest() {
		setupUpdateP();
		p1.setCountryregion(c1);
		p1.setTerritoryid(t1.getTerritoryid());
		p1.setStateprovincecode("VALLEC");
		p1.setName("Valle del Cauca");
		p1.setIsonlystateprovinceflag("Y");
		
		when(pr.findById(p1.getStateprovinceid())).thenReturn(Optional.ofNullable(p1));
		when(cr.existsById(p1.getCountryregion().getCountryregionid())).thenReturn(true);
		when(sr.existsById(p1.getTerritoryid())).thenReturn(true);
		when(pr.existsById(p1.getStateprovinceid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.update(p1));
	}
	
	@Test
	@Tag("State Province")
	@Tag("Update")
	void updateMinNamePTest() {
		setupUpdateP();
		p1.setCountryregion(c1);
		p1.setTerritoryid(t1.getTerritoryid());
		p1.setStateprovincecode("VALLE");
		p1.setName("Vall");
		p1.setIsonlystateprovinceflag("Y");
		
		when(pr.findById(p1.getStateprovinceid())).thenReturn(Optional.ofNullable(p1));
		when(cr.existsById(p1.getCountryregion().getCountryregionid())).thenReturn(true);
		when(sr.existsById(p1.getTerritoryid())).thenReturn(true);
		when(pr.existsById(p1.getStateprovinceid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.update(p1));
	}
	
	
	@Test
	@Tag("State Province")
	@Tag("Update")
	void updateFlagPTest() {
		setupUpdateP();
		p1.setCountryregion(c1);
		p1.setTerritoryid(t1.getTerritoryid());
		p1.setStateprovincecode("VALLE");
		p1.setName("Valle del Cauca");
		p1.setIsonlystateprovinceflag("Yes");
		
		when(pr.findById(p1.getStateprovinceid())).thenReturn(Optional.ofNullable(p1));
		when(cr.existsById(p1.getCountryregion().getCountryregionid())).thenReturn(true);
		when(sr.existsById(p1.getTerritoryid())).thenReturn(true);
		when(pr.existsById(p1.getStateprovinceid())).thenReturn(true);
		
		assertThrows(NullPointerException.class, () -> ps.update(p1));
	}

	//------------------------------STATE PROVINCE------------------------------
	
	
	
	
	//------------------------------SALES TAX RATE------------------------------
	
	void setUpT() {
		p1 = new Stateprovince();
		p1.setStateprovinceid(1);
		when(pr.findById(p1.getStateprovinceid())).thenReturn(Optional.ofNullable(p1));
		p1.setStateprovincecode("Valle");
		pr.save(p1);
	}
	
	void setUpUpdateT() {
		setUpT();
		tax1 = new Salestaxrate();
		tax1.setSalestaxrateid(1);
		tax1.setTaxrate(1.1);
		tax1.setName("Impuesto al consumo");
		tax1.setStateprovince(p1);
		when(pr.existsById(tax1.getSalestaxrateid())).thenReturn(true);
		when(tr.findById(tax1.getSalestaxrateid())).thenReturn(Optional.ofNullable(tax1));
		ts.save(tax1);
	}
	
	

	
	@Test
	@Tag("Sales Tax Rate")
	@Tag("Save")
	void saveNullTTest() {
		setUpT();
		
		Salestaxrate t = null;
		
		assertThrows(NullPointerException.class, () -> ts.save(t));
	}
	
	@Test
	@Tag("Sales Tax Rate")
	@Tag("Save")
	void saveStateNullTTest() {
		setUpT();
		
		Salestaxrate t = new Salestaxrate();
		t.setStateprovince(null);
		t.setTaxrate(1.1);
		t.setName("Impuesto al consumo");
		
		//when(pr.existsById(t.getStateprovinceid())).thenReturn(false);
		when(tr.findById(t.getSalestaxrateid())).thenReturn(Optional.ofNullable(t));
		
		
		assertThrows(NullPointerException.class, () -> ts.save(t));
	}
	
	@Test
	@Tag("Sales Tax Rate")
	@Tag("Save")
	void saveStateNoExistTTest() {
		setUpT();
		
		Salestaxrate t = new Salestaxrate();
		t.setStateprovince(p1);
		t.setTaxrate(1.1);
		t.setName("Impuesto al consumo");
		
		//when(pr.existsById(t.getStateprovinceid())).thenReturn(false);
		when(tr.findById(t.getSalestaxrateid())).thenReturn(Optional.ofNullable(t));
		
		
		assertThrows(NullPointerException.class, () -> ts.save(t));
	}
	
	


	
	
	

	
	
	
	
	
	
	//------------------------------SALES TAX RATE------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
}
