package com.yejinhui.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.yejinhui.java8.Employee;

/**
 * 一、Stream的三个操作步骤
 * 
 * 1.创建Stream
 * 
 * 2.中间操作
 * 
 * 3.终止操作(终端操作)
 * 
 * @author ye.jinhui
 * @date 2018年8月7日
 */
public class TestStreamAPI2 {
	
	static List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99), 
			new Employee("李四", 58, 5555.99),
			new Employee("王五", 26, 3333.33), 
			new Employee("赵六", 36, 6666.66), 
			new Employee("田七", 12, 8888.88),
			new Employee("田七", 12, 8888.88),
			new Employee("田七", 12, 8888.88)
	);
	
	//中间操作
	/*
	 * sorted() 产生一个新流，其中按自然顺序排序(Comparable)
	   sorted(Comparator comp) 产生一个新流，其中按比较器顺序排序
	 */
	@Test
	public void test7() {
		List<String> list = Arrays.asList("ccc","aaa","bbb","ddd","eee");
		list.stream().sorted().forEach(System.out::println);
		System.out.println("---------------------------------------");
		
		employees.stream().sorted((e1,e2)->{
			if(e1.getAge().equals(e2.getAge())) {
				return e1.getName().compareTo(e2.getName());
			}else{
				return -e1.getAge().compareTo(e2.getAge());
			}
		}).forEach(System.out::println);
		
	}
	
	@Test
	public void test6() {
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		
		List list2 = new ArrayList<>();
		list2.add(11);
		list2.add(22);
//		list2.addAll(list);
		list2.add(list);
		System.out.println(list2);
	}

	
	/*
	 *  映射：
	 * 	map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流，然后把所有流连接成一个流
	 */
	@Test
	public void test5() {
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		list.stream().map((str)->str.toUpperCase()).forEach(System.out::println);
		
		System.out.println("----------------------");
		employees.stream().map(Employee::getName).forEach(System.out::println);
		
		System.out.println("----------------------");
		Stream<Stream<Character>> stream = list.stream()
				.map(TestStreamAPI2::filterCharacter);//{ {a,a,a} , {b,b,b} }
		
		stream.forEach((sm)->{
			sm.forEach(System.out::println);
		});
		System.out.println("----------------------");
		
		Stream<Character> stream2 = list.stream()
				.flatMap(TestStreamAPI2::filterCharacter);//{a,a,a,b,b,b}
		stream2.forEach(System.out::println);
	}
	
	/**
	 * 将字符串的每一个字符存入到集合中
	 * 
	 * @param str
	 * @return
	 */
	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		return list.stream();
	}
	
	
	/*
	 *  filter(Predicate p) 接收 Lambda ， 从流中排除某些元素。
		limit(long maxSize) 截断流，使其元素不超过给定数量。
		skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素
		不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去
		除重复元素
	 */
	
	@Test
	public void test4(){
		employees.stream().filter((e)->e.getSalary()>5000)
							.skip(2)
							.distinct()
							.forEach(System.out::println);;
	}
	
	@Test
	public void test3() {
		employees.stream().filter((e)->{
								System.out.println("短路");//&& || 可以提高效率
								return e.getSalary()>5000;
							})
							.limit(2)
							.forEach(System.out::println);
	}
	
	//内部迭代：迭代操作由Stream API完成
	@Test
	public void test1() {
		//中间操作：不会执行任何操作
		Stream<Employee> stream = employees.stream().filter((e)->{
			System.out.println("Stream API 中间操作");
			return e.getAge()>35;
		});
		
		//终止操作：一次性执行全部内容，这个过程成为“惰性求值”
//		stream.forEach(System.out::println);
	}
	
	//外部迭代：
	@Test
	public void test2() {
		Iterator<Employee> iterator = employees.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
}
