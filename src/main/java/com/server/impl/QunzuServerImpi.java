package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.QunzuMapper;
import com.entity.Qunzu;
import com.server.QunzuServer;
@Service
public class QunzuServerImpi implements QunzuServer {
   @Resource
   private QunzuMapper gdao;
	@Override
	public int add(Qunzu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Qunzu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Qunzu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Qunzu> getsyqunzu1(Map<String, Object> map) {
		return gdao.getsyqunzu1(map);
	}
	public List<Qunzu> getsyqunzu2(Map<String, Object> map) {
		return gdao.getsyqunzu2(map);
	}
	public List<Qunzu> getsyqunzu3(Map<String, Object> map) {
		return gdao.getsyqunzu3(map);
	}
	
	@Override
	public Qunzu quchongQunzu(Map<String, Object> account) {
		return gdao.quchongQunzu(account);
	}

	@Override
	public List<Qunzu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Qunzu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Qunzu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

