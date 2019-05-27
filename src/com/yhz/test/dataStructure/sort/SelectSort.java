package com.yhz.test.dataStructure.sort;

public class SelectSort {
	public static void selectSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int key = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[key] > arr[j]){
					key = j;
				}
			}
			if(i != key){
				int temp = arr[i];
				arr[i] = arr[key];
				arr[key] = temp;
			}
		}
	}
	public static void main(String[] args) {
		int[] a = {12, 32, 6, 54, 23, 76, 26};
		selectSort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
