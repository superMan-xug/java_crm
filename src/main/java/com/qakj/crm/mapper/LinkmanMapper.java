package com.qakj.crm.mapper;

import com.qakj.crm.pojo.Linkman;
import com.qakj.crm.pojo.LinkmanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinkmanMapper {
	 List<Linkman> getLinkmanById(@Param("id") int id,@Param("static") int currentPage,@Param("stop") int pageSize);
	
	 List<Linkman> getLinkmans(@Param("static") int currentPage,@Param("stop") int pageSize);
	
    int countByExample(LinkmanExample example);

    int deleteByExample(LinkmanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Linkman record);

    int insertSelective(Linkman record);

    List<Linkman> selectByExample(LinkmanExample example);

    Linkman selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByExample(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByPrimaryKeySelective(Linkman record);

    int updateByPrimaryKey(Linkman record);
}