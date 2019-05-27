package com.yhz.test.base;

/**
 * 运行时（动态）绑定针对的范畴只是对象的方法，不针对属性。
 * @author sunny
 *
 */
public class Son extends Father{
	protected String name = "son";
	
	public void t(){
		System.out.println("子类的方法");
	}
	
	public Son(String name){
		super(name);
		this.name = name;
		System.out.println("子类构造器");
	}
	
	public static void main(String[] args) {
		Father f = new Son("tom");
		//此处调用的是子类的t方法
		f.t();
		//此处调用的仍然是父类的属性
		System.out.println(f.name);
		
	}
}
