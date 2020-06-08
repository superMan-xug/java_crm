package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.CustomersMapper;
import com.qakj.crm.pojo.Customers;
import com.qakj.crm.pojo.CustomersExample;
import com.qakj.crm.pojo.CustomersExample.Criteria;
import com.qakj.crm.service.CustomerService;
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
     @Autowired
	private CustomersMapper customerMapper;


	@Override
	public List<Customers> querAllCustomer(Integer currectPage, Integer sizePage, String name) {
           List<Customers> list = customerMapper.queryAllCustomerByLimitAndLike((currectPage-1)*sizePage, sizePage, name);
		return list;
	}


	@Override
	public int selectAllByLike(String name) {
		  CustomersExample example=new CustomersExample();
		  Criteria criteria = example.createCriteria();
		   criteria.andNameLike(name);
		   int count = customerMapper.countByExample(example);
		return count;
	}


	@Override
	public void deleteById(int id) {
         customerMapper.deleteByPrimaryKey(id);		
	}


	@Override
	public int addCustomer(Customers c) {
		int i = customerMapper.insertSelective(c);
		return i;
	}


	@Override
	public Customers fingOne(int id) {
		Customers customer = customerMapper.selectByPrimaryKey(id);
		return customer;
	}

	@Override
	public int updateCustomer(Customers customer) {
		int i = customerMapper.updateByPrimaryKeySelective(customer);
		return i;
	}
}