package com.yejinhui.cache.service;

import com.yejinhui.cache.bean.Department;
import com.yejinhui.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author ye.jinhui
 * @project springboot-01-cache
 * @description
 * @create 2018/10/11 17:29
 */
@Service
public class DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    private CacheManager deptCacheManager;

    /**
     * 缓存的数据能存入到redis中
     * 第二次从缓存中查询就不能反序列化回来
     * 存的是Dept的缓存json数据，CacheManager默认使用 RedisTemplate<Object, Employee> 操作redis
     *
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "dept",cacheManager = "deptCacheManager")
//    public Department getDeptById(Integer id) {
//        System.out.println("查询" + id + "号部门");
//        return departmentMapper.getDeptById(id);
//    }

    //使用缓存管理器得到缓存，进行api调用
    public Department getDeptById(Integer id) {
        System.out.println("查询" + id + "号部门");
        //获取某个缓存
        Cache dept = deptCacheManager.getCache("dept");
        String deptKey = "dept:" + id;
        Cache.ValueWrapper valueWrapper = dept.get(deptKey);
        Department department = null;
        if (valueWrapper != null) {
            department = (Department) valueWrapper.get();
            if (department != null) {
                return department;
            }
        }
        department = departmentMapper.getDeptById(id);
        dept.put(deptKey, department);
        return department;
    }
}
