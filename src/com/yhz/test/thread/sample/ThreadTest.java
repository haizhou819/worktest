package com.yhz.test.thread.sample;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		A a = new A();
		B b = new B();
		C c = new C();
		
		a.start();
		//a.join();
		b.start();
		b.join();
		c.start();
		
		StringBuffer buffer = new StringBuffer("hello");
		StringBuffer s = new StringBuffer("haha");
		s.append(buffer);
		String str = s+" "+"world";
		System.out.println(str);
	}
}

class A extends Thread{

	@Override
	public void run() {
		System.out.println("run thread A");
	}
	
}

class B extends Thread{

	@Override
	public void run() {
		System.out.println("run thread B");
	}
	
}

class C extends Thread{

	@Override
	public void run() {
		System.out.println("run thread C");
	}
	
}