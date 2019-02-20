package com.yejinhui.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yejinhui.springcloud.entities.Dept;
import com.yejinhui.springcloud.service.DeptClientService;

/**
 * 
 * @author ye.jinhui
 * @date 2018年11月13日
 */
@RestController
public class DeptController_Consumer {

	@Autowired
	private DeptClientService deptClientService;

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return this.deptClientService.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return this.deptClientService.list();
	}

	@RequestMapping(value = "/consumer/dept/add")
	public Object add(Dept dept) {
		return this.deptClientService.add(dept);
	}

}
