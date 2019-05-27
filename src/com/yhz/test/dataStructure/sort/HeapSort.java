package com.yhz.test.dataStructure.sort;

public class HeapSort {
	public static void heapSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			createHeap(arr,arr.length-1-i);
			swap(arr,0,arr.length-1-i);
		}
	}
	
	public static void createHeap(int[] arr,int lastIndex){
		for(int i=(arr.length-1)/2;i>=0;i--){
			int k = i;
			while(2*k+1 <= lastIndex){
				int biggerIndex = 2*k+1;
				if(biggerIndex < lastIndex){  //若右孩子存在，判断左孩子与右孩子谁的值大
					if(arr[biggerIndex] < arr[biggerIndex+1]){
						biggerIndex = biggerIndex+1;
					}
				}
				if(arr[k] <arr[biggerIndex]){
					swap(arr,k,biggerIndex);
					k = biggerIndex;
				}else{
					break;
				}
			}
		}
	}
	
	public static void swap(int[] arr,int i,int j){
		if(i == j){
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
        heapSort(data5);  
        for(int i=0;i<data5.length;i++){
        	System.out.print(data5[i] + " ");
        }
	}
}
