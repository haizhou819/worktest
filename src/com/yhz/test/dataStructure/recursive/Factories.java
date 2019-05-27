package com.yhz.test.dataStructure.recursive;

public class Factories {
	public static  int t(int n){
		if(n == 0){
			return 1;
		}
		return n*t(n-1);
	}
	
	public static void main(String[] args) {
		
		int res = t(5);
		System.out.println(res);
	}
}
