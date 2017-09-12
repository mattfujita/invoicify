package com.libertymutual.goforcode.invoicify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class BillingRecordController {
	
	@GetMapping("/billing-records")
	public String billingRecords() {
		return "billing-records/list";
	}

}
