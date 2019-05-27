package com.yhz.test.dataStructure.stack;

public class Reverse {
	public String doRev(String str){
		StringBuffer buffer=new StringBuffer();
		
		MyStack<Character> ms = new MyStack<Character>(20);
		//1：把字符串按照char一个一个读取出来
		char[] cs = str.toCharArray();
		for(char c : cs){
			//2：把这些字符依次压入栈中
			ms.push(c);
		}
		//3：依次从栈中弹出char，构成新的字符串
		while(!ms.isEmpty()){
			char c = (char)ms.pop();
			buffer.append(c);
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		Reverse t = new Reverse();
		String ret = t.doRev("this is 阿  test");
		System.out.println("ret==="+ret);
	}	
}
