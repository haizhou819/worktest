package com.yhz.test.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class SumArray2 extends RecursiveTask<Integer>{

	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 3;  
    private int start;  
    private int end; 
    private int[] arr; 
    
    public SumArray2(int[] arr,int start,int end){
    	this.arr = arr;
    	this.start = start;
    	this.end = end;
    }
    
	@Override
	protected Integer compute() {
		int sum = 0;
		if(end-start < THRESHOLD){
			for(int i=start;i<=end;i++){
				sum += arr[i]; 
			}
		}else{
			int middle = (start+end)/2;
			SumArray2 left = new SumArray2(arr,start,middle);
			SumArray2 right = new SumArray2(arr,middle+1,end);
			left.fork();
			right.fork();
			
			int num1 = left.join();
			int num2 = right.join();
			sum = num1 + num2;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();  
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11,13}; 
	    Future<Integer> future = forkJoinPool.submit(new SumArray2(numbers,0,numbers.length-1));
	    int result = 0;
	    try {
			result = future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	    System.out.println(result);
	}
	
}
