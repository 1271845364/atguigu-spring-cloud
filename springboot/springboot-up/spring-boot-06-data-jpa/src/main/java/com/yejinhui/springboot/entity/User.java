package com.yejinhui.springboot.entity;

import javax.persistence.*;

/**
 * @author ye.jinhui
 * @version v1.0.0
 * @date 2018/10/2 10:59
 */
//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "tbl_user")   //@Table来指定和哪个数据表对应，如果省略默认就是user
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置成自增主键
    private Integer id;

    @Column//(name = "last_name",length = 50) //这是和数据表对应的一个列
    private String lastName;

    @Column //省略，默认列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
