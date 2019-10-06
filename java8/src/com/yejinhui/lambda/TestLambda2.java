package com.yejinhui.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

import com.yejinhui.java8.MyFun;

/**
 * 一、Lambda表达式的基础语法：Java8中引入了一个新的操作符"->"该操作符成为箭头操作符或Lambda操作符
 * 						箭头操作符将Lambda表达式拆分成两部分：
 * 	左侧：Lambda表达式的"参数列表"
 * 	右侧：Lambda表达式中的"所需要执行的功能"，即Lambda体
 * 
 * 	语法方式一：无参数，无返回值
 * 		()->System.out.println("Hello Lambda!");
 * 
 * 	语法方式二：有一个参数，无返回值
 * 		(x) ->System.out.println(x);
 * 
 * 	语法格式三：若只有一个参数，可以省略小括号
 * 		x ->System.out.println(x);
 * 
 * 	语法格式四:有两个以上的参数，有返回值，并且Lambda体中有多条语句，多条语句放在{}中
 * 		(x,y) -> {
 *			System.out.println("函数式接口");
 *			return Integer.compare(x, y);
 *		};
 *  语法格式五：若Lambda体中只有一条语句，return和{}都可以省略不写 		
 * 		(x,y) -> Integer.compare(x, y);
 * 	语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即”类型推断“
 * 		(Integer x,Integer y) -> Integer.compare(x, y);
 * 
 * 总结：
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * 
 * 二、Lambda表达式需要“函数式接口”的支持
 * 函数式接口：接口中抽象方法只有一个；可以使用注解@FunctionalInterface修饰
 * 		   可以检查是否是函数式接口
 * 
 * @author ye.jinhui
 * @date 2018年7月28日
 */
public class TestLambda2 {
	
	@Test
	public void test1() {
		int num = 0;//jdk1.7前，必须是final的
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
//				System.out.println("Hello World!" + num++);//本质上还是final的
				System.out.println("Hello World!" + num);
			}
		};
		r.run();
		
		System.out.println("--------------------------------------");
//		Runnable r1 = () -> System.out.println("Hello Lambda!" + num++);
		Runnable r1 = () -> System.out.println("Hello Lambda!" + num);
		
		r1.run();
	}
	
	@Test
	public void test2() {
//		Consumer<String> con = (x) ->System.out.println(x);
		Consumer<String> con = x ->System.out.println(x);
		con.accept("我们厉害");
	}
	
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
		int i = com.compare(11, 1);
		System.out.println(i);
	}
	
	@Test
	public void test4() {
//		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x, y);
		int i = com.compare(2, 1);
		System.out.println(i);
	}
	
	@Test
	public void test5() {
//		String[] strs ;
//		strs = {"aaa","bbb","ccc"};
		
		List<String> list = new ArrayList<>();//<>中可以不用写，类型推断
		show(new HashMap<>());
	}
	
	public void show(Map<String,Integer> map){
		
	}
	
	//需求：对一个数进行运算
	@Test
	public void test6() {
//		Integer result = operation(100, new MyFun() {
//			
//			@Override
//			public Integer getValue(Integer num) {
//				return num*num;
//			}
//		});
//		Integer result = operation(100,(Integer x) -> x*x);
//		Integer result = operation(11,(Integer n) -> n+10);
		Integer result = operation(11,n -> n+10);
		System.out.println(result);
		
		System.out.println("==================");
		MyFun mf = x->x*x;
		System.out.println(mf.getValue(8));
	}
	
	public Integer operation(Integer num,MyFun mf) {
		return mf.getValue(num);
	}
}
