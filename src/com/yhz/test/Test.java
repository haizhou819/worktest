package com.yhz.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Test {
	public static void main(String[] args) throws ParseException {
		String yxq = "20150731";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDD");
		Date date = sdf.parse(yxq);
		Date now = new Date();
		boolean flag = date.before(now);
		System.out.println(flag);
		
		/*int[] a = {65,23,81,7,9,4,0,0};
		Arrays.sort(a);
		System.out.println(a[a.length-1]);*/
	}
	
}
