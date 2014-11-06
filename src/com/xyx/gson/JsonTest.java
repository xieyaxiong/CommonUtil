package com.xyx.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonTest {
	
	public static void main(String[] args) {
		
		//objectTest();
		
		//collectionTest();
		
		mapTest();
	}
	
	public static void objectTest(){
		User user=new User();
		user.setUsername("xieyaxiong");
		user.setEmail("xieyaxiong@163.com");
		user.setPassword("xyx");
		Gson gson=new Gson();
		String string=gson.toJson(user);
		System.out.println(string);
		user=gson.fromJson(string, User.class);
		System.out.println(user.getUsername()+":"+user.getEmail()+":"+user.getPassword());
	}
	
	public static void collectionTest(){
		List<User> list=new ArrayList<User>();
		for(int i=1;i<=3;i++){
			User user=new User();
			user.setUsername("xieyaxiong"+i);
			user.setEmail("xieyaxiong"+i+"@163.com");
			user.setPassword("xyx"+i);
			list.add(user);
		}
		Gson gson=new Gson();
		String string=gson.toJson(list);
		System.out.println(string);
		
		Type type = new TypeToken<List<User>>(){}.getType();
		list=gson.fromJson(string, type);
		for(User user:list){
			System.out.println("username:"+user.getUsername()+" email:"+user.getEmail());
		}
	}
	
	public static void mapTest(){
		Map<String, Object> map=new TreeMap<String, Object>();
		map.put("k", "kkk");
		map.put("j", "jjj");
		map.put("u", "uuu");
		Map<String, String> map2=new HashMap<String, String>();
		map2.put("x", "xxx");
		map2.put("q", "qqq");
		map.put("c", map2);
		Gson gson=new Gson();
		String string=gson.toJson(map);
		System.out.println(string);
		
		map=gson.fromJson(string, Map.class);
		System.out.println(map);
	}
	

}

class User{
	private String username;
	
	private String email;
	
	private transient String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
