package com.yejinhui.cache.mapper;

import com.yejinhui.cache.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/10/2 16:29
 */
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Update("update employee set lastName = #{lastName},email = #{email}," +
            "gender = #{gender},d_id = #{dId} where id = #{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) " +
            "values(#{lastName},#{email},#{gender},#{dId})")
    void insertEmp(Employee employee);

    @Select("select * from employee where lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}