package com.accp.springmvc.service;

import java.util.List;

import com.accp.springmvc.pojo.Easy;

public interface EasyService {
	List<Easy> selectAll();
	List<Easy> selectname(String name);
	void insert(Easy e);
	void update(Easy e);
	void delete(String id);
}
