package com.yhz.test.jvm;

public class BigObj2Old {
	public static void main(String[] args) {
		 @SuppressWarnings("unused")
		byte[] b;
		 b = new byte[1024*1024];//分配一个 1MB 的对象
	}
}	
