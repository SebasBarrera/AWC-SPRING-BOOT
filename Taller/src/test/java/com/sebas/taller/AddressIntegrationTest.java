package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sebas.taller.dao.interfaces.AddressDao;
import com.sebas.taller.dao.interfaces.StateprovinceDao;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.service.person.AddressService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {TallerApplication.class})
class AddressIntegrationTest {
	
	AddressDao ar;
	
	StateprovinceDao sr;
	
	AddressService as;
	
	Address a;
	
	Stateprovince s;

	Stateprovince s1;
	
	@Autowired
	public AddressIntegrationTest(AddressDao ar, StateprovinceDao sr, AddressService as) {
		this.as = as;
		this.ar = ar;
		this.sr = sr;
	}
	
	void setUpSave() {
		a = new Address();
		s = new Stateprovince();
		sr.save(s);
		a.setAddressline1("Cra 68 # 16 - 07");
		a.setCity("Cali");
		a.setPostalcode("760033");
	}
	
	void setUpUpdate() {
		setUpSave();
		a.setStateprovince(s);
		ar.save(a);
		
		
		
	}
	
	@Test
	void saveTest() {
		setUpSave();
		a.setStateprovince(s);
		assertEquals(a, as.save(a));
	}
	
	@Test
	void noExistStateProvinceSave() {
		setUpSave();
		
		assertThrows(NullPointerException.class, () -> as.save(a));
	}

	@Test
	void updateTest() {
		setUpUpdate();
		Stateprovince s1 = new Stateprovince();
		a.setAddressline1("Carrera 55 b # 186 - 81");
		a.setCity("Bogota");
		sr.save(s1);
		a.setStateprovince(s1);
		Address updated = as.update(a);
		assertAll("address update",
				() -> assertEquals("Carrera 55 b # 186 - 81", updated.getAddressline1()),
				() -> assertEquals("Bogota", updated.getCity()),
				() -> assertEquals(s1.getStateprovinceid(), updated.getStateprovince().getStateprovinceid())
				);
	}
	
	@Test
	void updateNoExistStateProvinceTest() {
		setUpUpdate();
		a.setAddressline1("Carrera 55 b # 186 - 81");
		a.setCity("Bogota");
		Stateprovince s1 = new Stateprovince();
		s1.setStateprovinceid(132);
		a.setStateprovince(s1);
		assertThrows(NullPointerException.class, () -> as.update(a));
	}
	
	@Test
	void updateNoExistTest() {
		Address a1 = new Address();
		assertThrows(NullPointerException.class, () -> as.update(a1));
	}
}
