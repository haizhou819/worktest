package com.yhz.test.reflection.invoke;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestInvoke {
	public String name = "yhz";
	public String job = "IT";
	Integer a = 1024;
	
	public void work(){
		System.out.println("-----------work1");
	} 
	public  TestInvoke work(String a,Integer b){
		System.out.println(a + b+"-------work2");
		return this;
	}
	public void work(Integer b, int c ){
		System.out.println(b + c+"-----work3");
	}
	
	public void m(){
		System.out.println("hello world!");
	}
	
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> clazz = TestInvoke.class;
		//Class<?> clazz = Class.forName("invoke.testInvoke");
		//testInvoke tinvoke = new testInvoke(); Class<?> clazz = tinvoke.getClass(); 
		System.out.println(clazz);
		//如果源类的方法没有参数，则要用new Class[]{}
		Method method1 = clazz.getMethod("work", new Class[]{});
		Method method2 = clazz.getMethod("work", new Class[]{String.class, Integer.class}); 
		Method method3 = clazz.getMethod("work", new Class[]{Integer.class, int.class});
		Object invokeTest = clazz.newInstance();
		
		TestInvoke invokeTest1 = (TestInvoke)clazz.newInstance();
		invokeTest1.m();
		
		
		/*
		 *  Method类的invoke(Object obj,Object args[])方法接收的参数必须为对象，<br/>
		 *  如果参数为基本类型数据，必须转换为相应的包装类型的对象。invoke()方法的返回值总是对象，<br/>
		 *  如果实际被调用的方法的返回类型是基本类型数据，那么invoke()方法会把它转换为相应的包装类型的对象，再将其返回<br/>
		 */
		//invoke方法的第一个参数是源类的实例，第二个参数是实例的值
		Object result1 = method1.invoke(invokeTest, new Object[]{});
		Object result2 = method2.invoke(invokeTest, new Object[]{"aaaa",new Integer(10)});
		Object result3 = method3.invoke(invokeTest, new Object[]{3,new Integer(4)});
		System.out.println(result1+"=======work1 return");
		System.out.println(result2+"++++++++work2 return");
		System.out.println(result3+"******work3 return");

		Method[] methods = clazz.getMethods();
		System.out.println("methods个数-------"+methods.length);
		for(Method method : methods){
			System.out.println(method.getName()+"------aaaaa");
		}
		
		//获取访问权限为public的属性
		Field[] fileds = clazz.getFields();
		System.out.println("public fields个数-----"+fileds.length);
		for(Field filed: fileds){
			System.out.println(filed.getName()+"---"+filed.getType()+"----值"+filed.get(invokeTest));
		}
	}
}
