package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class UserTests {
	
	User user;
	List<UserRole> roles;
 	
	@Before
	public void setUp() {
		user = new User();
		roles = new ArrayList<UserRole>();
	} 
	
	@Test
	public void test_user_constructor() {
		User user = new User("test", "password", "ADMIN");
		roles.add(new UserRole("ADMIN", user));
		
		User result = new User("test", "password", "ADMIN");
		
		assertThat(result.getUsername()).isEqualTo("test");
		assertThat(result.getPassword()).isEqualTo("password");
		assertThat(roles).isNotNull();
		
	}

	@Test
    public void checking_to_make_sure_my_getters_and_setters_work() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
                .ignoreProperty("createdOn")
                .build();
        tester.testBean(User.class, configuration);
	}
	
	@Test
	public void test_isAccountNonExpired_returning_true() {
		
		Boolean result = user.isAccountNonExpired();
		
		assertThat(result).isEqualTo(true);
	}
	
	@Test
	public void test_isAccountNonLocked_returning_true() {
		
		Boolean result = user.isAccountNonLocked();
		
		assertThat(result).isEqualTo(true);
	}
	
	@Test
	public void test_isCredentialsNonExpired_returning_true() {
		
		Boolean result = user.isCredentialsNonExpired();
		
		assertThat(result).isEqualTo(true);
	}
	
	@Test
	public void test_isEnabled_returning_true() {
		
		Boolean result = user.isEnabled();
		
		assertThat(result).isEqualTo(true);
	}

}
