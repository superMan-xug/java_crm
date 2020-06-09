package com.qakj.crm.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.qakj.crm.service.SupplierService;

public class SupplierTest {
	@Autowired
	private SupplierService service;
	
	@Test
	public void test(){
		int count = service.getCount();
		System.out.println(count);
	}
}
