package com.yhz.test.dataStructure.stack;

public class Calculate {
	public int calculate(String expr){
		char[] cs = expr.toCharArray();
		MyStack<Integer> stack = new MyStack<Integer>();
		for(int i=0;i<cs.length;i++){
			char c = cs[i];
			if(c >= '0' && c <= '9'){
				int num = (int)(c-'0');
				stack.push(num);
			}else{
				int num2 = stack.pop();
				int num1 = stack.pop();
				int num = 0;
				switch(c){
					case '+':
						num = num1 + num2;
						stack.push(num);
						break;
					case '-':
						num = num1 - num2;
						stack.push(num);
						break;
					case '*':
						num = num1 * num2;
						stack.push(num);
						break;
					case '/':
						num = num1 / num2;
						stack.push(num);
						break;
				}
			}
				
				
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		Calculate t = new Calculate();
		
		String str = new Mid2Post().doTransfer("(3+2)/5-((7+8)*4-5)");
		System.out.println(str);
		
		int ret=t.calculate(str);
		System.out.println("ret=="+ret);
	}
}
