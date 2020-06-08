package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Linkman;

public interface LinkmanService {
   //查询所有
	List<Linkman> getLinkmans();
	//根据用户ID查询
	List<Linkman> getLinkmanById(int id);
}
