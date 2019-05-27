package com.yhz.test.dataStructure.sort;

public class MergeSort {
	public static void mergeSort(int[] arr,int low,int high){
		if(low < high){
			int mid = (low+high)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	
	public static void merge(int[] arr,int low,int mid,int high){
		int[] temp = new int[arr.length];
		int tempIndex = low;
		int highLeft = mid + 1;
		int index = low;
		while(low <= mid && highLeft <= high){
			if(arr[low] < arr[highLeft]){
				temp[tempIndex++] = arr[low++];
			}else{
				temp[tempIndex++] = arr[highLeft++];
			}
		}
		//  剩余部分依次放入临时数组（两个while只会执行一个）
		while(highLeft <= high){
			temp[tempIndex++] = arr[highLeft++];
		}
		while(low <= mid){
			temp[tempIndex++] = arr[low++];
		}
		//将临时数组中的内容拷贝回原数组中
		while(index <= high){
			arr[index] = temp[index];
			index++;
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
