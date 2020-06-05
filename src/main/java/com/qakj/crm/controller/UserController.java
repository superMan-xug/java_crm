package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.User;
import com.qakj.crm.service.UserService;
@RequestMapping("userController")
@RestController
public class UserController {
    @Autowired
	private UserService userService;
	  
    @RequestMapping("/login")
    public Map<String,Object> userLogin(@RequestParam("username") String username,
    		                           @RequestParam("password") String password,
    		                            HttpSession session){
    	User user = userService.getUserByUsernameAndPassword(username, password);
    	Map<String,Object> map=new HashMap<String, Object>();
    	if(user!=null){
    		session.setAttribute("user", user);
    		map.put("core", "200");
    		map.put("msg", "登陆成功");
    		return map;
    	}
    	 map.put("core", 400);
    	 map.put("msg", "账号或密码错误");
    	return map;
    }
    
    @RequestMapping("/getuser")
    public Map<String,Object> getUser(HttpSession session){
    	Map<String,Object> map=new HashMap<String, Object>();
    	Object user = session.getAttribute("user");
    	if(user !=null){
    		map.put("core", "200");
    		map.put("user", user);
    		return map;
    	}
    	map.put("core", "400");
    	return map;
    }
    @RequestMapping("/oversession")
    public Map<String,Object> oversession(HttpSession session){
    	Map<String,Object> map=new HashMap<String,Object>();
    	  session.invalidate();
    	  map.put("core", "100");
    	return map;
    }
      
    @RequestMapping("/updatepwd")
    public Map<String,Object> updatePassword(@RequestParam("id") Integer id,@RequestParam("password") String password){
    	  Map<String,Object> map=new HashMap<String,Object>();
    	   userService.updatePassword(id, password);
    	   map.put("core", "200");
    	return map;
    }
}
