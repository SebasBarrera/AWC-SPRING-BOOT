package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sebas.taller.dao.interfaces.SalestaxrateDao;
import com.sebas.taller.dao.interfaces.StateprovinceDao;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.service.sales.SalestaxrateService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {TallerApplication.class})
class SalestaxrateIntegrationTest {

	SalestaxrateDao tr;
	
	StateprovinceDao sr;
	
	SalestaxrateService ts;
	
	Salestaxrate t;
	
	Stateprovince s;
	
	@Autowired
	public SalestaxrateIntegrationTest(SalestaxrateDao tr, StateprovinceDao sr, SalestaxrateService ts) {
		this.tr = tr;
		this.sr = sr;
		this.ts = ts;
	}
	
	
	void setUpSave() {
		t = new Salestaxrate();
		s = new Stateprovince();
		
		t.setTaxrate(0.0);
		t.setName("Impuesto al consumo");
	}
	
	
	
	@Test
	void saveTest() {
		setUpSave();
		sr.save(s);
		t.setStateprovince(s);
		//assertEquals(t, ts.save(t));
	}
	

	@Test
	void updateTest() {
		setUpSave();
		tr.save(t);
		sr.save(s);
		t.setStateprovince(s);
		t.setTaxrate(1.0);
		t.setName("Impuesto al valor agregado");
		Salestaxrate updated = ts.update(t);
		assertAll("Sales tax rate update",
				() -> assertEquals(s.getStateprovinceid(), updated.getStateprovince().getStateprovinceid()),
				() -> assertEquals(1.0, updated.getTaxrate()),
				() -> assertEquals("Impuesto al valor agregado", updated.getName())
				);
	}
	
	
	

}
