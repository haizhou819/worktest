package com.yhz.test.hello;

public class Hello {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Hello h = new Hello();
		Class c = h.getClass();
		System.out.println(c);
		ClassLoader loader = c.getClassLoader();
		System.out.println(loader);
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());
		
		/*
		ClassLoader loader = Hello.class.getClassLoader();
		System.out.println(loader);
		
		//使用Class.forName()来加载类，默认会执行初始化块 
		Class c = Class.forName("com.yhz.test.hello.TestHello");
		TestHello th = (TestHello)c.newInstance();
		th.m();
		
		//使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块 
		//Class.forName("com.yhz.test.hello.TestHello",false,loader);
		
		//使用ClassLoader.loadClass()来加载类，不会执行初始化块 
		//loader.loadClass("com.yhz.test.hello.TestHello");
*/	}
}
//对于任意一个类，都需要由加载它的类加载器和这个类本身一同确立其在java虚拟机的唯一性。

