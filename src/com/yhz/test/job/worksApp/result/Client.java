package com.yhz.test.job.worksApp.result;

import java.util.Scanner;

public class Client {
	private int n,m;
	private int[][] grid;
	private boolean[][] flag;
	private int[] dx = {-1,1,0};
	private int[] dy = {0,0,1};
	static int maxValue = 0;
	static int tempMaxValue = 0;
	
	public void initGrid(){
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		flag = new  boolean[n][m];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				grid[i][j] = sc.nextInt();
				flag[i][j] = false;
			}
		}
		sc.close();
	}
	
	public void findMax(int x,int y){
		for(int k=0;k<3;k++){
			int p = x + dx[k];
			int q = y + dy[k];
			
			if((0 <= p && p <= n-1) && (0 <= q && q <= m-1) && grid[p][q] != -1 && flag[p][q] == false){
				int temp = tempMaxValue;
				tempMaxValue += grid[p][q];
				flag[p][q] = true;
				if(maxValue < tempMaxValue){
					maxValue = tempMaxValue;
				}
				findMax(p,q);
				tempMaxValue = temp;
				flag[p][q] = false;
			}
			
			if(-1 == p){//向上越界
				p = n-1;
				if(grid[p][q] != -1 && flag[p][q] == false){
					int temp = tempMaxValue;
					tempMaxValue = grid[p][q];
					flag[p][q] = true;
					if(maxValue < tempMaxValue){
						maxValue = tempMaxValue;
					}
					findMax(p,q);
					tempMaxValue = temp;
					flag[p][q] = false;
				}
			}

			if(n == p){//向下越界
				p = 0;
				if(grid[p][q] != -1 && flag[p][q] == false){
					int temp = tempMaxValue;
					tempMaxValue = grid[p][q];
					flag[p][q] = true;
					if(maxValue < tempMaxValue){
						maxValue = tempMaxValue;
					}
					findMax(p,q);
					tempMaxValue = temp;
					flag[p][q] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		c.initGrid();
		tempMaxValue = c.grid[3][0];
		c.flag[3][0] = true;
		c.findMax(3, 0);
		System.out.println(maxValue);
	}
	
}
