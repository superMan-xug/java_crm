package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Supplier;
import com.qakj.crm.service.SupplierService;
@RequestMapping("/supplierController")
@RestController
public class SupplierController {

	@Autowired
	private SupplierService service;
	
	@RequestMapping("/getSupplier")
	public Object getSupplier(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize){
		List<Supplier> list = service.selectByLimit(currentPage, pageSize);
		int count = service.getCount();
		int countPage = count % pageSize == 0?count/pageSize : (count/pageSize)+1;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("data", list);
		map.put("countPage",countPage);
		return map;
	}
	
	
	//添加新的供应商
	@RequestMapping("/addSupplier")
	public Object addSupplier(Supplier s){
		int i = service.addSupplier(s);
		Map<String, Object> map = new HashMap<String,Object>();
		if(i>0){
			map.put("code", "200");
			return map;
		}
		map.put("msg", "出错误了");
		return map;
	}
	
	//通过id查询一个
	@RequestMapping("/findOne")
	public Object findOne(@RequestParam("supplierId") int id){
		Supplier supplier = service.findOne(id);
		Map<String, Object> map = new HashMap<String,Object>();
		if(supplier != null){
			map.put("code", "200");
			map.put("data", supplier);
			return map;
		}
		map.put("msg", "出错误了");
		return map;
	}
	
	
	@RequestMapping("/updateSupplier")
	public Object updateSupplier(Supplier s){
		int i = service.updateSupplier(s);
		Map<String, Object> map = new HashMap<String,Object>();
		if(i>0){
			map.put("code", "200");
			return map;
		}
		map.put("msg", "出错误了");
		return map;
	}
	
	@RequestMapping("/deleteSupplier")
	public Object deleteSupplier(@RequestParam("supplierId") int id){
		int i = service.deleteSupplier(id);
		Map<String, Object> map = new HashMap<String,Object>();
		if(i>0){
			map.put("code", "200");
			return map;
		}
		map.put("msg", "删除失败，联系管理员");
		return map;
	}
	
	
	
}
