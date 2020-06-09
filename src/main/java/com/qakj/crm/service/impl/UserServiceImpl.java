package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.UserMapper;
import com.qakj.crm.pojo.Customers;
import com.qakj.crm.pojo.CustomersExample;
import com.qakj.crm.pojo.User;
import com.qakj.crm.pojo.UserExample;
import com.qakj.crm.pojo.UserExample.Criteria;
import com.qakj.crm.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
	 private UserMapper usermapper;
	 
	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		UserExample example=new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> list = usermapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void updatePassword(Integer id, String password) {
             User user=new User();
             user.setId(id);
             user.setPassword(password);
             usermapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> findAll() {
		List<User> list = usermapper.selectByExample(null);
		return list;
	}

	@Override
	public int deleteById(int id) {
		int key = usermapper.deleteByPrimaryKey(id);
		return key;
	}

	@Override
	public int addUser(User user) {
		int selective = usermapper.insertSelective(user);
		return selective;
	}

	


	@Override
	public int countAllByLike() {
		UserExample example = new UserExample();
		int count = usermapper.countByExample(example);
		return count;
	}

	@Override
	public List<User> querAllUser(Integer currectPage, Integer sizePage) {
		List<User> list = usermapper.queryAllUserByLimitAndLike((currectPage - 1) * sizePage, sizePage);
		return list;
	}

	@Override
	public User findOne(Integer id) {
		User user = usermapper.selectByPrimaryKey(id);
		return user;
	}
	
	@Override
	public int update(User user) {
		return usermapper.updateByPrimaryKeySelective(user);
	}
	



	


}
