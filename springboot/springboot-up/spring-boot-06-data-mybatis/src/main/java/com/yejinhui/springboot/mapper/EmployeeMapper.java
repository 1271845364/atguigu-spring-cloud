package com.yejinhui.springboot.mapper;

import com.yejinhui.springboot.bean.Employee;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/10/1 19:55
 */
//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);

}
