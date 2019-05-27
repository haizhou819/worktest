package com.yhz.test.job.worksApp;


public class Main1 {
	int value = 0;
	
	int [][] aa = {
			{6,4,3,2,7},
			{4,5,7,5,5},
			{2,6,4,8,2},
			{3,8,1,2,4},
			{7,2,5,9,4}
			};
	static boolean[][] p = new boolean[5][5];
	static{
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				p[i][j] = false;
			}
		}
	}
	
	public void go(int i,int j){
		int[][] temp = {{0,0,0},{0,0,0},{0,0,0}};
		if(j+1==5){
			return;
		}
		/*if(i-1==-1){//到最上面结束
			return;
		}*/
		if(i-1>-1){//向上
			temp[0][0] = aa[i-1][j];
			temp[0][1] = i-1;
			temp[0][2] = j;
		}
		if(i+1<5){//向下
			temp[1][0] = aa[i+1][j];
			temp[1][1] = i+1;
			temp[1][2] = j;
		}
		/*if(j-1>-1){//向左
			temp[1][0] = aa[i][j-1];
			temp[1][1] = i;
			temp[1][2] = j-1;
		}*/
		if(j+1<5){//向右
			temp[2][0] = aa[i][j+1];
			temp[2][1] = i;
			temp[2][2] = j+1;
		}
		int temValue = -1;
		int temIndexX = 0;
		int temIndexY = 0;
		for(int k=0;k<3;k++){			
			if(temp[k][0]>temValue&&p[temp[k][1]][temp[k][2]] != true){
				temValue = temp[k][0];
				temIndexX = temp[k][1];
				temIndexY = temp[k][2];
			}
		}	
		p[temIndexX][temIndexY] = true;
		value += temValue;
		System.out.println(temValue);
		if(i-1>-1){
			go(temIndexX,temIndexY);
		}
	}
	
	public void run(){
		go(4,0);
		System.out.println("最大路径和："+value);
	}
	
	public static void main(String[] args) {
		Main1 m = new Main1();
		m.run();
	}
}
