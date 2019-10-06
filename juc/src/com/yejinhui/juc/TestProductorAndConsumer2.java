package com.yejinhui.juc;

/**
 * 生产者和消费者案例
 * 
 * @author ye.jinhui
 * @date 2018年8月15日
 */
public class TestProductorAndConsumer2 {

	/**
	 * 会出现虚假唤醒
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Clerk2 clerk = new Clerk2();

		Productor2 productor = new Productor2(clerk);
		Consumer2 consumer = new Consumer2(clerk);

		new Thread(productor, "生产者A").start();
		new Thread(consumer, "消费者B").start();

		new Thread(productor, "生产者C").start();
		new Thread(consumer, "消费者D").start();
	}
}

/**
 * 店员 多线程操作数据存在并发安全问题
 * 
 * @author ye.jinhui
 * @date 2018年8月15日
 */
class Clerk2 {
	private int product = 0;

	// 进货
	public synchronized void get() {// 循环剩余次数：2
		if (product >= 1) {
			System.out.println("产品已满");
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + ++product);
		this.notifyAll();
	}

	// 卖货
	public synchronized void sale() {// product=0,循环剩余次数：1
		if (product <= 0) {
			System.out.println("产品缺货");
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + --product);
		this.notifyAll();
	}
}

/**
 * 生产者
 * 
 * @author ye.jinhui
 * @date 2018年8月15日
 */
class Productor2 implements Runnable {
	private Clerk2 clerk;

	public Productor2(Clerk2 clerk) {
		super();
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				// 在网络中进行的，有0.2s的延迟是很正常的
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			clerk.get();
		}
	}
}

/**
 * 消费者
 * 
 * @author ye.jinhui
 * @date 2018年8月15日
 */
class Consumer2 implements Runnable {
	private Clerk2 clerk;

	public Consumer2(Clerk2 clerk) {
		super();
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}

}