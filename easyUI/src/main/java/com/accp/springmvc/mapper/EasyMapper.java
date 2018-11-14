package com.accp.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.accp.springmvc.pojo.Easy;

public interface EasyMapper {
	
	@Select("select * from easy")
	List<Easy> selectAll();
	
	@Select("select * from easy where name = #{name}")
	List<Easy> selectname(@Param("name")String name);
	
	@Insert("INSERT INTO easy ( `name`,`password`,`address`,`birthday`) VALUES(#{name},#{password},#{address},#{birthday})")
	void insert(Easy e);
	
	@Update("UPDATE `easy` SET `name` = #{name},`password` = #{password},`address` = #{address},`birthday` = #{birthday} WHERE `id` = #{id} ;")
	void update(Easy e);
	
	@Delete("DELETE FROM `easy` WHERE `id` = #{id} ;")
	void delete(@Param("id")String id);
}
