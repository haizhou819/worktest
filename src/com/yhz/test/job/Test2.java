package com.yhz.test.job;

public class Test2 {
	public static  int test(String str){
		char[] cs = str.toCharArray();
		int minAdd = 0;
		for(int i=0;i<cs.length-1;i++){
			for(int j=i+1;j<cs.length;j++){
				if(cs[i] != cs[j]){
					minAdd = i;
					if(j == cs.length-1){
						return minAdd;
					}
				}else{
					minAdd = i+1;
					break;
				}
			}
		}
		return minAdd;
	}
	
	public static void main(String[] args) {
		String str = "kabciedkiadd";
		int resultAdd = test(str);
		char[] cs = str.toCharArray();
		int re = cs[resultAdd];
		System.out.println(re);
	}
}
