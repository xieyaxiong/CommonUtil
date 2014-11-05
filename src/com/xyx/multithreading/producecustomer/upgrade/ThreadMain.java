package com.xyx.multithreading.producecustomer.upgrade;

import java.util.ArrayList;
import java.util.List;

public class ThreadMain {
	
	public static void main(String[] args) {
		List<Customer> customers=new ArrayList<Customer>();
		List<Produce> produces=new ArrayList<Produce>();
		for(int i=0;i<10;i++){
			Produce produce=new Produce("produce"+i);
			produces.add(produce);
			new ThreadU(produce).start();
		}
		
		for(int i=0;i<10;i++){
			Customer customer=new Customer("customer"+i);
			customers.add(customer);
			new ThreadU(customer).start();
		}
	}

}


class ThreadU extends Thread{
	
	private Object object;
	
	public ThreadU(Object object){
		this.object=object;
	}
	
	public void run() {
		if(object instanceof Produce){
			Produce produce=(Produce)object;
			produce.add();
		}else if(object instanceof Customer){
			Customer customer=(Customer)object;
			customer.get();
		}
		
	};
}
