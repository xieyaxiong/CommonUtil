package com.xyx.multithreading.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestExcutor {
	
	public static void main(String[] args) {
		Executor executor = Executors.newSingleThreadExecutor();  
		Runnable task = new Runnable() {  
		    @Override  
		    public void run() {  
		        System.out.println("task over");  
		        try{
		        	Thread.sleep(1000);
		        }catch (Exception e) {
					// TODO: handle exception
				}
		    }  
		};  
		for(int i=0;i<10;i++){
			executor.execute(task); 
			
		}
		System.out.println("Íê³É");
	}

}


