package com.yhz.test.base;
/**
 * 判断对象是否是某个类的实例
 * @author sunny
 *
 */
public class TestInstanceOf {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		//System.out.println(a instanceof B); //结果为false
		//System.out.println(a instanceof A); //结果为true
		System.out.println(b instanceof A); //结果为true
		//有时候这个类是继承于一个父类的，所以，不能严格判断出是不是自己的类，
		//而不是自己的父类,可以根据下面的方法加以判断
		System.out.println(a.getClass().equals(A.class)); //true
		System.out.println(a.getClass().equals(B.class));//false
		System.out.println(b.getClass().equals(A.class));//false
	}
}

class A{
	
}

class B extends A{
	
}