package com.yejinhui.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.yejinhui.java8.Employee;
import com.yejinhui.java8.Employee.Status;

/**
 * 终止操作
 * 
 * @author ye.jinhui
 * @date 2018年8月9日
 */
public class TestStreamAPI3 {

	static List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99,Status.FREE), 
			new Employee("李四", 58, 5555.55,Status.BUSY),
			new Employee("王五", 26, 3333.33,Status.VOCATION), 
			new Employee("赵六", 36, 6666.66,Status.FREE), 
			new Employee("田七", 12, 8888.88,Status.BUSY), 
			new Employee("田七", 12, 8888.88,Status.BUSY)
	);
	
	/**
	 * 收集
	 * collect(Collector c) 将流转换为其他形式。接收一个 Collector接口的
		实现，用于给Stream中元素做汇总的方法
	 */
	@Test
	public void test10() {
		String string = employees.stream().map(Employee::getName)
				.collect(Collectors.joining(":","prefix符号","suffix符号"));
		System.out.println(string);
	}
	
	@Test
	public void test9() {
		DoubleSummaryStatistics doubleSummaryStatistics = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(doubleSummaryStatistics.getAverage());
	}
	
	//分区
	@Test
	public void test8() {
		Map<Boolean, List<Employee>> map = employees.stream().collect(Collectors.partitioningBy((e)->e.getSalary()>5000));
		Set<Boolean> set = map.keySet();
		for (Boolean b : set) {
			System.out.println(b+":" + map.get(b));
		}
	}
	
	//多级分组
	@Test
	public void test7() {
		Map<Status, Map<String, List<Employee>>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus,
				Collectors.groupingBy((e)->{
					if(((Employee)e).getAge()<=35) {
						return "青年";
					}else if(((Employee)e).getAge()<=50) {
						return "中年";
					}else{
						return "老年";
					}
				})));
		Set<Status> set = map.keySet();
		for (Status status : set) {
			Map<String, List<Employee>> ageMap = map.get(status);
			Set<String> ageSet = ageMap.keySet();
			System.out.println(status);
			for (String age : ageSet) {
				System.out.println(age + ":" + ageMap.get(age));
			}
		}
		
	}
	
	//分组
	@Test
	public void test6() {
		Map<Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
		Set<Status> set = map.keySet();
		for (Status status : set) {
			System.out.println(map.get(status));
		}
	}
	
	@Test
	public void test5() {
		//总数
		Long count = employees.stream().collect(Collectors.counting());
		System.out.println(count);
		System.out.println("----------------------------");
		
		//平均值
		Double avgSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avgSalary);
		
		//工资总和
		Double sumSalary = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sumSalary);
		
		//最大值
		Optional<Employee> optional = employees.stream().collect(Collectors.maxBy((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println(optional.get().getSalary());
		
		//最小值
		Optional<Employee> optional2 = employees.stream().collect(Collectors.minBy((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println(optional2.get().getSalary());
		
		
	}
	
	@Test
	public void test4() {
		List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(list);
		System.out.println("--------------------");
		
		Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toSet());
		System.out.println(set);
		
		
		HashSet<String> hashSet = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
		System.out.println(hashSet);
		
		
	}
	
	/**
		归约
		reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。
		返回 Optional<T>
	 */
	@Test
	public void test3() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//为什么返回的是数值，不可能是空，因为起始值是0
										 //起始值
		Integer sum = list.stream().reduce(0, (x,y)->x+y);
		System.out.println(sum);
		
		System.out.println("----------------------------------------");
		//计算当前工资总额
		//为什么返回的是Optional，因为总和有可能是空的，可能为空的才封装到optional中
		Optional<Double> sumSalary = employees.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println("当前公司的总工资：" + sumSalary.get());
	}
	
	/**
	 *  allMatch(Predicate p) 检查是否匹配所有元素
		anyMatch(Predicate p) 检查是否至少匹配一个元素
		noneMatch(Predicate p) 检查是否没有匹配所有元素
		findFirst() 返回第一个元素终端操作会从流的流水线生成结果。其结果可以是任何不是流的值，例如： List、 Integer，甚至是 void 。
		findAny() 返回当前流中的任意元素
		count() 返回流中元素总数
		max(Comparator c) 返回流中最大值
		min(Comparator c) 返回流中最小值
	 */
	
	@Test
	public void test2() {
		long count = employees.stream().count();
		System.out.println("当前公司总人数：" + count);
		
		Optional<Employee> optional = employees.stream().max((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(optional.get());
		
		Optional<Double> optional2 = employees.stream().map(Employee::getSalary).min((s1,s2)->Double.compare(s1, s2));
		System.out.println(optional2.get());
	}
	
	@Test
	public void test1() {
		boolean allMatch = employees.stream().allMatch((e)->e.getStatus().equals(Status.BUSY));
		System.out.println(allMatch);
		
		boolean anyMatch = employees.stream().anyMatch((e)->e.getStatus().equals(Status.BUSY));
		System.out.println(anyMatch);
		
		boolean noneMatch = employees.stream().noneMatch((e)->e.getStatus().equals(Status.BUSY));
		System.out.println(noneMatch);
		
		Optional<Employee> optional = employees.stream().sorted((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary()))
							.findFirst();
		System.out.println(optional.get());
		
		//并行流，多个线程同时去找，谁先找到要谁的
		Optional<Employee> optional2 = employees.parallelStream().filter((e)->e.getStatus().equals(Status.FREE))
							.findAny();
		System.out.println(optional2.get());
	}
	
}
