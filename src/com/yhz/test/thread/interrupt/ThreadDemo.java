package com.yhz.test.thread.interrupt;

public class ThreadDemo {
	public static void main(String[] args) {
		Runnable r = new TestRunnable();
		Thread t1 = new Thread(r);
		t1.start();
		//给处在运行状态的线程的中断状态位置位，此时线程调用isInterrupted（）为true，正在运行的线程不一定会中断
		//若线程处于阻塞状态如sleep、wait、join时，不能给该线程中断状态位置位，否则报interruptedException
		t1.interrupt(); 
	}
}

class TestRunnable implements Runnable{
	public void run(){
		while(true){
			System.out.println("Thread is running.....");
			long time  = System.currentTimeMillis();
			while(System.currentTimeMillis()-time <1000){
				//程序循环1秒，不同于sleep（1000）会阻塞线程
			}
			/*if(Thread.currentThread().isInterrupted()){
				break;
			}*/
		}
	}
}