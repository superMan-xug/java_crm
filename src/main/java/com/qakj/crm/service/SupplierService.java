package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.Supplier;

public interface SupplierService {

	//分页查询供应商
	List<Supplier> selectByLimit(int currentPage,int pageSize);
	//获取总个数
	int getCount();
	//添加新的供应商
	int addSupplier (Supplier s);
	
	//通过id查询一个
	Supplier findOne(int id);
	
	//修改供应商信息
	int updateSupplier(Supplier s);
	
	//通过id删除一条
	int deleteSupplier(int id);
	
}
