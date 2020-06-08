package com.qakj.crm.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qakj.crm.mapper.CustomersMapper;
import com.qakj.crm.pojo.Customers;
import com.qakj.crm.service.CustomerService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
     @Autowired
	private CustomerService cs;
	
	@Test
	public void queryCustomer(){
		 List<Customers> list = cs.querAllCustomer(0, 10, "%%");
		 for (Customers customers : list) {
			 System.out.println(customers);
		}
		
	}
	
	@Test
	public void queryCustomer1(){
		Date d=new Date();
		 Customers c=new Customers("12", 1, 1, "123", "",d, 1);
		 cs.addCustomer(c);
		
	}
}
