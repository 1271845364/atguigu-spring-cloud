package com.yejinhui.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * JedisPool工具
 * @author ye.jinhui
 * @date 2016年12月25日
 */
public class JedisPoolUtil {

	/**
	 * 被volidate修饰的变量不会被本地线程缓存，对该变量的读写都是直接操作共享内存。
	 */
	private static volatile JedisPool jedisPool = null;
	
	private static String host = "192.168.1.114";
	private static int port = 6379;
	
	private JedisPoolUtil(){
	}
	
	/**
	 * 从JedisPool中获取客户端
	 * @return
	 */
	public static JedisPool getJedisPoolInstance() {
		if(null == jedisPool) {
			synchronized (JedisPoolUtil.class) {
				if(null == jedisPool) {
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					poolConfig.setMaxActive(1000);
					poolConfig.setMaxIdle(32);
					poolConfig.setMaxWait(100*1000);
					poolConfig.setTestOnBorrow(true);
					jedisPool = new JedisPool(poolConfig, host,port);
				}
			}
		}
		return jedisPool;
	}
	
	/**
	 * 释放Jedis客户端
	 * @param jedisPool
	 * @param jedis
	 */
	public static void release(JedisPool jedisPool,Jedis jedis) {
		if(jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}
}
