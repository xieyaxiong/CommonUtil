package com.xyx.multithreading.producecustomer.upgrade;

import java.util.UUID;

public class Produce {
	
	private String name;
	
	private int flag=1;
	
	public Produce(String name){
		this.name=name;
	}
	
	public void add(){
		CollectionM m=CollectionM.getInstance();
		while(true){
			UUID idUuid=UUID.randomUUID();
			m.add(idUuid.toString());
			System.out.println("add===="+name+"===="+idUuid.toString());
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
