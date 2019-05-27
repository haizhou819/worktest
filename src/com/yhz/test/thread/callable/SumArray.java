package com.yhz.test.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class SumArray {
	private int cpuCoreNum;
	private ExecutorService pool;
	List<Future<Integer>> list = new ArrayList<Future<Integer>>();
	
	public SumArray(){
		cpuCoreNum = Runtime.getRuntime().availableProcessors();
		pool = Executors.newFixedThreadPool(cpuCoreNum);
	}
	
	class SumCallable implements Callable<Integer>{
		int[] arr;
		int start;
		int end;
		int tempResult;
		public SumCallable(int[] arr,int start,int end){
			this.arr = arr;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public Integer call() throws Exception {
			for(int i=start;i<end;i++){
				tempResult += arr[i]; 
			}
			return tempResult;
		}
	}
	
	public int sum(int[] array){
		int arrLen = array.length;
		int increment = arrLen/cpuCoreNum + 1;
		int result = 0;
		for(int i=0;i<cpuCoreNum;i++){
			int start = i*increment;
			int end = (i+1)*increment;
			if(end > arrLen){
				end = arrLen;
			}
			SumCallable task = new SumCallable(array,start,end);
			Future<Integer> future = pool.submit(task);
			list.add(future);
		}
		for(Future<Integer> future : list){
			try {
				result += future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11,13};  
		SumArray s = new SumArray();
		int result = s.sum(numbers);
		System.out.println(result+"--------");
		s.pool.shutdown();
	}
}
