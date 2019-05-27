package com.yhz.test.job.worksApp.result;

import java.util.Scanner;
import java.util.Stack;

public class Test2 {
	private static int n,m;
	private static int[][] grid;
	private static boolean[][] flag;
	private static int[] dx = {-1,1,0};
	private static int[] dy = {0,0,1};
	
	public static void initGrid(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		flag = new boolean[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				grid[i][j] = sc.nextInt();
				flag[i][j] = false;
			}
		}
	}
	Stack<Pos> stack = new Stack<Pos>();
	public  int findMax(int x,int y){
		Pos initPos = new Pos(x,y,0,grid[x][y]);
		stack.push(initPos);
		int ret = -1;
		while(!stack.isEmpty()){
			Pos temp = stack.peek();
			if(temp.dir == 3){
				stack.pop();
				flag[temp.row][temp.col] = false;
				continue;
			}
			int p = temp.row + dx[temp.dir];
			int q = temp.col + dy[temp.dir];
			temp.dir++;
			if(q == m){
				if(ret < temp.value){
					ret = temp.value;
				}
				continue;
			}
			if(p == -1){//向上越界
				p = n-1;
				if(grid[p][q] != -1 && flag[p][q] == false){
					stack.push(new Pos(p,q,0,grid[p][q]));
					flag[p][q] = true;
				}
				continue;
			}
			if(p == n){ //向下越界
				p = 0;
				if(grid[p][q] != -1 && flag[p][q]){
					stack.push(new Pos(p,q,0,grid[p][q]));
					flag[p][q] = true;
				}
				continue;
			}
			if(grid[p][q] == -1 || flag[p][q] == true){
				continue;
			}else{
				stack.push(new Pos(p,q,0,temp.value+grid[p][q]));
				flag[p][q] = true;
				continue;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Test2 test = new Test2();
		initGrid();
		int ret = test.findMax(3,0);
		System.out.println(ret);
	}
	
	private class Pos{
		private int row,col;
		private int value;
		private int dir;
		
		public Pos(int row,int col,int dir,int value){
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.value = value;
		}
		
		public String toString(){
			return "("+row+","+col+","+dir+","+value+")";
		}
	}
}
