package com.accp.springmvc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.springmvc.pojo.Easy;
import com.accp.springmvc.service.EasyService;

@RestController
@RequestMapping("/easy")
public class EasyRestController {

	@Autowired
	private EasyService easyservice;
	
	@RequestMapping("/home")
	public Object selectAll(String name){
		List<Easy> elist = null;
		if(name==null){
			elist=this.easyservice.selectAll();
		}else{
			elist=this.easyservice.selectname(name);
		}
		return elist;
	}
	
	@RequestMapping("insert")
	public void insert(@RequestBody Easy e){
		this.easyservice.insert(e);
	}
	
	@RequestMapping("update")
	public void update(@RequestBody Easy e){
		this.easyservice.update(e);
	}
	
	@RequestMapping("delete")
	public void delete(String id){
		System.out.println(id);
		this.easyservice.delete(id);
	}
}
