package com.yhz.test.job.worksApp;

/**
 * 给定数组： 
6   4   3   2   7 
4   5   7   5   5 
2   6   4   8   2 
3   8   1   2   4 
7   2   5   9   4 
        0 

假设从最后一行的0开始，只能向上走，并且每次只能走“上”，“上左”，“上右”这三个方向
（如第一次只能走2或5或9这三个方向且不能超过数组），按照这个规则，依次取得各数走到顶，
得到的一条从底到顶的路径的最大值是什么？ 
 * @author sunny
 *
 */

public class Main {
	int [][] aa = {
			{6,4,3,2,7},
			{4,5,7,5,5},
			{2,6,4,8,2},
			{3,8,1,2,4},
			{7,2,5,9,4}
			};
	
	int value = 0;
	
	public void go(int i,int j){
		int[][] temp = {{0,0},{0,0},{0,0}};
		if(j-1>-1){
			temp[0][0] = aa[i][j-1];
			temp[0][1] = j-1;
		}
		temp[1][0]=aa[i][j];
		temp[1][1] = j;
		if(j+1<5){
			temp[2][0] = aa[i][j+1];
			temp[2][1] = j+1;
		}
		int temValue = -1;
		int temIndex = -1;
		for(int k = 0;k<3;k++){			
			if(temp[k][0]>temValue){
				temValue = temp[k][0];
				temIndex = temp[k][1];
			}
		}	
		value += temValue;
		System.out.println(temValue);
		if(i-1>-1){
			go(i-1,temIndex);
		}
	}
	
	public void run(){
		go(aa.length-1,2);
		System.out.println("最大路径和："+value);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}
