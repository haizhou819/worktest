package com.yhz.test.dataStructure.stack;

public class CheckBracket {
	public void check(String exp){
		MyStack<Character> stack = new MyStack<Character>();
		char[] cs = exp.toCharArray();
		for(int i=0;i<cs.length;i++){
			char c = cs[i];
			if(c=='{'||c=='['||c=='('){
				stack.push(c);
			}else if(c=='}'|| c==']'|| c==')'){
				if(!stack.isEmpty()){
					char cc = stack.pop();
					if((c == '}' && cc != '{') || (c == ']' && cc != '[') || 
							(c == '}' && cc != '{')){
						System.out.println("匹配不成功！");
						return;
					}
				}else{
					System.out.println("匹配不成功！");
					return;
				}
			}
		}
		if(!stack.isEmpty()){
			System.out.println("匹配不成功！");
		}else{
			System.out.println("匹配成功！");
		}
	}
	
	public static void main(String[] args) {
		CheckBracket t = new CheckBracket();
		t.check("(3+2)/5-[(7+8)*4-5]");
	}
}
