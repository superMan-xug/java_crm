package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Linkman;

public interface LinkmanService {
   //查询所有
	List<Linkman> getLinkmans(int currentPage,int pageSize);
	//根据用户ID查询
	List<Linkman> getLinkmanById(int id,int currentPage,int pageSize);
	//添加联系人信息
	void addLinkman(Linkman linkman);
	//删除联系人信息
	void deleteLinkman(int id);
	//根据查询所有信息
	Linkman findOne(int id);
	//修改客户信息
	int updateLinkman(Linkman linkman);
	//查询总个数
	int selectCont();
    //根据ID查询总个数
	int selectCountById(int id);
}
