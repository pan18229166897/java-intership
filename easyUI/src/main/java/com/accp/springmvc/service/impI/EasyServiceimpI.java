package com.accp.springmvc.service.impI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.springmvc.mapper.EasyMapper;
import com.accp.springmvc.pojo.Easy;
import com.accp.springmvc.service.EasyService;

@Service
public class EasyServiceimpI implements EasyService{

	@Autowired
	private EasyMapper easymapper;

	public List<Easy> selectAll() {
		List<Easy> elist = this.easymapper.selectAll();
		return elist;
	}

	public List<Easy> selectname(String name) {
		List<Easy> elist = this.easymapper.selectname(name);
		return elist;
	}

	@Transactional
	public void insert(Easy e) {
		this.easymapper.insert(e);
		
	}

	@Transactional
	public void update(Easy e) {
		this.easymapper.update(e);
		
	}

	@Transactional
	public void delete(String id) {
		this.easymapper.delete(id);
		
	}
	
}
