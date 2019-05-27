package com.yhz.test.thread.pool.impl2;

public class TaskSample extends Task{
	private   int i ;

    public TaskSample(int i) {
        this.i = i;

    }

    public void run() {
        System.out.println("Hello world"+"---"+i);
    }
    
    public String getInfo(){
    	return "taskId="+i;
    }
}
