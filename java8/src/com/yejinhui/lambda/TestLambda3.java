package com.yejinhui.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * Java8内置的四大核心函数式接口
 * 
 * Consumer<T>:消费型接口 void accept(T t);
 * 
 * Supplier<T>:供给型接口 T get();
 * 
 * Function<T,R>:函数型接口 R apply(T t);
 * 
 * Predicate<T>:断言型接口 boolean test(T t);
 * 
 * @author ye.jinhui
 * @date 2018年8月1日
 */
public class TestLambda3 {

	// Predicate<T>
	@Test
	public void test4() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("ab");
		list.add("acd");
		list.add("acde");
		filterStr(list, (l) -> l.length() > 2).stream().forEach(System.out::println);
	}

	// 需求：将满足条件的字符串放入集合中
	public List<String> filterStr(List<String> list, Predicate<String> pre) {
		List<String> newList = new ArrayList<>();
		for (String str : list) {
			if (pre.test(str)) {
				newList.add(str);
			}
		}
		return newList;
	}

	// Function<T,R>
	@Test
	public void test3() {
		int length = strLength("abcd", (x) -> x.length());
		System.out.println(length);
	}

	// 需求：处理字符串，返回字符串长度
	public int strLength(String str, Function<String, Integer> f) {
		return f.apply(str);
	}

	// Supplier<T>
	@Test
	public void test2() {
		List<Integer> list = getNumList(4, () -> (int) (Math.random() * 100));
		list.stream().forEach(System.out::println);
	}

	// 需求：产生指定个数整数，放入集合中
	public List<Integer> getNumList(int num, Supplier<Integer> s) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			list.add(s.get());
		}
		return list;
	}

	// Consumer<T>
	@Test
	public void test1() {
		happy(10000d, (x) -> System.out.println("我消费:￥" + x));
	}

	// 需求：想怎么消费就怎么消费
	public void happy(Double money, Consumer<Double> con) {
		con.accept(money);
	}
}
