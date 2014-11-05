package com.xyx.multithreading.producecustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CollectionM {
	
	private Lock lock;
	
	private Condition condition;
	
	private static CollectionM m=null;
	
	private CollectionM(){
		lock=new ReentrantLock();
		condition=lock.newCondition();
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
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list.add(string);
		System.out.println("list count:"+list.size());
		condition.signalAll();
		lock.unlock();
	}
	
	public String get(){
		lock.lock();
		while(list.size()==0){
			try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String result=list.remove(0);
		System.out.println("list count:"+list.size());
		condition.signalAll();
		lock.unlock();
		return result;
	}
	
}
