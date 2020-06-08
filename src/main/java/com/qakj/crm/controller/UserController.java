package com.qakj.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qakj.crm.pojo.Customers;
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
    
    @RequestMapping("/findAll")
    public Object findAll(){
    	List<User> findAll = userService.findAll();
    	if(findAll != null && findAll.size()>0){
    		 return findAll;
    	}
		 return null;
    }
    @RequestMapping("/delete")
    public Object delete(@RequestParam("id") int id){
    	int deleteById = userService.deleteById(id);
    	if(deleteById != 0 && deleteById > 0){
   		 return deleteById;
   	}
    	return null;
    }
    
    @RequestMapping("/addUser")
    public Object addUser(User user){
    	Map<String,Object> map=new HashMap<String,Object>();
    	int addUser = userService.addUser(user);
        if(addUser != 0 && addUser > 0){
        	map.put("list", addUser);
        	map.put("code", "200");
          	return map;
        }
    	map.put("msg", "添加失败");
		map.put("code", "400");
       	return map;
    }
    
    //查询所有 ，分页，模糊查询
    @RequestMapping("/queryAllCustomer")
  public Map<String,Object> queryAllCustomer(@RequestParam("currectPage") Integer currectPage,
		      @RequestParam("sizePage") Integer sizePage){
   	 Map<String,Object> map=new HashMap<String,Object>();
   	  int co = userService.countAllByLike();
   	  int count=(co%sizePage)==0?(co/sizePage):(co/sizePage)+1;
	     List<User> list = userService.querAllUser(currectPage, sizePage);
	      map.put("user", list);
	      map.put("count", count);
	   return map;
  }
    
    //修改
    @RequestMapping("/findOne")
    public Object findOne(@RequestParam("id")Integer id){
    	 Map<String,Object> map=new HashMap<String,Object>();
    	 User user = userService.findOne(id);
    	 if(user != null){
    		  map.put("user", user);
    	      map.put("code", "200");
    		 return map;
    	 }
    	  map.put("code", "400");
 		 return map;
    }
    @RequestMapping("/update")
    public Object update(User user){
    	 Map<String,Object> map=new HashMap<String,Object>();
    	if(user != null){
    		int update = userService.update(user);
    		map.put("update", update);
   	      	map.put("code", "200");
   	      	return map;
    	}
    	map.put("code", "400");
	    return map;
    }
    
}
