package com.yhz.test.thread.searchMax;

public class SearchMax extends Thread{
	private int low,high;
	private int[] array;
	private int max;
	
	public SearchMax(int low,int high,int[] array){
		this.low = low;
		this.high = high;
		this.array = array;
	}

	@Override
	public void run() {
		for(int i = low;i < high-1;i++){
			if(array[i] > array[i+1]){
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
		max = array[high-1];
	}
	
	public static int maxSearch(int[] arr){
		int length = arr.length;
		int Max = 0;
		SearchMax[] sm = new SearchMax[3];
		for(int i = 0;i < 3;i++){
			sm[i] = new SearchMax(i*length/3,(i+1)*length/3,arr);
			sm[i].start();
		}
		for(int i = 0; i < sm.length;i++){
			try {
				sm[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i = 0;i < sm.length-1;i++){
			if(sm[i].max > sm[i+1].max){
				int temp = sm[i].max;
				sm[i].max = sm[i+1].max;
				sm[i+1].max = temp;
			}
		}
		Max = sm[sm.length-1].max;
		return Max;
	}
	
	public static void main(String[] args) {
		int[] data = {12,28,57,98,12,42,24,13,18,103,56,79,79,218,68,32} ;
		int result = maxSearch(data);
		System.out.println(result);
	}

}
