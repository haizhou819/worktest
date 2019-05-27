package com.yhz.test.job.worksApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FindIrreducibleFraction {
	private static int m,n;//0<m<n;
	private static List<String> ReList = new ArrayList<String>();
	private static List<String> IrreList = new ArrayList<String>();
	
	public static void put(int m,int n){
		for(int i=1;i<m;i++){
			for(int j=m;j<n;j++){
				if(findComNum(i,j) != 1){  //可约
					ReList.add(i + "/" + j);
				}else{    //不可约
					IrreList.add(i + "/" + j);
				}
			}
		}
	}
	
	//求两数的最大公约数
	public static int findComNum(int a,int b){
		int ret = a>b?b:a;
		for(int i=ret;i>=1;i--){
			if((a % i == 0) && (b % i == 0)){
				ret = i;
				break;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		put(m,n);
		System.out.print("不可约：");
		System.out.println(IrreList);
		System.out.print("可约");
		System.out.println(ReList);
		sc.close();
	}
}
