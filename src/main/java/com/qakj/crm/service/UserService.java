package com.qakj.crm.service;

import com.qakj.crm.pojo.User;

public interface UserService {
  //登录
	 User getUserByUsernameAndPassword(String username ,String password);
	 //根据ID修改密码
	 void updatePassword(Integer id,String password);
}
