package com.yhz.test.job;

import java.util.Scanner;

public class Main {
	public static void t(int[] a){
		int maxLenght = 0;  //记录和为0的最大子数组长度
		int start=0;    //记录和为0的最大子数组开始下标
		for(int i=0;i<a.length;i++){
			int tempMaxLenght = 0;
			int temp = 0;
			for(int j = i;j<a.length;j++){
				temp = temp + a[j];
				if(temp == 0){
					tempMaxLenght = j-i+1;
					break;
				}
			}
			
			if(maxLenght <tempMaxLenght){
				maxLenght = tempMaxLenght;
				start = i;
			}
			
		}
		for(int i= start;i<maxLenght+start;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一串整数并在输入时用英文空格隔开 ");
		while(true){
			String inputString=sc.nextLine();
			System.out.println("*****************"+inputString+"*************");
			if (inputString.equals("bye")){ 
				break;
			} 
			String stringArray[]=inputString.split(" ");
			int num[]=new int[stringArray.length];
			for(int i=0;i<stringArray.length;i++){
			   num[i]=Integer.parseInt(stringArray[i]);
			  // System.out.print(num[i]+" ");
			}
			//int[] a = {9,2,1, 2, 3, 4, -1, -2, -4, -3, 1};9,2,1,2,3,4,-1,-2,-4,-3,1
			t(num);
		}
		sc.close();
	}
}
