package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.repository.person.CountryregionRepository;
import com.sebas.taller.repository.person.StateprovinceRepository;
import com.sebas.taller.repository.sales.SalesterritoryRepository;
import com.sebas.taller.service.person.StateprovinceService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {TallerApplication.class})
class StateprovinceIntegrationTest {
	
	StateprovinceRepository sr;
	
	CountryregionRepository cr;
	
	SalesterritoryRepository tr;
	
	Stateprovince s;
	
	Countryregion c;
	
	Salesterritory t;
	
	StateprovinceService ss;
	
	@Autowired
	public StateprovinceIntegrationTest(StateprovinceService ss, StateprovinceRepository sr, CountryregionRepository cr, SalesterritoryRepository tr) {
		this.sr = sr;
		this.ss = ss;
		this.cr = cr;
		this.tr = tr;
	}
	
	void setUpSave() {
		s = new Stateprovince();
		c = new Countryregion();
		t = new Salesterritory();
		s.setCountryregion(c);
		s.setTerritoryid(t.getTerritoryid());
		s.setStateprovincecode("12345");
		s.setIsonlystateprovinceflag("Y");
		s.setName("Valle del cauca");
	}
	
	void setUpUpdate() {
		setUpSave();
		cr.save(c);
		tr.save(t);
		s.setTerritoryid(t.getTerritoryid());
		sr.save(s);
	}
	

	@Test
	void saveTest() {
		setUpSave();
		cr.save(c);
		tr.save(t);
		s.setTerritoryid(t.getTerritoryid());
		assertEquals(s, ss.save(s));
	}
	
	@Test
	void noCountryregionSaveTest() {
		setUpSave();
		tr.save(t);
		assertThrows(NullPointerException.class, () -> ss.save(s));
	}
	
	@Test
	void noSalesterritorySaveTest() {
		setUpSave();
		cr.save(c);
		assertThrows(NullPointerException.class, () -> ss.save(s));
	}
	
	@Test
	void updateTest() {
		setUpUpdate();
		Countryregion c1 = new Countryregion();
		Salesterritory t1 = new Salesterritory();
		tr.save(t1);
		cr.save(c1);
		s.setCountryregion(c1);
		s.setTerritoryid(t1.getTerritoryid());
		s.setStateprovincecode("98765");
		s.setIsonlystateprovinceflag("N");
		s.setName("Cundinamarca");
		Stateprovince updated = ss.update(s);
		assertAll("State province update",
				() -> assertEquals("98765", updated.getStateprovincecode()),
				() -> assertEquals("N", updated.getIsonlystateprovinceflag()),
				() -> assertEquals("Cundinamarca", updated.getName())
				);
	}
	
	@Test
	void noCountryregionUpdateTest() {
		setUpUpdate();
		Countryregion c1 = new Countryregion();
		Salesterritory t1 = new Salesterritory();
		t1.setTerritoryid(54655);
		cr.save(c1);
		s.setCountryregion(c1);
		s.setTerritoryid(t1.getTerritoryid());
		s.setStateprovincecode("98765");
		s.setIsonlystateprovinceflag("N");
		s.setName("Cundinamarca");
		assertThrows(NullPointerException.class, () -> ss.update(s));
	}
	
	@Test
	void noSalesterritoryUpdateTest() {
		setUpUpdate();
		Countryregion c2 = new Countryregion();
		Salesterritory t1 = new Salesterritory();
		tr.save(t1);
		c2.setCountryregionid(654);
		s.setCountryregion(c2);
		s.setTerritoryid(t1.getTerritoryid());
		s.setStateprovincecode("98765");
		s.setIsonlystateprovinceflag("N");
		s.setName("Cundinamarca");
		assertThrows(NullPointerException.class, () -> ss.update(s));
	}
	
	@Test
	void noExtistUpdateTest() {
		Stateprovince s1 = new Stateprovince();
		Countryregion c1 = new Countryregion();
		Salesterritory t1 = new Salesterritory();
		s1.setCountryregion(c1);
		tr.save(t1);
		cr.save(c1);
		s1.setTerritoryid(t1.getTerritoryid());
		s1.setStateprovincecode("12345");
		s1.setIsonlystateprovinceflag("Y");
		s1.setName("Valle del cauca");
	}
	

}
