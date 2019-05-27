package com.yhz.test.thread.searchMax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class searchMax3 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		int[] data = {12,28,57,98,12,42,24,13,18,103,56,79,79,218,68,32,528} ;
		int length = data.length;
		System.out.println("数组长度="+length);
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		//多线程计算结果
		for(int i=0;i<3;i++){
			System.out.println(i*length/3+"-----"+(i+1)*length/3);
			Search task = new Search(i*length/3,(i+1)*length/3,data);//1：0~5、2：5~11、3：11~17
			Future<Integer> future = pool.submit(task);
			list.add(future);
		}
		int[] dataMax = new int[list.size()];
		int i = 0;
		//遍历结果，把结果存放数组中
		for(Future<Integer> future : list){
			try {
				Integer tempMax = (Integer)future.get();
				dataMax[i++] = tempMax;
				System.out.println(tempMax+"----------");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		//从结果数组中查找需要的最终结果
		int max = 0;
		for(int j=0;j<dataMax.length-1;j++){
			if(dataMax[j] < dataMax[j+1]){
				max = dataMax[j+1];
			}
		}
		
		System.out.println(max+"*********");
		pool.shutdown();
	}
}

class Search implements Callable<Integer>{
	
	public int start;
	public int end;
	public int[] arr;
	public int max;

	public Search(int start,int end,int[] arr){
		this.start = start;
		this.end = end;
		this.arr = arr;
	}

	@Override
	public Integer call() throws Exception {
		int tempMax = 0;
		for(int i=start;i<end-1;i++){
			if(arr[i] < arr[i+1]){
				tempMax = arr[i+1];
			}
		}
		return tempMax;
	}
	
}
