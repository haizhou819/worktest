package com.yhz.test.thread.forkjoin;


import java.util.concurrent.RecursiveTask;


public class Calculator extends RecursiveTask<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 100;  
    private int start;  
    private int end;  
  
    public Calculator(int start, int end) {  
        this.start = start;  
        this.end = end;  
    }  
  
    @Override  
    protected Integer compute() {  
        int sum = 0;  
        if((end - start) <= THRESHOLD){  
            for(int i = start; i<= end;i++){  
                sum += i;  
            }  
            //System.out.println(sum);
        }else{  
            int middle = (start + end) /2;  
            Calculator left = new Calculator(start, middle);  
            Calculator right = new Calculator(middle + 1, end);  
            left.fork();  
            right.fork();  
            
            int num1 = left.join();
            int num2 = right.join();
  
            System.out.println(num1+"------"+num2);
            sum = num1 + num2;  
        }  
        return sum;  
    }  
    
}
