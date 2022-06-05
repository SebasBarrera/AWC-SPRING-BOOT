package com.sebas.taller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.sebas.taller.model.Users;
import com.sebas.taller.model.UserType;
import com.sebas.taller.model.person.Address;
import com.sebas.taller.model.person.Countryregion;
import com.sebas.taller.model.person.Stateprovince;
import com.sebas.taller.model.sales.Salesorderheader;
import com.sebas.taller.model.sales.Salestaxrate;
import com.sebas.taller.model.sales.Salesterritory;
import com.sebas.taller.repository.sales.SalesorderheaderRepository;
import com.sebas.taller.service.UserServiceImp;
import com.sebas.taller.service.person.AddressService;
import com.sebas.taller.service.person.AddressServiceImp;
import com.sebas.taller.service.person.CountryregionService;
import com.sebas.taller.service.person.CountryregionServiceImp;
import com.sebas.taller.service.person.StateprovinceService;
import com.sebas.taller.service.person.StateprovinceServiceImp;
import com.sebas.taller.service.sales.SalesorderheaderService;
import com.sebas.taller.service.sales.SalesorderheaderServiceImp;
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
		SalesorderheaderService sos = c.getBean(SalesorderheaderServiceImp.class);
		AddressService as = c.getBean(AddressServiceImp.class);
		UserServiceImp us = c.getBean(UserServiceImp.class);


		//		Countryregion c1 = new Countryregion();
		//		c1.setCountryregioncode("COL");
		//		c1.setName("Colombia");
		//		cs.save(c1);
		//		
		//		Salesterritory t1 = new Salesterritory();
		//		Salesterritory t2 = new Salesterritory();
		//		Salesterritory t3 = new Salesterritory();
		//		Salesterritory t4 = new Salesterritory();
		//		Salesterritory t5 = new Salesterritory();
		//		sts.save(t1);
		//		sts.save(t2);
		//		sts.save(t3);
		//		sts.save(t4);
		//		sts.save(t5);
		//
		//		Stateprovince s = new Stateprovince();
		//		s.setCountryregion(c1);
		//		s.setTerritoryid(t1.getTerritoryid());
		//		s.setStateprovincecode("98765");
		//		s.setIsonlystateprovinceflag("N");
		//		s.setName("Valle Del Cauca");
		//		ss.save(s);
		//		
		//		Salestaxrate tax1 = new Salestaxrate();
		//		tax1.setStateprovince(s);
		//		tax1.setTaxrate(19.0);
		//		tax1.setName("Impuesto");
		//		ts.save(tax1);
		//		
		//		Address a1 = new Address();
		//		a1.setAddressline1("Cra 68 # 16 - 07");
		//		a1.setPostalcode("760033");
		//		a1.setCity("Cali");
		//		a1.setStateprovince(s);
		//		as.save(a1);

		Users admin = new Users();
		admin.setUsername("admin");
		admin.setPassword("{noop}admin123");
		admin.setType(UserType.administrator);
		us.save(admin);

		Users operator = new Users();
		operator.setUsername("operator");
		operator.setPassword("{noop}ope123");
		operator.setType(UserType.operator);
		us.save(operator);


		Address city = new Address();
		Address city1 = new Address();
		Address city2 = new Address();
		Address city3 = new Address();
		Address city4 = new Address();
		Address city5 = new Address();
		Address city6 = new Address();
		Address city7 = new Address();
		Address city8 = new Address();
		Address city9 = new Address();
		Address city10 = new Address();


		Salesterritory t1= new Salesterritory();
		sts.save(t1);
		Salesterritory t2= new Salesterritory();
		sts.save(t2);
		Salesterritory t3= new Salesterritory();
		sts.save(t3);
		Salesterritory t4= new Salesterritory();
		sts.save(t4);


		Salesorderheader h1 = new Salesorderheader();
		h1.setComment("header1");
		sos.save(h1);
		Salesorderheader h2 = new Salesorderheader();
		h2.setComment("header2");
		sos.save(h2);

		List<Salesorderheader> lHeader = new ArrayList<>();
		lHeader.add(h1);
		lHeader.add(h2);

		t2.setSalesorderheaders(lHeader);

		Stateprovince s1 = new Stateprovince();
		s1.setName("Valle del Cauca");
		Stateprovince s2 = new Stateprovince();
		s2.setName("Cundinamarca");
		Stateprovince s3 = new Stateprovince();
		s3.setName("Boyaca");
		Stateprovince s4 = new Stateprovince();
		s4.setName("Atlantico");
		Stateprovince s5 = new Stateprovince();
		s5.setName("Antioquia");

		s1.setTerritoryid(t1.getTerritoryid());
		s2.setTerritoryid(t2.getTerritoryid());
		s3.setTerritoryid(t1.getTerritoryid());
		s4.setTerritoryid(t2.getTerritoryid());
		s5.setTerritoryid(t1.getTerritoryid());

		Salestaxrate tax1 =new Salestaxrate();
		tax1.setName("taxRate1");
		tax1.setTaxrate(0.1);
		tax1.setStateprovince(s5);
		Salestaxrate tax2 =new Salestaxrate();
		tax2.setName("taxRate2");
		tax2.setTaxrate(0.2);
		tax2.setStateprovince(s4);
		Salestaxrate tax3 =new Salestaxrate();
		tax3.setName("taxRate3");
		tax3.setTaxrate(0.3);
		tax3.setStateprovince(s3);
		Salestaxrate tax4 =new Salestaxrate();
		tax4.setName("taxRate4");
		tax4.setTaxrate(0.4);
		tax4.setStateprovince(s2);

		List<Salestaxrate> lstr1 = new ArrayList<Salestaxrate>();
		lstr1.add(tax1);
		List<Salestaxrate> lstr2 = new ArrayList<Salestaxrate>();
		lstr1.add(tax2);
		List<Salestaxrate> lstr3 = new ArrayList<Salestaxrate>();
		lstr1.add(tax3);
		List<Salestaxrate> lstr4 = new ArrayList<Salestaxrate>();
		lstr1.add(tax4);

		s5.setSalestaxrates(lstr1);
		s4.setSalestaxrates(lstr1);
		s3.setSalestaxrates(lstr3);
		s2.setSalestaxrates(lstr4);

		List<Address> la = new ArrayList<Address>();
		la.add(city);
		List<Address> la1 = new ArrayList<Address>();
		la1.add(city1);

		s1.setAddresses(la);
		s5.setAddresses(la1);

		List<Address> la2 = new ArrayList<Address>();
		la2.add(city2);
		la2.add(city3);
		la2.add(city4);
		List<Address> la3 = new ArrayList<Address>();
		la3.add(city5);
		la3.add(city6);
		la3.add(city7);
		la3.add(city8);
		List<Address> la4 = new ArrayList<Address>();
		la4.add(city9);
		la4.add(city10);

		s2.setAddresses(la2);
		s3.setAddresses(la3);
		s4.setAddresses(la4);

		Countryregion c1 = new Countryregion();
		c1.setCountryregioncode("COL");
		c1.setName("Colombia");
		cs.save(c1);

		Countryregion c2 = new Countryregion();
		c2.setCountryregioncode("CAN");
		c2.setName("Canada");
		cs.save(c2);

		Countryregion c3 = new Countryregion();
		c3.setCountryregioncode("ITA");
		c3.setName("Italia");
		cs.save(c3);

		s1.setCountryregion(c1);
		s2.setCountryregion(c2);
		s3.setCountryregion(c3);
		s4.setCountryregion(c1);
		s5.setCountryregion(c2);

		s1.setIsonlystateprovinceflag("Y");
		s2.setIsonlystateprovinceflag("Y");
		s3.setIsonlystateprovinceflag("Y");
		s4.setIsonlystateprovinceflag("N");
		s5.setIsonlystateprovinceflag("N");

		s1.setStateprovincecode("12345");
		s2.setStateprovincecode("23451");
		s3.setStateprovincecode("34512");
		s4.setStateprovincecode("45123");
		s5.setStateprovincecode("51234");

		ss.save(s1);
		ss.save(s2);
		ss.save(s3);
		ss.save(s4);
		ss.save(s5);

		ts.save(tax1);
		ts.save(tax2);
		ts.save(tax3);
		ts.save(tax4);

		city.setAddressline1("addrLine0");
		city1.setAddressline1("addrLine1");
		city2.setAddressline1("addrLine2");
		city3.setAddressline1("addrLine3");
		city4.setAddressline1("addrLine4");
		city5.setAddressline1("addrLine5");
		city6.setAddressline1("addrLine6");
		city7.setAddressline1("addrLine7");
		city8.setAddressline1("addrLine8");
		city9.setAddressline1("addrLine9");
		city10.setAddressline1("addrLine10");

		city.setCity("city0");
		city1.setCity("city1");
		city2.setCity("city2");
		city3.setCity("city3");
		city4.setCity("city4");
		city5.setCity("city5");
		city6.setCity("city6");
		city7.setCity("city7");
		city8.setCity("city8");
		city9.setCity("city9");
		city10.setCity("city10");

		city.setPostalcode("123456");
		city1.setPostalcode("123456");
		city2.setPostalcode("234561");
		city3.setPostalcode("234561");
		city4.setPostalcode("345612");
		city5.setPostalcode("345612");
		city6.setPostalcode("345612");
		city7.setPostalcode("456123");
		city8.setPostalcode("456123");
		city9.setPostalcode("456123");
		city10.setPostalcode("561234");

		city.setStateprovince(s1);
		city1.setStateprovince(s5);
		city2.setStateprovince(s2);
		city3.setStateprovince(s2);
		city4.setStateprovince(s2);
		city5.setStateprovince(s3);
		city6.setStateprovince(s3);
		city7.setStateprovince(s3);
		city8.setStateprovince(s3);
		city9.setStateprovince(s4);
		city10.setStateprovince(s4);

		as.save(city);
		as.save(city1);
		as.save(city2);
		as.save(city3);
		as.save(city4);
		as.save(city5);
		as.save(city6);
		as.save(city7);
		as.save(city8);
		as.save(city9);
		as.save(city10);

		// Empieza test query#2
		Stateprovince s = new Stateprovince();
		s.setName("Valle del Cauca");
		s.setIsonlystateprovinceflag("Y");
		s.setStateprovincecode("11223");
		s.setCountryregion(c3);
		s.setTerritoryid(t1.getTerritoryid());
		ss.save(s);
		
		Address a = new Address();
		a.setAddressline1("si sirve");
		a.setStateprovince(s);
		a.setCity("Montreal");
		a.setPostalcode("112233");
		as.save(a);

		List<Address> ls = new ArrayList<Address>();
		ls.add(a);
		s.setAddresses(ls);

		Salesterritory st = new Salesterritory();
		st.setTerritoryid(1);
		sts.save(st);


		s.setTerritoryid(st.getTerritoryid());
		ss.update(s);

		Salesorderheader h3 = new Salesorderheader();
		sos.save(h3);
		Salesorderheader h4 = new Salesorderheader();
		sos.save(h4);
		List<Salesorderheader> lh = new ArrayList<Salesorderheader>();
		lh.add(h3);
		lh.add(h4);

		h3.setSalesterritory(st);
		h4.setSalesterritory(st);

		sos.update(h3);
		sos.update(h4);
		st.setSalesorderheaders(lh);
		
		sts.update(st);
		
		
	}

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
