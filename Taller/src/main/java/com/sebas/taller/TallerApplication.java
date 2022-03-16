package com.sebas.taller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.repository.person.StateprovinceRepository;
import com.sebas.taller.service.person.AddressService;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@ComponentScan
@Log4j2
public class TallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerApplication.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner address(AddressService as, StateprovinceRepository sr) {
		return (args) -> {
			Stateprovince s1 = new Stateprovince();
			sr.save(s1);
			
			
			Address a1 = new Address();
			a1.setAddressid(1);
			a1.setAddressline1("Cra 68 # 16 - 07");
			a1.setCity("Cali");
			a1.setPostalcode("330076");
			a1.setStateprovince(s1);
			
			as.save(a1);
			log.info(as.search(a1).getAddressline1());
		};
	}

}
