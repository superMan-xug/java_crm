package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Customers;
import com.qakj.crm.service.CustomerService;
@RequestMapping("customerController")
@RestController
public class CustomerController {
   @Autowired
	private CustomerService customerService;
   
   //查询所有 ，分页，模糊查询
     @RequestMapping("/queryAll")
   public Map<String,Object> queryAllCustomer(@RequestParam("currectPage") Integer currectPage,
		      @RequestParam("sizePage") Integer sizePage,@RequestParam("name") String name ){
    	 Map<String,Object> map=new HashMap<String,Object>();
    	  if(name==null || "".equals(name)){
    		  name="%%";
    	  }else{
    		  name="%"+name+"%";
    	  }
    	  int co = customerService.selectAllByLike(name);
    	  int count=(co%sizePage)==0?(co/sizePage):(co/sizePage)+1;
	     List<Customers> list = customerService.querAllCustomer(currectPage, sizePage, name);
	      map.put("customer", list);
	      map.put("count", count);
	   return map;
   }
     
     @RequestMapping("/deleteById")
     public Map<String,Object> deleteById(@RequestParam("id") int id){
    	 Map<String,Object> map=new HashMap<String,Object>();
    	   customerService.deleteById(id);
           map.put("yes", "删除成功");
    	 return map;
     }
     
     @RequestMapping("/addCustomer")
     public Object addCustomer(Customers c){
    	 int i = customerService.addCustomer(c);
    	 Map<String,Object> map=new HashMap<String,Object>();
    	 if(i>0){
    		 map.put("code","200");
    		 return map;
    	 }else{
    		 map.put("code", "400");
    		 return map;
    	 }
    	 
     }
      
     @RequestMapping("/findOne")
     public Map<String,Object> fingOne(@RequestParam("id") int id){
    	  Map<String,Object> map=new HashMap<String,Object>();
    	  Customers customer = customerService.fingOne(id);
    	  map.put("customer", customer);
    	  return map;
     }
     
     @RequestMapping("/updateCustomer")
     public Map<String,Object> updateCustomer(Customers customer){
    	  Map<String,Object> map=new HashMap<String,Object>();
    	   int i = customerService.updateCustomer(customer);
    	   if(i>=0){
    		   map.put("core", "200");
    		   
    	   }
    	  return map;
     }
}
