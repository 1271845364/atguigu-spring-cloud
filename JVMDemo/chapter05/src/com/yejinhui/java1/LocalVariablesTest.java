package com.yejinhui.java1;

import java.util.Date;

/**
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/1 16:20
 */
public class LocalVariablesTest {

    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
    }

    public static void testStatic() {
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
        //因为this变量不存在于当前方法的局部变量表中
//        System.out.println(this.count);
    }

    //关于slot的使用理解
    public LocalVariablesTest() {
        this.count = count;
    }

    public void test1() {
        Date date = new Date();
        String name1 = "yejinhui.com";
        test2(date,name1);
        System.out.println(date+name1);
    }

    public String test2(Date date, String name1) {
        date = null;
        name1 = "yjh";
        double weight = 130.5;//占据两个slot
        char gender = '男';
        return date + name1;
    }

    public void test3() {
        count++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a+1;
        }
        //变量c使用的是之前销毁的变量b占据的slot位置
        int c = a+1;
    }

    public void test5Temp() {
        int num;
//        System.out.println(num);错误信息，局部变量没有初始化，不能使用
    }
}
