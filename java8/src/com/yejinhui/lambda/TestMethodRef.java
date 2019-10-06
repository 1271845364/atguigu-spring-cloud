package com.yejinhui.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用" （可以理解为方法引用是Lambda的另外一种表现形式）
 * 
 * 主要有三种语法格式：
 * 
 * 对象：：实例方法名
 * 
 * 类：：静态方法名
 * 
 * 类：：实例方法名
 * 
 * 注意：
 * 1、Lambda体中方法调用的参数列表与返回值类型，要与函数式接口中抽象方法的参数列表和返回值类型保持一致
 * 2、若Lambda参数列表中第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用 ClassName::methodName
 * 
 * 二、构造器引用：
 * 
 * 格式：
 * 
 * ClassName::new
 * 
 * 注意：需要调用的构造器要与函数式接口中抽象方法的参数列表保持一致
 * 
 * 三、数组引用：
 * Type::new
 * 
 * @author ye.jinhui
 * @date 2018年8月1日
 */
public class TestMethodRef {
	
	//数组引用
	@Test
	public void test7() {
		Function<Integer,String[]> fun = (x) -> new String[x];
		String[] apply = fun.apply(11);
		System.out.println(apply.length);
		
		Function<Integer,String[]> fun2 = String[]::new;
		String[] apply2 = fun2.apply(10);
		System.out.println(apply2.length);
	}
	
	@Test
	public void test6() {
		Function<Integer, Employee> fun = (x) -> new Employee(x);
		Employee employee = fun.apply(12);
		System.out.println(employee);
		
		Function<String,Employee> fun2 = Employee::new;
		Employee employee2 = fun2.apply("22");
		System.out.println(employee2);
		
		BiFunction<String, Integer, Employee> fun3 = Employee::new;
		Employee employee3 = fun3.apply("wangxx", 123);
		System.out.println(employee3);
	}
	
	//构造器引用
	@Test
	public void test5() {
		Supplier<Employee> sup = () -> new Employee();
		sup.get();
		
		//构造器引用方式
		Supplier<Employee> sup2 = Employee::new;
		Employee emp = sup2.get();
		System.out.println(emp);
		
	}
	
	//类：：实例方法名
	public void test4() {
		BiPredicate<String,String> bp = (x,y)->x.equals(y);
		
		BiPredicate<String, String> bp2 = String::equals;
		
		
	}

	// 类：：静态方法名
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		Comparator<Integer> com1 = Integer::compare;
	}

	// 对象：：实例方法名
	@Test
	public void test1() {
		Consumer<String> con = (x) -> System.out.println(x);

		Consumer<String> con1 = System.out::println;

		Consumer<String> con2 = System.out::println;
		con2.accept("aaa");
	}

	@Test
	public void test2() {
		Employee employee = new Employee();
		Supplier<String> supplier = () -> employee.getName();
		System.out.println(supplier.get());
		
		Supplier<Integer> s = employee::getAge;
		System.out.println(s.get());
	}

}
