package com.yejinhui.java8;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月11日
 */
public class TestForkJoin {

	/**
	 * ForkJoin框架
	 */
	@Test
	public void test1() {
		Instant start = Instant.now();
		
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0, 10000000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);
		
		Instant end = Instant.now();
		System.out.println("耗时：" + Duration.between(start, end).toMillis());//2207
	}
	
	/**
	 * 普通for循环
	 */
	@Test
	public void test2() {
		Instant start = Instant.now();
		
		long sum = 0L;
		for(long i=0;i<=10000000000L;i++) {
			sum +=i;
		}
		System.out.println(sum);
		
		Instant end = Instant.now();
		System.out.println("耗时：" + Duration.between(start, end).toMillis());//3154
	}
	
	/**
	 * java8并行流
	 */
	@Test
	public void test3() {
		//顺序流,是单线程的
		long sum1 = LongStream.rangeClosed(0, 10000000000L)
				  				.reduce(0,Long::sum);
		System.out.println(sum1);
		
		Instant start = Instant.now();
		long sum2 = LongStream.range(0, 10000000000L)
							  .parallel()//底层就是ForkJoin
							  .reduce(0, Long::sum);
		System.out.println(sum2);
		Instant end = Instant.now();
		System.out.println("耗时：" + Duration.between(start, end).toMillis());//1883
	}
}
