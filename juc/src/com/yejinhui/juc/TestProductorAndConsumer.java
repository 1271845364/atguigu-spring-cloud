package com.yejinhui.juc;

/**
 * 生产者和消费者案例
 * 
 * @author ye.jinhui
 * @date 2018年8月15日
 */
public class TestProductorAndConsumer {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Productor productor = new Productor(clerk);
		Consumer consumer = new Consumer(clerk);

		new Thread(productor, "生产者A").start();
		new Thread(consumer, "消费者B").start();

	}
}

/**
 * 店员 多线程操作数据存在并发安全问题
 * 
 * @author ye.jinhui
 * @date 2018年8月15日
 */
class Clerk {
	private int product = 0;

	// 进货
	public synchronized void get() {//循环剩余次数：2
		if (product >= 1) {
			System.out.println("产品已满");
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}else {
			System.out.println(Thread.currentThread().getName() + ":" + ++product);
			this.notifyAll();
		}
	}

	// 卖货
	public synchronized void sale() {//product=0,循环剩余次数：1
		if (product <= 0) {
			System.out.println("产品缺货");
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}else {
			System.out.println(Thread.currentThread().getName() + ":" + --product);
			this.notifyAll();
		}
	}
}

/**
 * 生产者
 * 
 * @author ye.jinhui
 * @date 2018年8月15日
 */
class Productor implements Runnable {
	private Clerk clerk;

	public Productor(Clerk clerk) {
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
class Consumer implements Runnable {
	private Clerk clerk;

	public Consumer(Clerk clerk) {
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