package com.yejinhui.stream;

import java.util.ArrayList;
import java.util.Arrays;
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
public class TestStreamAPI1 {

	// 创建Stream
	@Test
	public void test1() {
		// 串行流 并行流
		// 1.可以通过Collection系列集合提供的stream()或parallelStream()
		List<String> list = new ArrayList<String>();
		Stream<String> stream = list.stream();

		// 2.通过Arrays中的静态方法获取stream() 数组流
		Employee[] emps = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(emps);

		// 3.通过Stream类中的静态方法of()
		Stream<String> stream3 = Stream.of("aa", "bb", "cc");

		// 4.创建无限流
		// 迭代
		Stream<Integer> stream4 = Stream.iterate(11, (x) -> x + 2);
		stream4.limit(10).forEach(System.out::println);
		
		//生成
		Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
	}
}
