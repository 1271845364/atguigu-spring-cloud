package com.yejinhui.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yejinhui.springcloud.entities.Dept;

/**
 * @author ye.jinhui
 * @date 2018年11月12日
 */
//@Mapper
public interface DeptDao {
	
	boolean addDept(Dept dept);

	Dept findById(Long id);

	List<Dept> findAll();
}
