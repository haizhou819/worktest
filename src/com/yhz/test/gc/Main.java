package com.yhz.test.gc;

public class Main {
	static{
		System.out.println("静态方法执行了");
	}
	public Main(){
		System.out.println("构造方法执行了");
	}
	
	public static void main(String[] args) {
	  System.out.println("111111111");
	  Main m = new Main();
    }
	{
		System.out.println("代码块执行了");
	}
}