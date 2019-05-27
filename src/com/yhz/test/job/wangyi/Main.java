package com.yhz.test.job.wangyi;

import java.util.Scanner;

public class Main {
	private static int n;
	private static int[] arr = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if(n > 100000){
			System.out.println("输入的值必须小于100000，请重新输入！");
			n = sc.nextInt();
		}
		int a = sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		int ret = getPoint(a);
		System.out.println(ret);
		
		
		sc.close();
	}
	
	public static int getPoint(int a){
		int result = a;
		for(int i=0;i<n;i++){
			if(arr[i] <= result){
				result += arr[i];
			}else{
				int temp = getComNum(result,arr[i]);
				result += temp;
			}
		}
		return result;
	}
	
	//求两数的最大公约数
	public static int getComNum(int m,int n){
		int result = m<n?m:n;
		 for(int i=result; i>=1;i--)
         {
             if ((n % i == 0) && (m % i == 0))
             {
                 result = i;
                 break;//结束循环，排除除数1。
             }
         }
		return result;
	}
	
	
}
