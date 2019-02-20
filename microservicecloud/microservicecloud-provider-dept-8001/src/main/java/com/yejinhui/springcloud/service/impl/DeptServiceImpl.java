package com.yejinhui.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yejinhui.springcloud.dao.DeptDao;
import com.yejinhui.springcloud.entities.Dept;
import com.yejinhui.springcloud.service.DeptService;

/**
 * @author ye.jinhui
 * @date 2018年11月12日
 */
@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptDao deptDao;

	@Override
	public boolean add(Dept dept) {
		Assert.notNull(dept, "dept is required!");
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		Assert.notNull(id, "id is required!");
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptDao.findAll();
	}

}
