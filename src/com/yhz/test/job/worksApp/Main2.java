package com.yhz.test.job.worksApp;

import java.util.Scanner;
import java.util.Stack;

/**
-1 4 5 1
2 -1 2 4
3 3 -1 3
4 2 1 2
 * 
 * @author sunny
 *
 */
public class Main2 {
	int[] dx = {-1,1,0};
	int[] dy = {0,0,1};
	private int row = 4;
	private int col = 4;
    int grid[][] = null;  //路线方格
    boolean flag[][] = null;//状态标识
	static int maxValue = 0;
	static int tempMaxValue = 0;
	Stack<Pos> stack = new Stack<Pos>();
	
	
	/*
     * 构造路线
     */
    public void initGrid(){
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        grid = new int[row][col]; 
        flag = new boolean[row][col];
        
        int temp = 0;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
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
    		
    		if (q == col){   //到达最右边记录结果，若没法到达最右边返回-1
    			res = max(res,pos.value);
    			continue;
    		}
    		if (p == -1){    //向上越界
    			if (grid[row-1][q] != -1 && flag[row-1][q] == false){
    				stack.push(new Pos(row-1,q,0,grid[row-1][q]));
    				flag[row-1][q] = true;
    			}
    			continue;
    		}
    		if (p == row){    //向下越界
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
    
    //递归求法
	public void dfs(int x,int y){
		for(int i=0;i<3;i++){
			int p = x + dx[i];
			int q = y + dy[i];
			
			if((p>-1&&p<row) && (q>-1&&q<col) && grid[p][q] != -1 && flag[p][q] == false){
				flag[p][q] = true;
				int temp = tempMaxValue;
				tempMaxValue += grid[p][q];
				if(maxValue < tempMaxValue){
					maxValue = tempMaxValue;
				}
				dfs(p,q);
				tempMaxValue = temp;
				flag[p][q] = false;
			}
			if(p == -1){
				p = row-1;
				if((q>-1&&q<col) && grid[p][q] != -1 && flag[p][q] == false){
					flag[p][q] = true;
					int temp = tempMaxValue;
					//tempMaxValue = 0;
					tempMaxValue = grid[p][q];
					if(maxValue < tempMaxValue){
						maxValue = tempMaxValue;
					}
					dfs(p,q);
					tempMaxValue = temp;
					flag[p][q] = false;
				}
			}
			if(p == row){
				p = 0;
				if((q>-1&&q<col) && grid[p][q] != -1 && flag[p][q] == false){
					flag[p][q] = true;
					int temp = tempMaxValue;
					//tempMaxValue = 0;
					tempMaxValue = grid[p][q];
					if(maxValue < tempMaxValue){
						maxValue = tempMaxValue;
					}
					dfs(p,q);
					tempMaxValue = temp;
					flag[p][q] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Main2 m = new Main2();
		m.initGrid();
		tempMaxValue = m.grid[3][0];
		
		m.flag[3][0] = true;
		m.dfs(3, 0);
		//int result = m.findMax(3, 0);
		
		System.out.println(maxValue);
	}
	
}

class Pos{
	int row;    //点的横坐标
	int col;	//点的纵坐标
	int dir;  //点走向的方向标识（0:上、1：下、2：右）
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
