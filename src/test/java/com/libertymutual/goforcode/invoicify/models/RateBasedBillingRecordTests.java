package com.libertymutual.goforcode.invoicify.models;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;

public class RateBasedBillingRecordTests {

	
	@Test
    public void checking_to_make_sure_my_getters_and_setters_work() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
                .ignoreProperty("createdOn")
                .build();
        tester.testBean(RateBasedBillingRecord.class, configuration);
	}
	
	@Test
	public void test_getTotal_method() {
		RateBasedBillingRecord record = new RateBasedBillingRecord();
		record.setRate(1);
		record.setQuantity(2);
		
		Double result = record.getTotal();
		
		assertThat(result).isEqualTo(2);
	}

}
