package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Product;
import com.qakj.crm.service.ProductService;

@RequestMapping("/productController")
@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	public Object getProduct(@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize){
		List<Product> list = service.selectByLimit(currentPage, pageSize);
		int count = service.getCount();
		int countPage = count % pageSize == 0?count/pageSize:(count/pageSize)+1;
		Map<String, Object> map = new HashMap<String, Object>();
		if(list != null){
			map.put("code", "200");
			map.put("data", list);
			map.put("countPage", countPage);
		}
		map.put("msg", "出错误了");
		return map;
		
	}
}
