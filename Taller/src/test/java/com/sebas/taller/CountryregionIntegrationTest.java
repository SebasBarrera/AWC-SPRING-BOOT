package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.repository.person.CountryregionRepository;
import com.sebas.taller.service.person.CountryregionService;

class CountryregionIntegrationTest {
	
	CountryregionRepository cr;
	
	CountryregionService cs;
	
	Countryregion c;
	@Autowired
	public CountryregionIntegrationTest(CountryregionService cs, CountryregionRepository cr) {
		this.cs = cs;
		this.cr = cr;
	}
	
	@BeforeEach
	void setUp() {
		c = new Countryregion();
		c.setCountryregioncode("COL");
		c.setName("Colombia");
	}
	
	@Test
	void saveTest() {
		assertEquals(c, cs.save(c));
	}
	
	@Test
	void updateTest() {
		assertEquals(c, cs.update(c));
	}
	
	@Test
	void updateNoExistTest() {
		Countryregion c1 = new Countryregion();
		assertThrows(NullPointerException.class, () -> cs.update(c1));
	}

}
