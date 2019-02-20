package com.yejinhui.cache.mapper;

import com.yejinhui.cache.bean.Department;
import org.apache.ibatis.annotations.Select;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/10/2 16:29
 */
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);
}
