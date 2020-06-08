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
    public Map<String,Object> getLinkmans(){
    	  List<Linkman> list = linkmanService.getLinkmans(); 
    	  Map<String,Object> map=new HashMap<String, Object>();
    	  map.put("linkmans", list);
    	return map;
    }
    @RequestMapping("/getlinkmansById")
    public Map<String,Object> getLinkmansById(@RequestParam("id") int id){
    	    List<Linkman> list = linkmanService.getLinkmanById(id);
    	  Map<String,Object> map=new HashMap<String, Object>();
    	  map.put("IDlinkman", list);
    	return map;
    }
}
