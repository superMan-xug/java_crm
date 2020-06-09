package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Product;

public interface ProductService {
	
	//分页查询数据
	List<Product> selectByLimit(int currentPage,int pageSize);
	
	//查询总记录数
	int getCount();
}
