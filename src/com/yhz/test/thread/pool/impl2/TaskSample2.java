package com.yhz.test.thread.pool.impl2;

public class TaskSample2 extends Task{
	public void run() {
        System.out.println("不见兔子，不撒鹰！");
    }
	
	public String getInfo(){
		return "打猎";
	}
}
