package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Linkman;
import com.qakj.crm.service.LinkmanService;
@RequestMapping("linkmanController")
@RestController
public class LinkmanController {
    @Autowired
	private LinkmanService linkmanService;
     
    @RequestMapping("/getlinkmans")
    public Map<String,Object> getLinkmans(@RequestParam("currentPage") int currentPage,
    		                              @RequestParam("pageSize") int pageSize
    		
    		){
    	  List<Linkman> list = linkmanService.getLinkmans(currentPage,pageSize); 
    	   int count = linkmanService.selectCont();
    	  int countPage=count%pageSize==0?(count/pageSize):(count/pageSize)+1;
    	  Map<String,Object> map=new HashMap<String, Object>();
    	  map.put("linkmans", list);
    	  map.put("countpage",countPage);
    	return map;
    }
    @RequestMapping("/getlinkmansById")
    public Map<String,Object> getLinkmansById(@RequestParam("id") int id,
    		                         @RequestParam("currentPage") int currentPage,
                                         @RequestParam("pageSize") int pageSize
    		){
    	    List<Linkman> list = linkmanService.getLinkmanById(id,currentPage,pageSize);
    	     int count = linkmanService.selectCountById(id);
    	    int countPage=count%pageSize==0?(count/pageSize):(count/pageSize)+1;
    	  Map<String,Object> map=new HashMap<String, Object>();
    	  map.put("IDlinkman", list);
    	  map.put("countpage", countPage);
    	return map;
    }
    @RequestMapping("/addlinkman")
    public Map<String,Object> addlinkman(Linkman linkman){
    	System.out.println(linkman);
    	     linkmanService.addLinkman(linkman);
    	  Map<String,Object> map=new HashMap<String, Object>();
    	  map.put("yes", "添加成功");
    	return map;
    }
    
    @RequestMapping("/deletelinkman")
    public Map<String,Object> deletelinkman(@RequestParam("id") int id){
    	  linkmanService.deleteLinkman(id);
    	  Map<String,Object> map=new HashMap<String, Object>();
    	  map.put("yes", "删除成功");
    	return map;
    }
    
    @RequestMapping("/enidlinkman")
    public Map<String,Object> findOneLinkman(@RequestParam("id") int id){
    	  Linkman linkman = linkmanService.findOne(id);
    	  Map<String,Object> map=new HashMap<String, Object>();
    	  map.put("linkman", linkman);
    	  map.put("code", "200");
    	return map;
    }
    
    @RequestMapping("/updatelinkman")
    public Map<String,Object> updateLinkman(Linkman linkman){
    	  int i = linkmanService.updateLinkman(linkman);
    	  Map<String,Object> map=new HashMap<String, Object>();
    	  
    	  map.put("code", i);
    	return map;
    }
}
