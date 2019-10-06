package com.yejinhui.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

import com.yejinhui.java8.Employee;
import com.yejinhui.java8.FilterEmployeeByAge;
import com.yejinhui.java8.FilterEmployeeBySalary;
import com.yejinhui.java8.MyPredicate;

public class TestLambda {

	@Test
	public void test1() {
		// 创建匿名内部类对象
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};

		// 排序号的Set
		TreeSet<Integer> treeSet = new TreeSet<>(com);
	}

	// Lambda表达式
	@Test
	public void test2() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		TreeSet<Integer> treeSet = new TreeSet<>(com);
	}

	static List<Employee> employees = Arrays.asList(new Employee("张三", 18, 9999.99), new Employee("李四", 38, 5555.99),
			new Employee("王五", 50, 6666.66), new Employee("赵六", 16, 3333.33), new Employee("田七", 8, 7777.77));

	@Test
	public void test3() {
		List<Employee> list = filterEmployees(employees);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	// 需求：获取当前公司中年龄大于35的员工信息
	public List<Employee> filterEmployees(List<Employee> list) {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : list) {
			if (employee.getAge() >= 35) {
				emps.add(employee);
			}
		}
		return emps;
	}

	// 优化方式一：策略设计模式
	@Test
	public void test4() {
		List<Employee> list = filterEmployee(employees, new FilterEmployeeByAge());
		for (Employee employee : list) {
			System.out.println(employee);
		}

		System.out.println("-----------------------------");

		List<Employee> list2 = filterEmployee(employees, new FilterEmployeeBySalary());
		for (Employee employee : list2) {
			System.out.println(employee);
		}
	}

	public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : list) {
			if (mp.test(employee)) {
				emps.add(employee);
			}
		}
		return emps;
	}

	// 优化方式二：匿名内部类对象
	@Test
	public void test5() {
		List<Employee> emps = filterEmployee(employees, new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getSalary() <= 5000;
			}
		});

		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}

	// 优化方式三：Lambda表达式
	@Test
	public void test6() {
		List<Employee> emps = filterEmployee(employees, (e) -> e.getSalary() <= 5000);
		emps.forEach(System.out::println);
	}
	
	// 优化方式四：Stream API
	@Test
	public void test7() {
		employees.stream().filter((e)->e.getSalary()>=5000)
						  .limit(2)
						  .forEach(System.out::println);
		
		System.out.println("------------------------------");
		employees.stream().map(Employee::getName).forEach(System.out::println);
	}
}
