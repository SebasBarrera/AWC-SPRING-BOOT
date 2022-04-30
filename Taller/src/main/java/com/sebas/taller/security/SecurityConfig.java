package com.sebas.taller.security;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private LoggingAccessDeniedHandler access;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/address/**").access("hasRole('administrator')").and().
		authorizeRequests().antMatchers("/countryregion/**").access("hasRole('administrator')").and().
		authorizeRequests().antMatchers("/salestaxrate/**").access("hasRole('operator')").and().
		authorizeRequests().antMatchers("/stateprovince/**").access("hasRole('operator')").
		anyRequest().permitAll().and().
		formLogin().loginPage("/login").permitAll().and().
		logout().invalidateHttpSession(true).clearAuthentication(true).
		logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll().and().
		exceptionHandling().accessDeniedHandler(access);
	
	}
}
