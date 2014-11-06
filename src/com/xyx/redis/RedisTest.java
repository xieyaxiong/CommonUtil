package com.xyx.redis;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import redis.clients.jedis.Jedis;

/**
 * 保存速度10000次/秒
 * @author Administrator
 *
 */

public class RedisTest {
	public static int count=0;
	public static void main(String[] args) {
		for(int i=0;i<10000;i++){
			new saveDataThread().start();
			try{
				Thread.sleep(1);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
//		for(int i=0;i<100000;i++){
//			Jedis jedis=RedisUtil.getRedis();
//			UUID uuid=UUID.randomUUID();
//			System.out.println(i);
//			jedis.hset(uuid.toString(), uuid.toString(), uuid.toString());
//			RedisUtil.closeRedis(jedis);
//		}
	}
	
	public static void saveMac(String mac){
		Jedis jedis = RedisUtil.getRedis();  
		jedis.sadd("devicemac", mac); 
		jedis.close();
	}
	
	public static Set<String> getDevicemacAll(){
		Jedis jedis = RedisUtil.getRedis();  
		Set<String> deviceSet = jedis.smembers("devicemac"); 
		jedis.close();
		return deviceSet;
	}
	
	public static void saveMacAndUUID(String mac,String uuid){
		Jedis jedis = RedisUtil.getRedis();  
		jedis.hset("mac_uuid", mac, uuid);
		jedis.close();
	}
	
	public static Map<String, String> getMacAndUUID(){
		Jedis jedis = RedisUtil.getRedis();  
		Map<String,String> map = jedis.hgetAll("mac_uuid"); 
		jedis.close();
		return map;
	}
	
	public static String getUUID(String mac){
		Jedis jedis = RedisUtil.getRedis();  
		String uuid= jedis.hget("mac_uuid", mac);
		jedis.close();
		return uuid;
	}
	
	public static void saveMacAll(String mac){
		System.out.println("saveMac:"+mac);
		Jedis jedis = RedisUtil.getRedis();  
		if(!jedis.sismember("macAll", mac)){
			jedis.sadd("macAll", mac);
		}
		jedis.close();
	}
}


class saveDataThread extends Thread{
	
	public void run() {
		Jedis jedis=RedisUtil.getRedis();
		UUID uuid=UUID.randomUUID();
		jedis.hset(uuid.toString(), uuid.toString(), uuid.toString());
		RedisUtil.closeRedis(jedis);
		System.out.println(++RedisTest.count);
		
	};
}
