package com.yejinhui.java8;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3450223453821529411L;

	private long start;
	private long end;

	// 临界值
	private static final long THRESHOLD = 10000;
	
	public ForkJoinCalculate(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		long length = end - start;

		if (length <= THRESHOLD) {
			long sum = 0;
			for (long i = start; i <= end; i++) {
				sum +=i;
			}
			return sum;
		}else{
			//拆成子任务
			long middle = (start+end)/2;
			ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
			left.fork();//拆分成子任务，同时压入线程对列
			
			ForkJoinCalculate right = new ForkJoinCalculate(middle+1, end);
			right.fork();
			
			return left.join()+right.join();
		}
	}

}
