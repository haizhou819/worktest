package com.yhz.test.dataStructure.sort;

public class QuickSort {
	public static void quickSort(int[] arr,int low,int high){
		if(low < high){
			int pivot = partion(arr,low,high);
			quickSort(arr,low,pivot-1);
			quickSort(arr,pivot+1,high);
		}
	}
	
	public static int partion(int[] arr,int low,int high){
		int temp = arr[low];
		while(low < high){
			while(low < high && temp < arr[high]){
				high--;
			}
			arr[low] = arr[high];
			while(low < high && temp > arr[low]){
				low++;
			}
			arr[high] = arr[low];
		}
		arr[high] = temp;
		return high;
	}
	
	public static void main(String[] args) {
		int[] a = {12, 32, 6, 54, 23, 76, 26};
		quickSort(a,0,a.length-1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
