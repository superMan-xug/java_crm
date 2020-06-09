package com.qakj.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qakj.crm.mapper.LinkmanMapper;
import com.qakj.crm.pojo.Linkman;
import com.qakj.crm.pojo.LinkmanExample;
import com.qakj.crm.pojo.LinkmanExample.Criteria;
import com.qakj.crm.service.LinkmanService;
@Transactional
@Service
public class LinkmanServiceImpl implements LinkmanService {
     @Autowired
	private LinkmanMapper linkmanMapper;
	
	@Override
	public List<Linkman> getLinkmans(int currentPage,int pageSize) {
		   List<Linkman> list = linkmanMapper.getLinkmans((currentPage-1)*pageSize,pageSize);
		return list;
	}

	@Override
	public List<Linkman> getLinkmanById(int id,int currentPage,int pageSize) {
		List<Linkman> list = linkmanMapper.getLinkmanById(id,(currentPage-1)*pageSize,pageSize);
		return list;
	}

	@Override
	public void addLinkman(Linkman linkman) {
		  linkmanMapper.insert(linkman);
		
	}

	@Override
	public void deleteLinkman(int id) {
		linkmanMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public Linkman findOne(int id) {
		Linkman linkman = linkmanMapper.selectByPrimaryKey(id);
		return linkman;
	}

	@Override
	public int updateLinkman(Linkman linkman) {
		 int i = linkmanMapper.updateByPrimaryKeySelective(linkman);
		return i;
	}

	@Override
	public int selectCont() {
		int i = linkmanMapper.countByExample(null);
		return i;
	}

	@Override
	public int selectCountById(int id) {
		   LinkmanExample example=new LinkmanExample();
		   Criteria criteria = example.createCriteria();
		   criteria.andUserIdEqualTo(id);
		   int i = linkmanMapper.countByExample(example);
		return i;
	}

}
