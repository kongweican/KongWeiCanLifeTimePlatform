package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Qunzu;

public interface QunzuServer {

  public int add(Qunzu po);

  public int update(Qunzu po);
  
  
  
  public int delete(int id);

  public List<Qunzu> getAll(Map<String, Object> map);
  public List<Qunzu> getsyqunzu1(Map<String, Object> map);
  public List<Qunzu> getsyqunzu2(Map<String, Object> map);
  public List<Qunzu> getsyqunzu3(Map<String, Object> map);
  public Qunzu quchongQunzu(Map<String, Object> acount);

  public Qunzu getById(int id);

  public List<Qunzu> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Qunzu> select(Map<String, Object> map);
}
//	所有List
