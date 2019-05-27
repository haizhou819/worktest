package com.yhz.test.thread.pool.self;

public class TestTask extends Task{
	private   int i ;

    public TestTask(int i) {
        this.i = i;

    }

    public void run() {
        System.out.println("Hello world");
        System.out.println(i+"");
    }
}
