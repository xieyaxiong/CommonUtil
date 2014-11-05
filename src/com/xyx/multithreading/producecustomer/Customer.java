package com.xyx.multithreading.producecustomer;

public class Customer {
	
	private String name;
	
	private int flag=1;
	
	public Customer(String name){
		this.name=name;
	}
	
	public void get(){
		CollectionM m=CollectionM.getInstance();
		while(true){
			String result=m.get();
			System.out.println("get===="+name+"===="+result);
			try{
				Thread.sleep(50);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(flag==0){
				break;
			}
		}
	}
	
	public void stop(){
		flag=0;
	}

}
