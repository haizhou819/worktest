package com.yhz.test.job.worksApp.result;

import java.util.Scanner;
import java.util.Stack;

public class Test {
	private static int n,m;
	private static int[][] grid;
	private static boolean[][] flag;
	private int[] dx = {-1,1,0};
	private int[] dy = {0,0,1};
	
	public int findMax(int i,int j){
		Stack<Point> stack = new Stack<Point>();
		stack.push(new Point(i,j,0,grid[i][j]));
		int maxValue = -1;
		flag[i][j] = true;
		while(!stack.isEmpty()){
			Point temp = stack.peek();
			if(temp.dir == 3){
				stack.pop();
				flag[temp.row][temp.col] = false;
				continue;
			}
			
			int p = temp.row + dx[temp.dir];
			int q = temp.col + dy[temp.dir];
			temp.dir++;
			
			if(q == m){
				if(maxValue < temp.value){
					maxValue = temp.value;
				}
				continue;
			}
			if(p == -1){ //向上越界
				p = n-1;
				if(grid[p][q] != -1 && flag[p][q] == false){
					stack.push(new Point(p,q,0,grid[p][q]));
					flag[p][q] = true;
					continue;
				}
			}
			if(p == n){//向下越界
				p = 0;
				if(grid[p][q] != -1 && flag[p][q] == false){
					stack.push(new Point(p,q,0,grid[p][q]));
					flag[p][q] = true;
					continue;
				}
			}
			if(grid[p][q] == -1 || flag[p][q] == true){
				continue;
			}else{
				stack.push(new Point(p,q,0,grid[p][q]+temp.value));
				flag[p][q] = true;
			}
		}
		return maxValue;
	}
	
	public void initGrid(){
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
		sc.close();
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		
		test.initGrid();
		int result = -99999;  //记录最终结果
		for(int i=0;i<n;i++){
			if(grid[i][0] != -1){
				flag[i][0] = true;
				int tempRsult = test.findMax(i, 0);
				flag[i][0] = false;
				if(result < tempRsult){
					result = tempRsult;
				}
			}
		}
		System.out.println(result);
	}
}
class Point{
	public int row;
	public int col;
	public int dir;
	public int value;
	
	public Point(){}
	
	public Point(int row,int col,int dir,int value){
		this.row = row;
		this.col = col;
		this.dir = dir;
		this.value = value;
	}
	
	public String toString(){
		return "(" + row + "," + col + "," + dir + "," + value + ")";
	}
}
