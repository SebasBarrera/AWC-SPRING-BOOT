package com.sebas.taller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.repository.person.AddressRepository;
import com.sebas.taller.repository.person.StateprovinceRepository;
import com.sebas.taller.service.person.AddressService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {AddressService.class})
class AddressIntegrationTest {
	
	AddressRepository ar;
	
	StateprovinceRepository sr;
	
	AddressService as;
	
	Address a;
	
	Stateprovince s;

	Stateprovince s1;
	
	public AddressIntegrationTest(AddressRepository ar, StateprovinceRepository sr, AddressService as) {
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
		Stateprovince s1 = new Stateprovince();
		a.setAddressline1("Carrera 55 b # 186 - 81");
		a.setCity("Bogota");
		a.setStateprovince(s1);
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
		sr.save(s1);
		assertEquals(a, as.update(a));
	}
	
	@Test
	void updateNoExistStateProvinceTest() {
		setUpUpdate();
		assertThrows(NullPointerException.class, () -> as.update(a));
	}
	
	@Test
	void updateNoExistTest() {
		Address a1 = new Address();
		assertThrows(NullPointerException.class, () -> as.update(a1));
	}
}
