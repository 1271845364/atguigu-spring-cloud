package com.yejinhui.juc;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author ye.jinhui
 * @create 2017-02-26 17:45
 */
public class TestForkJoinPool {

    /**
     * Future:异步计算的结果
     *
     * @param args
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0l,10000000000l);

        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start,end).toMillis());
    }

    @Test
    public void test1() {

        Instant start = Instant.now();

        long sum = 0l;
        for(long i=0l;i<=10000000000l;i++) {
            sum += i;
        }
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start,end).toMillis());
    }

    @Test  //java8新特性
    public void test2() {
        Instant start = Instant.now();
        long sum = LongStream.rangeClosed(0l,10000000000l)
                .parallel().reduce(0l,Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        
        System.out.println("耗费时间为：" + Duration.between(start,end).toMillis());
    }

}
class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;

    private static final long THURSHOLD = 10000l;

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;

        if(length <= THURSHOLD) {
            long sum = 0l;
            for(long i=start;i<=end;i++) {
                sum += i;
            }
            return sum;
        }else {
            long middle = (start+end)/2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start,middle);
            left.fork();

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle+1,end);
            right.fork();

            return left.join() + right.join();
        }
    }
}