package com.xyx.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	
	private static JedisPool jedisPool=null;
	
	public static Jedis getRedis(){
		if(jedisPool==null){
			synchronized (RedisUtil.class) {
				if(jedisPool==null){
					JedisPoolConfig config = new JedisPoolConfig(); 
			        config.setMaxWaitMillis(1000l);
			        config.setMaxTotal(1024);
			        config.setMaxIdle(50); 
			        config.setTestOnBorrow(false); 
			        
			        jedisPool = new JedisPool(config,"localhost");
				}
			}
			
		}
		return jedisPool.getResource();
	}
	
	public static void closeRedis(Jedis jedis){
		jedisPool.returnResource(jedis);
	}

}
