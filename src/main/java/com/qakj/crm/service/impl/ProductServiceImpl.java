package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.ProductMapper;
import com.qakj.crm.pojo.Product;
import com.qakj.crm.service.ProductService;


@Transactional
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper mapper;

	@Override
	public List<Product> selectByLimit(int currentPage, int pageSize) {
		List<Product> list = mapper.selectByLimit((currentPage-1)*pageSize, pageSize);
		return list;
	}

	@Override
	public int getCount() {
		int i = mapper.countByExample(null);
		return i;
	}

}
