       package com.sebas.taller;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.sebas.taller.model.User;
import com.sebas.taller.model.UserType;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.service.UserServiceImp;
import com.sebas.taller.service.person.AddressService;
import com.sebas.taller.service.person.AddressServiceImp;
import com.sebas.taller.service.person.CountryregionService;
import com.sebas.taller.service.person.CountryregionServiceImp;
import com.sebas.taller.service.person.StateprovinceService;
import com.sebas.taller.service.person.StateprovinceServiceImp;
import com.sebas.taller.service.sales.SalestaxrateService;
import com.sebas.taller.service.sales.SalestaxrateServiceImp;
import com.sebas.taller.service.sales.SalesterritoryService;
import com.sebas.taller.service.sales.SalesterritoryServiceImp;


@SpringBootApplication
public class TallerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(TallerApplication.class, args);
	
		StateprovinceService ss = c.getBean(StateprovinceServiceImp.class);
		CountryregionService cs = c.getBean(CountryregionServiceImp.class);
		SalesterritoryService sts = c.getBean(SalesterritoryServiceImp.class);
		SalestaxrateService ts = c.getBean(SalestaxrateServiceImp.class);
		AddressService as = c.getBean(AddressServiceImp.class);
		Stateprovince s = new Stateprovince();
		Countryregion c1 = new Countryregion();
		Salestaxrate tax1 = new Salestaxrate();
		c1.setCountryregioncode("COL");
		c1.setName("Colombia");
		
		Salesterritory t1 = new Salesterritory();
		
		Salesterritory t2 = new Salesterritory();
		Salesterritory t3 = new Salesterritory();
		Salesterritory t4 = new Salesterritory();
		Salesterritory t5 = new Salesterritory();
		sts.save(t1);
		sts.save(t2);
		sts.save(t3);
		sts.save(t4);
		sts.save(t5);
		
		cs.save(c1);
		s.setCountryregion(c1);
		s.setTerritoryid(t1.getTerritoryid());
		s.setStateprovincecode("98765");
		s.setIsonlystateprovinceflag("N");
		s.setName("Valle Del Cauca");
		ss.save(s);
		tax1.setStateprovince(s);
		tax1.setTaxrate(19.0);
		tax1.setName("Impuesto");
		ts.save(tax1);
		
		Address a1 = new Address();
		a1.setAddressline1("Cra 68 # 16 - 07");
		a1.setPostalcode("760033");
		a1.setCity("Cali");
		a1.setStateprovince(s);
		as.save(a1);
		
		UserServiceImp us = c.getBean(UserServiceImp.class);
		
		
		
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("{noop}admin123");
		admin.setType(UserType.administrator);
		User operator = new User();
		operator.setUsername("operator");
		operator.setPassword("{noop}ope123");
		operator.setType(UserType.operator);
		us.save(operator);
		us.save(admin);
	}
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

}
