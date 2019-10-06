package com.yejinhui.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月13日
 */
public class TestSimpleDateFormat {

	/*
	 * 下面的存在多线程并发操作安全问题，可以加锁，使用threadLocal加锁
	 */
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return sdf.parse("20161218");
			}
		};
		
		//线程池固定10个线程 
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		List<Future<Date>> results = new ArrayList<>();
		for (int i=0;i<10;i++) {
			results.add(pool.submit(task));
		}
		
		for(Future future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}
	
	/**
	 * 使用ThreadLocal实现加锁
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return DateFormatThreadLocal.convert("20161218");
			}
		};
		
		//线程池固定10个线程 
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		List<Future<Date>> results = new ArrayList<>();
		for (int i=0;i<10;i++) {
			results.add(pool.submit(task));
		}
		
		for(Future future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}

	@Test
	public void test2() throws Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		Callable<LocalDate> task = new Callable<LocalDate>() {
			@Override
			public LocalDate call() throws Exception {
				return LocalDate.parse("20161218", dtf);
			}
		};
		
		//线程池固定10个线程 
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		List<Future<LocalDate>> results = new ArrayList<>();
		for (int i=0;i<10;i++) {
			results.add(pool.submit(task));
		}
		
		for(Future future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}
}
