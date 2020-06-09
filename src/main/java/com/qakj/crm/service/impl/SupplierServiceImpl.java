package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.SupplierMapper;
import com.qakj.crm.pojo.Supplier;
import com.qakj.crm.service.SupplierService;
@Transactional
@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierMapper mapper;
	
	@Override
	public List<Supplier> selectByLimit(int currentPage, int pageSize) {
		List<Supplier> list = mapper.selectByLimit((currentPage-1)*pageSize, pageSize);
		return list;
	}

	@Override
	public int getCount() {
		int i = mapper.countByExample(null);
		return i;
	}

	@Override
	public int addSupplier(Supplier s) {
		int i = mapper.insertSelective(s);
		return i;
	}

	@Override
	public Supplier findOne(int id) {
		Supplier supplier = mapper.selectByPrimaryKey(id);
		return supplier;
	}

	@Override
	public int updateSupplier(Supplier s) {
		int i = mapper.updateByPrimaryKey(s);
		return i;
	}

	@Override
	public int deleteSupplier(int id) {
		int i = mapper.deleteByPrimaryKey(id);
		return i;
	}

	

	
}
