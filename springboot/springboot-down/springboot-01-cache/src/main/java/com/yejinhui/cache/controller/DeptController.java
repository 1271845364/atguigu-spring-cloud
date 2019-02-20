package com.yejinhui.cache.controller;

import com.yejinhui.cache.bean.Department;
import com.yejinhui.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ye.jinhui
 * @project springboot-01-cache
 * @description
 * @create 2018/10/12 9:02
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id) {
        return deptService.getDeptById(id);
    }

}
