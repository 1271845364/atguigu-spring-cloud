package com.yejinhui.exer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.yejinhui.java8.Employee;
import com.yejinhui.java8.Employee.Status;

public class TestStreamAPI {
	
	static List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99,Status.FREE), 
			new Employee("李四", 58, 5555.55,Status.BUSY),
			new Employee("王五", 26, 3333.33,Status.VOCATION), 
			new Employee("赵六", 36, 6666.66,Status.FREE),
			new Employee("赵六", 36, 6666.66,Status.FREE), 
			new Employee("赵六", 36, 6666.66,Status.FREE), 
			new Employee("田七", 12, 8888.88,Status.BUSY)
	);
	

	/**
	 * 给定数字列表，如何返回由每一个数的平方构成的列表
	 * 给定[1,2,3,4,5]，返回[1,4,9,16,25]
	 */
	@Test
	public void test1() {
		Integer[] nums = new Integer[]{1,2,3,4,5};
		Arrays.stream(nums).map((x)->x*x).collect(Collectors.toList()).forEach(System.out::println);
	}
	
	/**
	 * 怎样用map和reduce数一数流中有多少个Employee
	 */
	@Test
	public void test2() {
		Integer sumCount = employees.stream().map((e)->{
			if(e!=null) {
				return 1;
			}
			return 0;
		}).reduce(0, Integer::sum);
		System.out.println(sumCount);
		//试验下格式化字符串
		System.out.println(String.format("Optional[%s]", "发送到"));
	}
	
}
