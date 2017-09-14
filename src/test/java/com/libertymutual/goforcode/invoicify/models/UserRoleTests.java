package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class UserRoleTests {
	
	User user;
	
	@Test
	public void test_userRole_constructor() {
		user = new User();
		
		UserRole role = new UserRole("ADMIN", user);
		
		assertThat(role.getName()).isEqualTo("ADMIN");
		assertThat(role.getUser()).isSameAs(user);
	}

	@Test
    public void checking_to_make_sure_my_getters_and_setters_work() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
                .ignoreProperty("createdOn")
                .build();
        tester.testBean(UserRole.class, configuration);
	}
	

}
