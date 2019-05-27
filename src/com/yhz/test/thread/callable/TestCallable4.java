package com.yhz.test.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable4 {
	//没有使用线程池
	public static void main(String[] args) {
		//定义三个Callable类型的任务
		MyNewCallable call1 = new MyNewCallable(0);
		MyNewCallable call2 = new MyNewCallable(1);
		MyNewCallable call3 = new MyNewCallable(2);
		
		FutureTask f1 = new FutureTask(call1);
		FutureTask f2 = new FutureTask(call2);
		FutureTask f3 = new FutureTask(call3);
		
		try {
			//启三个线程执行三个Callable任务
			new Thread(f1).start();
			System.out.println("task1:"+f1.get());
			new Thread(f2).start();
			Thread.sleep(5000);
			System.out.println("task2:"+f2.cancel(true));
			new Thread(f3).start();
			System.out.println("task3:"+f3.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
	}
}

class MyNewCallable implements Callable {
	private int flag = 0;

	public MyNewCallable(int flag) {
		this.flag = flag;
	}

	@Override
	public String call() throws Exception {
		if (this.flag == 0) {
			return "flag = 0";
		}
		if (this.flag == 1) {
			try {
				while (true) {
					System.out.println("looping.");
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
			return "false";
		} else {
			throw new Exception("Bad flag value!");
		}
	}

}
