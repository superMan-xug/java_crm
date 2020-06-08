package com.qakj.crm.service;

import java.util.List;

import com.qakj.crm.pojo.User;

public interface UserService {
  //登录
	 User getUserByUsernameAndPassword(String username ,String password);
	 //根据ID修改密码
	 void updatePassword(Integer id,String password);
	 //管理员操作
	 List<User> findAll();
	 //管理员删除用户
	 int deleteById(int id);
	 //管理员添加用户
	 int addUser(User user);
	 //回显
	 User findOne(Integer id);
	 //管理员修改
	 int update(User user);
	//查询所有用户信息
	 List<User> querAllUser(Integer currectPage,Integer sizePage);
	 //模糊查询所有
	 int countAllByLike();
	 
}
