package com.yhz.test.dataStructure.sort;

public class InsertSort {
	public static void insertSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int key = arr[i];
			int j;
			for(j=i-1;j>=0;j--){
				if(key < arr[j]){
					arr[j+1] = arr[j];
				}else{
					break;
				}
			}
			arr[j+1] = key;
		}
	}
	
	public static void insertSort2(int[] arr){
		for(int i=1;i<arr.length;i++){
			int key = arr[i];
			int j;
			for(j=i;j>=1;j--){
				if(key < arr[j-1]){
					arr[j] = arr[j-1];
				}else{
					break;
				}
			}
			arr[j] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {12, 32, 6, 54, 23, 76, 26};
		insertSort2(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
