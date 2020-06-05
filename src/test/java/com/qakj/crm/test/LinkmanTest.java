package com.qakj.crm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qakj.crm.pojo.Linkman;
import com.qakj.crm.service.LinkmanService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkmanTest {
      @Autowired
	private LinkmanService ls;
	
	@Test
	public void getLikemans(){
		 List<Linkman> linkmans = ls.getLinkmans();
		 for (Linkman linkman : linkmans) {
			 System.out.println(linkman);
		}
	}
}
