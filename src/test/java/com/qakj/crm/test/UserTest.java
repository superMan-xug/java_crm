package com.qakj.crm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qakj.crm.pojo.User;
import com.qakj.crm.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	@Autowired
	private UserService us;
	
       @Test
	public void loginTest(){
		User user = us.getUserByUsernameAndPassword("tom", "123456");
		System.out.println(user);
	}
}
