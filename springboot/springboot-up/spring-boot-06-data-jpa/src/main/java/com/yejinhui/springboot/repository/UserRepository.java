package com.yejinhui.springboot.repository;

import com.yejinhui.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/10/2 11:16
 */
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {
}
