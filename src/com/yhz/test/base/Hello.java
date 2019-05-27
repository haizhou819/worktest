package com.yhz.test.base;

import java.util.Stack;

public class Hello {
	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.t4();
		
		
	}
	
	public void t1(String str){
		StringBuilder sb = new StringBuilder(str);
		String s = sb.deleteCharAt(2).toString();
		
		System.out.println(s);
	}
	
	public void t2(){
		Stack<String> stack = new Stack<String>();
		stack.push("aa");
		stack.pop();
		stack.pop();
	}
	
	public void t3(){
		char c = '7';
		if(c >= '0' && c <= '9'){
			System.out.println((int)(c-'0'));
		}else{
			System.out.println("------");
		}
	}
	
	public void t4(){
		int i=0;
		
			while(true){
				System.out.println(i+"--");
				i++;
				if(i == 5){
					break;
				}
			}
	}
}
