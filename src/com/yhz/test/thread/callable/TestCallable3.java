package com.yhz.test.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable3 {
	public static void main(String[] args) {
		MyCallable mc = new MyCallable();
		FutureTask future = new FutureTask(mc);
		new Thread(future).start();
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}



