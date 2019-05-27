package com.yhz.test.dataStructure.stack;
/**
 * 中缀表达式转后缀表达式
 * @author sunny
 *
 */
public class Mid2Post {
	public String doTransfer(String str){
		StringBuffer sb = new StringBuffer();
		MyStack<Character> stack = new MyStack<Character>();
		char[] cs = str.toCharArray();
		for(int i=0;i<cs.length;i++){
			char c = cs[i];
			switch(c){
				case '+':
				case '-':
					doOperate(stack,sb,c,1);
					break;
				case '*':
				case '/':
					doOperate(stack,sb,c,2);
					break;
				case '(':
					stack.push(c);
					break;
				case ')':
					doOperate(stack,sb,c,3);
					break;
				default:
					sb.append(c);
			}
		}
		while(!stack.isEmpty()){
			sb.append((char)stack.pop());
		}
		return sb.toString();
	}
	
	public void doOperate(MyStack<Character> stack,StringBuffer buffer,char c,int level){
		if(c == ')'){
			while(!stack.isEmpty()){
				char topC = stack.pop();
				if(topC == '('){
					break;
				}else{
					buffer.append(topC);
				}
			}
		}else{
			while(!stack.isEmpty()){
				char topC = stack.pop();
				if(topC == '('){
					stack.push(topC);
					break;
				}else{
					int topLevel = 0;
					if(topC == '+' || topC == '-'){
						topLevel = 1;
					}else if(topC == '*' || topC == '/'){
						topLevel = 2;
					}
					if(level > topLevel){
						stack.push(topC);
						break;
					}else{
						buffer.append(topC);
					}
				}
			}
		}
		if(c == ')'){
			return;
		}else{
			stack.push(c);
		}
	}
	
	public static void main(String[] args) {
		Mid2Post t = new Mid2Post();
		String ret = t.doTransfer("(3+2)/5-((7+8)*4-5)");
		System.out.println("ret==="+ret);
	}
}
