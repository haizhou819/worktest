package com.yhz.test.dataStructure.sort;


public class ShellSort {
	public static void shellSort(int[] arr){
		int d = 1;
		while(d <= arr.length/3){
			d = d*3 + 1;
		}
		int j;
		for(;d>=1;d-=2){  //间距逐渐减小知道为1
			for(int i=d;i<arr.length;i++){  //插入排序
				int temp = arr[i];
				for(j=i;j>=d;j-=d){
					if(temp < arr[j-d]){
						arr[j] = arr[j-d];
					}else{
						break;
					}
				}
				arr[j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] as = new int[]{3,5,4,8,7,90,80,88,23,17,56,12,20,36,18};
		shellSort(as);
		
		for(int a : as){
			System.out.print(a+" ");
		}
	}
}
