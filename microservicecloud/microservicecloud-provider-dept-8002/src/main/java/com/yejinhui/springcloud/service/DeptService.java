package com.yejinhui.springcloud.service;

import java.util.List;

import com.yejinhui.springcloud.entities.Dept;

/**
 * @author ye.jinhui
 * @date 2018年11月12日
 */
public interface DeptService {
	
	boolean add(Dept dept);

	Dept get(Long id);

	List<Dept> list();
}
