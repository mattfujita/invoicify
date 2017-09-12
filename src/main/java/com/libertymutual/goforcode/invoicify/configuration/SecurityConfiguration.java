package com.libertymutual.goforcode.invoicify.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfiguration {
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/css/**", "/js/**", "/login").permitAll()	
				.antMatchers("/invoices/**").hasAnyRole("ACCOUNTANT", "ADMIN")
				.antMatchers("/billing-records/**").hasAnyRole("CLERK", "ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login");
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		UserDetails user = User
				.withUsername("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		manager.createUser(user);
		
		user = User
				.withUsername("clerk")
				.password("clerk")
				.roles("CLERK")
				.build();
		manager.createUser(user);
		
		user = User
				.withUsername("accountant")
				.password("accountant")
				.roles("ACCOUNTANT")
				.build();
		manager.createUser(user);
			
		return manager;
	}
	

}