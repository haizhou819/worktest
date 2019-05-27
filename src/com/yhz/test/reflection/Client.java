package com.yhz.test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Client {
	public static void main(String[] args) {
		MyClass myClass = new MyClass(0); //一般做法
		myClass.increase(2);
		System.out.println("Normal -> " + myClass.count);
		System.out.println("--------------------------");
		try {
		    Constructor<MyClass> constructor = MyClass.class.getConstructor(int.class); //获取构造方法
		    MyClass myClassReflect = (MyClass)constructor.newInstance(0); //创建对象
		    Method method = MyClass.class.getMethod("increase", int.class);  //获取方法
		    method.invoke(myClassReflect, 2); //调用方法
		    Field field = MyClass.class.getField("count"); //获取域
		    System.out.println("Reflect -> " + field.getInt(myClassReflect)); //获取域的值
		} catch (Exception e) { 
		    e.printStackTrace();
		} 
	}
}

class MyClass {
    public int count;
    public MyClass(int start) {
        count = start;
    }
    public void increase(int step) {
        count = count + step;
    }
} 