package com.xyx.multithreading.producecustomer.upgrade;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CollectionM {
	
	private Lock lock;
	
	private Condition emptyCondition;
	private Condition fullCondition;
	
	private static CollectionM m=null;
	
	private CollectionM(){
		lock=new ReentrantLock();
		emptyCondition=lock.newCondition();
		fullCondition=lock.newCondition();
	}
	
	public synchronized static CollectionM getInstance(){
		if(m==null){
			m=new CollectionM();
		}
		return m;
	}
	
	private List<String> list=new ArrayList<String>();
	private int length=20;
	
	public void add(String string){
		lock.lock();
		while(list.size()==length){
			try {
				fullCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list.add(string);
		System.out.println("list count:"+list.size());
		emptyCondition.signalAll();
		lock.unlock();
	}
	
	public String get(){
		lock.lock();
		while(list.size()==0){
			try {
				emptyCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String result=list.remove(0);
		System.out.println("list count:"+list.size());
		fullCondition.signalAll();
		lock.unlock();
		return result;
	}
	
}
