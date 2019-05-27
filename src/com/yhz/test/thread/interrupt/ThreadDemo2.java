package com.yhz.test.thread.interrupt;

public class ThreadDemo2 {
	public static void main(String[] args) {
		Runnable r = new TestRunnable2();
		Thread t = new Thread(r);
		t.start();
		while(true){
			t.interrupt();
		}
	}
}

class TestRunnable2 implements Runnable{
	public void run(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}