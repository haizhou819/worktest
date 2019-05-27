package com.yhz.test.job;

import java.util.Scanner;


public class Test {
	/**
	 * 获取报号淘汰最后留下的人的编号
	 *
	 * @param n 围一圈的人数
	 * @return 整型
	 */
	public static int leftPerson(int n) throws Exception {
		// 请在此添加代码
		 boolean[] persons = new boolean[n];
		 for(int i = 0; i < persons.length; i++) {
			 persons[i] = true;
		 }
		  
		 int num = 0,length = n;
		 while(length > 1){
			 for(int i = 0; i < persons.length; i++) {
                 if (persons[i]) {
                      num++;
                      if (num == 3) {
                          num = 0;
                          persons[i] = false;
                          length--;
                      }
                  }
			}
		 }
		 int result = 0;
		 for(int i = 0; i < persons.length; i++){
             if(persons[i]) {
           	     result = i+1; 
             }
		 }
		return result;
	}

	// 若有需要，请在此添加辅助变量、方法
	 public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("int n"+" ");
		int perNum = sc.nextInt();
		int leftNum = leftPerson(perNum);
		System.out.println(leftNum);
		sc.close();
	}
}
