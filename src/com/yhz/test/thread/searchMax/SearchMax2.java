package com.yhz.test.thread.searchMax;

public class SearchMax2 extends Thread{
	private int low,high;
	private int[] arrays;
	private static int max;
	
	
	public SearchMax2(int[] arrays,int low,int high){
		this.low = low;
		this.high = high;
		this.arrays = arrays;
	}
	public void run(){
		for(int i=low;i<high-1;i++){
			if(arrays[i]>arrays[i+1]){
				int temp = arrays[i];
				arrays[i] = arrays[i+1];
				arrays[i+1] = temp;
			}
		}
		max = arrays[high-1];
	}
	public static int searchMax(int[] arr){
		int length = arr.length;
		SearchMax2[] sm2 = new SearchMax2[4];
		for(int i=0;i<4;i++){
			sm2[i] = new SearchMax2(arr,i*length/4,(i+1)*length/4);
			sm2[i].start();
		}
		for(int i = 0; i < sm2.length;i++){
			try {
				sm2[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<sm2.length-1;i++){
			if(sm2[i].max > sm2[i+1].max){
				int temp = sm2[i].max;
				sm2[i].max = sm2[i+1].max;
				sm2[i+1].max = temp;
			}
		}
		max = sm2[sm2.length-1].max;
		return max;
	}
	public static void main(String[] args) {
		int[] data = {12,28,57,98,12,42,24,13,18,103,56,79,79,218,68,32} ;
		int result = searchMax(data);
		System.out.println(result);
	}
}
