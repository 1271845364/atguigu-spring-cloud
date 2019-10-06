package com.yejinhui.exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestLambda {

	List<Employee> emps = Arrays.asList(new Employee(101, "张三", 18, 9999.99), new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33), new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55));

	@Test
	public void test1() {
		Comparator<Employee> com = (x, y) -> {
			if (x.getAge() != y.getAge()) {
				return x.getAge() - y.getAge();
			} else {
				return x.getName().compareTo(y.getName());
			}
		};
		
		//定制排序
		Collections.sort(emps, com);
		emps.stream().forEach(System.out::print);
	}
	
	@Test
	public void test2() {
		String str ="abcdef";
//		toUpperCase(str, new MyFunction() {
//			@Override
//			public String getValue(String str) {
//				return str.toUpperCase();
//			}
//		});
		str = toUpperCase(str, (x) -> x.toUpperCase().substring(2, 4));
		System.out.println(str);
	}
	
	public String toUpperCase(String str,MyFunction myFun){
		return myFun.getValue(str);
	}
	
	@Test
	public void test3() {
		longOperarion(12L,12L, (x,y) -> x+y);
		longOperarion(12L,12L, (x,y) -> x*y);
	}
	
	public void longOperarion(Long l1,Long l2,MyFunction2<Long,Long> myFun){
		System.out.println(myFun.getValue(l1,l2));
	}
	
}
