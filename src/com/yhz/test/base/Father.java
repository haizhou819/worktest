package com.yhz.test.base;

public class Father {
	protected String name = "father";
	
	public Father(String name){
		this.name = name;
		System.out.println("father构造器");
	}
	
	public void t(){
		System.out.println("父类的方法");
	}
}
