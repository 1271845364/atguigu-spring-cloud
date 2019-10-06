package com.yejinhui.lambda;

import java.util.Optional;

import org.junit.Test;

import com.yejinhui.java8.Employee;
import com.yejinhui.java8.Godness;
import com.yejinhui.java8.Man;
import com.yejinhui.java8.NewMan;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月11日
 */
public class TestOptional {

	/**
	 *  Optional容器类常用方法：
	 *  Optional.of(T t) : 创建一个 Optional 实例
		Optional.empty() : 创建一个空的 Optional 实例
		Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
		isPresent() : 判断是否包含值
		orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
		orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
		map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
		flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
	 */
	@Test
	public void test4() {
		Optional<Employee> op = Optional.ofNullable(new Employee());
		
//		Optional<String> optional = op.map((e)->e.getName());
//		System.out.println(optional.get());
		
		Optional<String> optional2 = op.flatMap((e)->Optional.of(e.getName()));
		System.out.println(optional2.get());
	}
	
	@Test
	public void test3() {
		Optional<Employee> op = Optional.ofNullable(null);
		
//		if(op.isPresent()) {
//			System.out.println(op.get());
//		}
//		
//		Employee employee = op.orElse(new Employee("张三", 18, 888.88,Status.FREE));
//		System.out.println(employee);
		
		Employee employee = op.orElseGet(()->new Employee());
		System.out.println(employee);
	}
	
	@Test
	public void test2() {
		Optional<Employee> op = Optional.empty();
		System.out.println(op.get());
	}
	
	@Test
	public void test1() {
		Optional<Employee> op = Optional.of(null);
		Employee employee = op.get();
		System.out.println(employee);
	}
	
	//例题
	@Test
	public void test5() {
//		Man man = new Man();
//		String name = getGodnessName(man);
//		System.out.println(name);
		
		Optional<Godness> gn = Optional.ofNullable(new Godness("波多老师"));
		Optional<NewMan> man = Optional.ofNullable(new NewMan(gn));
		String name2 = getGodnessName2(man);
		System.out.println(name2);
	}
	
	public String getGodnessName2(Optional<NewMan> man) {
		return man.orElse(new NewMan())
				  .getGodness()
				  .orElse(new Godness("苍老师"))
				  .getName();
	}
	
	//需求：获取一个男人心中女神的名字
	public String getGodnessName(Man man) {
		if(man !=null && man.getGodness()!=null)
			return man.getGodness().getName();
		return "苍老师";
	}
}
