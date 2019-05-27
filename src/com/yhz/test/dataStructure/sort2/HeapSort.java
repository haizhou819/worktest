package com.yhz.test.dataStructure.sort2;

public class HeapSort {
	public static void heapSort(int[] arr){
		for(int i=arr.length-1;i>=0;i--){
			createHeap(arr,i);
			swap(arr,0,i);
		}
	}
	
	public static void createHeap(int[] arr,int lastIndex){
		for(int i=(lastIndex-1)/2;i>=0;i--){//索引为lastIndex的父节点的索引为(lastIndex-1)/2
			int k = i;
			while(2*k+1 <= lastIndex){
				int biggerIndex = 2*k + 1;//寻找子节点较大的值
				if(biggerIndex < lastIndex){
					if(arr[biggerIndex] < arr[biggerIndex+1]){
						biggerIndex = biggerIndex + 1;
					}
				}
				if(arr[k] < arr[biggerIndex]){//若子节点的较大值比父节点的值大，则交换
					swap(arr,k,biggerIndex);
					k = biggerIndex;
				}else{
					break;
				}
			}
		}
	}
	
	public static void swap(int[] arr,int i,int j){
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
