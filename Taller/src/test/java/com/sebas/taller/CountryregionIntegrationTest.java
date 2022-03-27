package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.repository.person.CountryregionRepository;
import com.sebas.taller.service.person.CountryregionService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {TallerApplication.class})
class CountryregionIntegrationTest {
	
	CountryregionRepository cr;
	
	CountryregionService cs;
	
	Countryregion c;
	@Autowired
	public CountryregionIntegrationTest(CountryregionService cs, CountryregionRepository cr) {
		this.cs = cs;
		this.cr = cr;
	}
	
	void setUp() {
		c = new Countryregion();
		c.setName("Colombia");
		c.setCountryregioncode("COL");
		
	}
	
	@Test
	void saveTest() {
		setUp();
		assertEquals(c.getName(), cs.save(c).getName());
	}
	
	@Test
	void updateTest() {
		setUp();
		cr.save(c);
		c.setCountryregioncode("VEN");
		c.setName("Venezuela");
		Countryregion updated = cs.update(c);
		assertAll("edit countryregion",
				() -> assertEquals("Venezuela", updated.getName()),
				() -> assertEquals("VEN", updated.getCountryregioncode())
				);
	}
	
	@Test
	void updateNoExistTest() {
		setUp();
		Countryregion c1 = new Countryregion();
		c1.setCountryregionid(123654);
		assertThrows(NullPointerException.class, () -> cs.update(c1));
	}

}
