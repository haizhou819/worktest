package com.yhz.test.dataStructure.sort2;

public class ShellSort {
	public static void shellSort(int[] arr){
		int increment = 1;
		//寻找合适的间隔
		while(increment < arr.length/3){
			increment = increment * 3 + 1;
		}
		
		for(;increment>=1;increment = increment/3){
			for(int i=increment;i<arr.length;i++){
				int key = arr[i];
				int j;
				for(j=i;j>=increment;j-=increment){
					if(key < arr[j-increment]){
						arr[j] = arr[j-increment];
					}else{
						break;
					}
				}
				arr[j+increment] = key;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] data = {9,3,6,2,8,5};
		shellSort(data);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}
}
