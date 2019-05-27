package com.yhz.test.base;

import java.io.UnsupportedEncodingException;


/**
 * 濞村鐦崶鐐舵簠娑撳孩宕茬悰锟� * @author sunny
 *
 */
public class TestHello {
	private static int flag = 5;
	
	static{
		System.out.println("静态变量="+flag);
		System.out.println("静态初始化块");
	}
	public TestHello(){
		System.out.println("构造函数块");
	}
	{
		System.out.println("非静态初始化块");
	}
	public static void main(String[] args) {
		new TestHello();
		String s = "你好";
		try {
			byte[] b = s.getBytes("gbk");
			byte[] b2 = s.getBytes("utf-8");
			System.out.println(b.length+"---"+b2.length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String a = "abc-abs";
		System.out.println(a.replace("-", "")+"------------");
	}
}
