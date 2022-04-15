package com.sebas.taller.security;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//@Autowired
	//private LoggingAccessDeniedHandler access;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	}
}
