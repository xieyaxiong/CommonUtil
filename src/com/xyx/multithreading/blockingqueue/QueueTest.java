package com.xyx.multithreading.blockingqueue;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {
	
	public static void main(String[] args) {
		ArrayBlockingQueue<String> blockingQueue=new ArrayBlockingQueue<String>(1000, true);
//		for(int i=0;i<10000;i++){
//			String string=blockingQueue.poll();
//			System.out.println(string+"====="+blockingQueue.size());
//		}
		
//		for(int i=0;i<1;i++){
//			CustomerThread customerThread=new CustomerThread(blockingQueue);
//			ProduceThread produceThread=new ProduceThread(blockingQueue);
//			customerThread.start();
//			produceThread.start();
//		}
	}

}

class CustomerThread extends Thread{
	
	private ArrayBlockingQueue<String> queue;
	
	public CustomerThread(ArrayBlockingQueue<String> queue){
		this.queue=queue;
	}
	public void run() {
		while(true){
			String string=queue.poll();
			if(string==null){
				System.out.println("get:"+string+"==="+queue.size());
			}
			
			try{
				Thread.sleep(20);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	};
}

class ProduceThread extends Thread{
	
	private ArrayBlockingQueue<String> queue;
	public ProduceThread(ArrayBlockingQueue<String> queue){
		this.queue=queue;
	}
	
	@Override
	public void run() {
		while(true){
			UUID uuid=UUID.randomUUID();
			boolean b=queue.offer(uuid.toString());
			if(!b){
				System.out.println("add:"+uuid.toString()+"==="+queue.size());
			}
			
			try{
				Thread.sleep(5);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
