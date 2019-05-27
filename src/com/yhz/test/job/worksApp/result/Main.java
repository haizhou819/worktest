package com.yhz.test.job.worksApp.result;

import java.util.Scanner;
import java.util.Stack;


public class Main {
	int[] dx = {-1,1,0};
	int[] dy = {0,0,1};
	private static int n ,m;     
	static int grid[][] = null;  //路线方格
	static boolean flag[][] = null;//状态标识，false未访问过，true访问过
	Stack<Pos> stack = new Stack<Pos>();
	
	public static void main(String[] args) {
		Main m = new Main();
		m.initGrid();
		int result = -99999;  //记录最终结果
		for(int i=0;i<n;i++){
			if(grid[i][0] != -1){
				flag[i][0] = true;
				int tempRsult = m.findMax(i, 0);
				flag[i][0] = false;
				if(result < tempRsult){
					result = tempRsult;
				}
			}
		}
		System.out.println(result);
	}
	
	/*
     * 构造方格
     */
    public void initGrid(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        grid = new int[n][m]; 
        flag = new boolean[n][m];
        
        int temp = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                temp = scanner.nextInt();
                grid[i][j] = temp;
                flag[i][j] = false;
            }
        }
        scanner.close();
    }
    
    //非递归求法
    public int findMax(int i,int j){
    	stack.push(new Pos(i,j,0,grid[i][j]));
    	int res = -1;
    	while(!stack.empty()){
    		Pos pos = stack.peek();
    		if (3 == pos.dir){
    			flag[pos.row][pos.col] = false;
    			stack.pop();
    			continue;
    		}
    		int p = pos.row + dx[pos.dir];
    		int q = pos.col + dy[pos.dir];
    		pos.dir++;
    		
    		if (q == m){   //到达最右边记录结果，若没法到达最右边返回-1
    			res = max(res,pos.value);
    			continue;
    		}
    		if (p == -1){    //向上越界
    			if (grid[n-1][q] != -1 && flag[n-1][q] == false){
    				stack.push(new Pos(n-1,q,0,grid[n-1][q]));
    				flag[n-1][q] = true;
    			}
    			continue;
    		}
    		if (p == n){    //向下越界
    			if(grid[0][q] != -1 && flag[0][q] == false){
    				stack.push(new Pos(0,q,0,grid[0][q]));
    				flag[0][q] = true;
    			}
    			continue;
			}
    		if(grid[p][q] == -1 || flag[p][q] == true){  
				continue;
			}else {
				stack.push(new Pos(p,q,0,pos.value + grid[p][q]));
				flag[p][q] = true;
			}
   		}
    	return res;
    }
	
    public int max(int a,int b){
    	return a>b?a:b;
    }
}

class Pos{
	int row;    //点的横坐标
	int col;	//点的纵坐标
	int dir;  //点走向的方向标识（0:向上、1：向下、2：向右）
	int value;   //保存点走过路线所获得的分数
	
    public Pos(){
 
    }
    
    public Pos(int row, int col,int dir,int value){
    	this.row = row;
        this.col = col;
        this.dir = dir;
        this.value = value;
    }
 
    public String toString(){
        return "(" + row + " ," + col + ","+ dir +","+value+")";
    }
}
