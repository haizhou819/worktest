package com.yhz.test.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Test {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 ForkJoinPool forkJoinPool = new ForkJoinPool();  
		 Future<Integer> result = forkJoinPool.submit(new Calculator(0, 1000)); 
		 
		 System.out.println(result.get());
		 
		 int num = 0;
		 for(int i=63;i<=125;i++){
			 num += i;
		 }
		 System.out.println(num);
	}
}
