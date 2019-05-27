package com.yhz.test.dataStructure.sort2;

public class MergeSort {
	public static void mergeSort(int[] arr,int low,int high){
		if(low < high){
			int mid = (low + high)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge2(arr,low,mid,high);
		}
	}
	
	public static void merge(int[] arr,int low,int mid,int high){
		int[] tempArr = new int[arr.length];
		int highLow = mid + 1;
		int tempIndex = low;
		int start = low;
		while(low <= mid && highLow <= high){
			while(low <= mid && arr[low] < arr[highLow]){
				tempArr[tempIndex++] = arr[low++];
			}
			while(highLow <= high && arr[low] > arr[highLow]){
				tempArr[tempIndex++] = arr[highLow++];
			}
		}
		//将另一序列剩下的所有元素直接复制到合并序列尾
		while(low <= mid){
			tempArr[tempIndex++] = arr[low++];
		}
		while(highLow <= high){
			tempArr[tempIndex++] = arr[highLow++];
		}
		
		for(int i=start;i<=high;i++){
			arr[i] = tempArr[i];
		}
	}
	
	public static void merge2(int[] arr,int low,int mid,int high){
		int[] tempArr = new int[high-low+1];
		int highLow = mid + 1;
		int tempIndex = 0;
		int start = low;
		while(start <= mid && highLow <= high){
			while(start <= mid && arr[start] < arr[highLow]){
				tempArr[tempIndex++] = arr[start++];
			}
			while(highLow <= high && arr[start] > arr[highLow]){
				tempArr[tempIndex++] = arr[highLow++];
			}
		}
		//将另一序列剩下的所有元素直接复制到合并序列尾
		while(start <= mid){
			tempArr[tempIndex++] = arr[start++];
		}
		while(highLow <= high){
			tempArr[tempIndex++] = arr[highLow++];
		}
		
		for(int i=0;i<tempArr.length;i++){
			arr[i+low] = tempArr[i];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {12, 32, 6, 54, 23, 76, 26};
		mergeSort(arr,0,arr.length-1);
		for(int a : arr){
			System.out.print(a + " ");
		}
	}
}
