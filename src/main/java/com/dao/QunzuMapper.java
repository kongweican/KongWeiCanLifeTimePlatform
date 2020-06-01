package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Qunzu;

public interface QunzuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qunzu record);

    int insertSelective(Qunzu record);

    Qunzu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qunzu record);
	
    int updateByPrimaryKey(Qunzu record);
	public Qunzu quchongQunzu(Map<String, Object> chuangshiren);
	public List<Qunzu> getAll(Map<String, Object> map);
	public List<Qunzu> getsyqunzu1(Map<String, Object> map);
	public List<Qunzu> getsyqunzu3(Map<String, Object> map);
	public List<Qunzu> getsyqunzu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Qunzu> getByPage(Map<String, Object> map);
	public List<Qunzu> select(Map<String, Object> map);
//	所有List
}

