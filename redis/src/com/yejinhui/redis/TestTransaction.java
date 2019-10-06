package com.yejinhui.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTransaction {

	public boolean transMethod(String key1,String key2) throws InterruptedException {
		Jedis jedis = new Jedis("192.168.1.114", 6379);
		// 可用余额
		int balance;
		// 欠额
		int debt;
		// 实刷金额
		int amtToSubtract = 10;

		jedis.watch(key1);
		
		Thread.sleep(7000);
		balance = Integer.parseInt(jedis.get(key1));
		jedis.set(key1,"5");//此句不该出现，讲课方便。模拟其他程序已经修改了该条目
		if (amtToSubtract > balance) {
			jedis.unwatch();
			System.out.println("modify");
			return false;
		} else {
			System.out.println("============transaction==========");
			Transaction transaction = jedis.multi();
			transaction.decrBy(key1, amtToSubtract);
			transaction.incrBy(key2, amtToSubtract);
			transaction.exec();
			balance = Integer.parseInt(jedis.get(key1));
			debt = Integer.parseInt(jedis.get(key2));
			System.out.println("balance:" + balance);
			System.out.println("debt:" + debt);
			return true;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TestTransaction testTransaction = new TestTransaction();
		boolean result = testTransaction.transMethod("balance", "debt");
		System.out.println();
		
		// Jedis jedis = new Jedis("192.168.1.114", 6379);
		// Transaction transaction = jedis.multi();
		//
		// transaction.set("k44", "v44");
		// transaction.set("k55", "v55");
		//
		// transaction.exec();
		// transaction.discard();
	}
}
