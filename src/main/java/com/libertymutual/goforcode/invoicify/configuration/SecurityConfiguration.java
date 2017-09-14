package com.libertymutual.goforcode.invoicify.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.libertymutual.goforcode.invoicify.services.InvoicifyUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private InvoicifyUserDetailsService userDetailsService;
	
	public SecurityConfiguration(InvoicifyUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/css/**", "/js/**", "/signup").permitAll()	
				.antMatchers("/invoices/**").hasAnyRole("ACCOUNTANT", "ADMIN")
				.antMatchers("/billing-records/**").hasAnyRole("CLERK", "ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and()
			.formLogin();	
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public UserDetailsService userDetailsService() {
		return userDetailsService;
	}
	

}
