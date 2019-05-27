package com.yhz.test.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestCallable {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*3);
		MyCallable task = new MyCallable();
		MyCallable2 task2 = new MyCallable2();
		
		//FutureTask+Callable
		FutureTask futureTask = new FutureTask(task);
		pool.submit(futureTask);
		//Future+Callable
		Future<Double>  future2 = pool.submit(task2);
		
		pool.shutdown();
		try {
			System.out.println(futureTask.get());
			System.out.println("--------------");
			System.out.println(future2.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5000);
			System.out.println("hello world");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}

class MyCallable implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		int temp = 0;
		for(int i=1 ;i<=100;i++){
			temp  += i;
		}
		return temp;
	}
}

class MyCallable2 implements Callable<Double>{
	

	@Override
	public Double call() throws Exception {
		
		return Math.random()*10;
	}
	
}

