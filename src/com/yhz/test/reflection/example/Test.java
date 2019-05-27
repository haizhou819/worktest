package com.yhz.test.reflection.example;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		HelloWorldImpl helloWorld=new HelloWorldImpl();
        HelloWorldProxy handler=new HelloWorldProxy(helloWorld);
        
        //创建动态代理对象
        HelloWorld proxy=(HelloWorld)Proxy.newProxyInstance(
                helloWorld.getClass().getClassLoader(), 
                helloWorld.getClass().getInterfaces(), 
                handler);
        proxy.sayHelloWorld();
    }
}
