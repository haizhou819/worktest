package com.yhz.test.job.hw;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0;i<10;i++){
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		move2(arr,m);
		
		//reverseArray(arr,0,arr.length-1);
		for(int i=0;i<10;i++){
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}
	
	public static void move(int[] arr,int m){
		while(m != 0){
			int temp = arr[arr.length-1];
			for(int i=arr.length-1;i>0;i--){
				arr[i] = arr[i-1];
			}
			arr[0] = temp;
			m--;
		}
	}
	
	/**编写一个能够支持数组快速移位的算法，时间复杂度在O(N)以内。 
	 * 要实现在线性的时间内实现数组的快速移动，就要考虑如何使用逆序算法来达
	 * 到移动的目的。例如，我要移动的数组元素称为A，剩余的部分称为B，
	 * 那么原来次序为AB，如何变成BA呢？其实根据倒置的算法是可以实现移位操作的，
	 * 我们先取A'为A的逆序序列，B'为B的逆序序列,进行(A'B')'操作即可得到BA序列。
	 * 实现算法如下： 
	 * @param arr
	 * @param m
	 */
	public static void move2(int[] arr,int m){
		reverseArray(arr,0,m-1);
		reverseArray(arr,m,arr.length-1);
		reverseArray(arr,0,arr.length-1);
	}
	
	public static void reverseArray(int[] arr,int low,int high){
		if(low > high){
			System.out.println("Index Ereor!");
			return;
		}
		while(low < high){
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}
}
