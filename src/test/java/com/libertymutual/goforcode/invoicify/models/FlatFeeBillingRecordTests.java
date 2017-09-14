package com.libertymutual.goforcode.invoicify.models;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;


public class FlatFeeBillingRecordTests {

	@Test
    public void checking_to_make_sure_my_getters_and_setters_work() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
                .ignoreProperty("createdOn")
                .build();
        tester.testBean(FlatFeeBillingRecord.class, configuration);
	}
	
	@Test
	public void test_getAmount_method() {
		FlatFeeBillingRecord record = new FlatFeeBillingRecord();
		record.setAmount(1L);
		
		Double result = record.getTotal();
		
		assertThat(result).isEqualTo(1L);
	}

}
