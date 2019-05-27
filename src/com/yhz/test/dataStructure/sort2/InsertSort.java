package com.yhz.test.dataStructure.sort2;

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
	
	public static void main(String[] args) {
		int[] a = {12, 32, 6, 54, 23, 76, 26};
		insertSort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
