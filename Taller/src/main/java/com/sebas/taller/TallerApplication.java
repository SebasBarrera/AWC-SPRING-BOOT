package com.sebas.taller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.sebas.taller.model.User;
import com.sebas.taller.model.UserType;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.service.UserServiceImp;
import com.sebas.taller.service.person.CountryregionService;
import com.sebas.taller.service.person.CountryregionServiceImp;
import com.sebas.taller.service.person.StateprovinceService;
import com.sebas.taller.service.person.StateprovinceServiceImp;
import com.sebas.taller.service.sales.SalestaxrateService;
import com.sebas.taller.service.sales.SalestaxrateServiceImp;
import com.sebas.taller.service.sales.SalesterritoryService;


@SpringBootApplication
@ComponentScan
public class TallerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(TallerApplication.class, args);
	
		StateprovinceService ss = c.getBean(StateprovinceServiceImp.class);
		SalestaxrateService ts = c.getBean(SalestaxrateServiceImp.class);
		CountryregionService cs = c.getBean(CountryregionServiceImp.class);
		SalesterritoryService sts = c.getBean(SalesterritoryService.class);
		Stateprovince s = new Stateprovince();
		Countryregion c1 = new Countryregion();
		Salesterritory t1 = new Salesterritory();
		sts.save(t1);
		cs.save(c1);
		s.setCountryregion(c1);
		s.setTerritoryid(t1.getTerritoryid());
		s.setStateprovincecode("98765");
		s.setIsonlystateprovinceflag("N");
		s.setName("Cundinamarca");
		ss.save(s);
		
		UserServiceImp us = c.getBean(UserServiceImp.class);
		
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin123");
		admin.setType(UserType.admin);
		User operator = new User();
		operator.setUsername("operator");
		operator.setPassword("ope123");
		operator.setType(UserType.operator);
		
		us.save(operator);
		us.save(admin);
	}
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	
	/*
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
	*/

}
