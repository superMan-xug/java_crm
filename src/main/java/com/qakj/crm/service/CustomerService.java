package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Customers;

public interface CustomerService {
   //查询所有用户信息
	 List<Customers> querAllCustomer(Integer currectPage,Integer sizePage,String name);
	 //模糊查询所有
	 int selectAllByLike(String name);
	 //根据ID删除用户
	 void deleteById(int id);
}
