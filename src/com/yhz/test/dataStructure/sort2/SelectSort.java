package com.yhz.test.dataStructure.sort2;

public class SelectSort {
	public static void selectSort1(int[] arr){
		for(int i=0;i<arr.length;i++){
			int key = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[key] > arr[j]){
					key = j;
				}
			}
			if(key != i){
				int temp = arr[key];
				arr[key] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	public static void selectSort2(int[] arr){
		for(int i=arr.length-1;i>=0;i--){
			int key = i;
			for(int j=i-1;j>=0;j--){
				if(arr[key] < arr[j]){
					key = j;
				}
			}
			if(key != i){
				int temp = arr[key];
				arr[key] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {12, 32, 6, 54, 23, 76, 26};
		selectSort2(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
