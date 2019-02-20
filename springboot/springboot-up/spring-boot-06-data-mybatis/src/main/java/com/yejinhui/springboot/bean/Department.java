package com.yejinhui.springboot.bean;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/9/30 16:16
 */
public class Department {

    private Integer id;
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
