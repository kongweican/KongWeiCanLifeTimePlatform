package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShenqingMapper;
import com.entity.Shenqing;
import com.server.ShenqingServer;
@Service
public class ShenqingServerImpi implements ShenqingServer {
   @Resource
   private ShenqingMapper gdao;
	@Override
	public int add(Shenqing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shenqing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shenqing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shenqing> getsyshenqing1(Map<String, Object> map) {
		return gdao.getsyshenqing1(map);
	}
	public List<Shenqing> getsyshenqing2(Map<String, Object> map) {
		return gdao.getsyshenqing2(map);
	}
	public List<Shenqing> getsyshenqing3(Map<String, Object> map) {
		return gdao.getsyshenqing3(map);
	}
	
	@Override
	public Shenqing quchongShenqing(Map<String, Object> account) {
		return gdao.quchongShenqing(account);
	}

	@Override
	public List<Shenqing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shenqing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shenqing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

