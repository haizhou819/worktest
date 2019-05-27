package com.yhz.test.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable2 {
	public static void main(String[] args) {
		int ThreadNum = 5;
		ExecutorService pool = Executors.newFixedThreadPool(ThreadNum);
		List<Future> list = new ArrayList<Future>();
		MyCallable task = new MyCallable();
		MyCallable2 task2 = new MyCallable2();
		Future f = pool.submit(task);
		Future f2 = pool.submit(task2);
		
		list.add(f);
		list.add(f2);
		/*for(int i=0;i<ThreadNum;i++){
			MyCallable task = new MyCallable();
			Future f = pool.submit(task);
			
			list.add(f);
		}*/
		
		pool.shutdown();
		
		for(Future t : list){
			try {
				System.out.println(t.get());
				System.out.println("---------------");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}


