package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shenqing;

public interface ShenqingServer {

  public int add(Shenqing po);

  public int update(Shenqing po);
  
  
  
  public int delete(int id);

  public List<Shenqing> getAll(Map<String, Object> map);
  public List<Shenqing> getsyshenqing1(Map<String, Object> map);
  public List<Shenqing> getsyshenqing2(Map<String, Object> map);
  public List<Shenqing> getsyshenqing3(Map<String, Object> map);
  public Shenqing quchongShenqing(Map<String, Object> acount);

  public Shenqing getById(int id);

  public List<Shenqing> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Shenqing> select(Map<String, Object> map);
}
//	所有List
