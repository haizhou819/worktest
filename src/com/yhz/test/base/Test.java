package com.yhz.test.base;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("ha", "");
		if(map == null || ((String)map.get("ha")).equals("ha")){
			System.out.println("hahhahahha");
		}
		System.out.println(((String)map.get("ha")).equals("1"));
	}
}
