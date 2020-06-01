package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shenqing;

public interface ShenqingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shenqing record);

    int insertSelective(Shenqing record);

    Shenqing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shenqing record);
	
    int updateByPrimaryKey(Shenqing record);
	public Shenqing quchongShenqing(Map<String, Object> bianhao);
	public List<Shenqing> getAll(Map<String, Object> map);
	public List<Shenqing> getsyshenqing1(Map<String, Object> map);
	public List<Shenqing> getsyshenqing3(Map<String, Object> map);
	public List<Shenqing> getsyshenqing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shenqing> getByPage(Map<String, Object> map);
	public List<Shenqing> select(Map<String, Object> map);
//	所有List
}

