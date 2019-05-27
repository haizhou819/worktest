package com.yhz.test.dataStructure;

public class PostInfix {
	private MyStack stack;
	private StringBuffer buffer = new StringBuffer();
	
	public PostInfix(MyStack stack){
		this.stack = stack;
	}

	public String doTansfer(String str){
		//1：把字符串转换成为字符数组
		char[] cs = str.toCharArray();
		//2：对每个字符进行判读并执行相应的操作
		for(int i=0;i<cs.length;i++){
			char c = cs[i];
			switch(c){
			//2.1：如果是操作符(+、-、*、\)，就要分级别操作
			case '+':
			case '-':
				doOperate(c,1);
				break;
			case '*':
			case '/':
				doOperate(c,2);
				break;
			//2.2：如果是左括号，压栈
			case '(':
				stack.push(c);
				break;
			//2.3：如果是右括号，弹栈到输出中，直到遇到（未知
			case ')':
				doRightBracket(c);
				break;
			//2.4：如果是操作数，直接加入到输出
			default :
				buffer.append(c);
				break;
			}
		}
		//3：把栈中的操作符依次弹出到输出中
		while(!stack.isEmpty()){
			buffer.append((char)stack.pop());
		}
		return buffer.toString();
	}
	
	public void doOperate(char c,int level){
		//1：依次从栈顶获取一个值
		while(!stack.isEmpty()){
			char topC = (char)stack.pop();
			//2：用这个值跟传入的数据进行比较
			//2.1：如果栈顶的数据是（，不动，就是把它压回来
			if(topC=='('){
				stack.push(topC);
				break;
			}else{
				int topLevel = 0;
				//首先获取到栈顶元素所对应的优先级别
				if(topC=='+'||topC=='-'){
					topLevel = 1;
				}else{
					topLevel = 2;
				}
				if(level>topLevel){
					//2.2：如果栈顶的数据优先级小于传入的数据级别，不动
					stack.push(topC);
					break;
				}else{
					//2.3：如果栈顶的数据的优先级别大于等于传入的数据级别，那么就要输出
					buffer.append(topC);
				}
			}
		}
		//3：找到位置后，把传入的操作符压入
		stack.push(c);
	}
	
	public void doRightBracket(char c){
		//1：从栈中弹出数据，输出到后缀表达式中
		while(!stack.isEmpty()){
			char topC = (char)stack.pop();
			//2：直到遇到"("为止
			if(topC=='('){
				break;
			}else{
				buffer.append(topC);
			}
		}
	}
	
	public int calculate(String str){
		MyStack stack1 = new MyStack(20);
		char[] cs = str.toCharArray();
		int temp = 0;
		for(int i=0;i<cs.length;i++){
			if(cs[i]>='0' && cs[i]<='9'){
				stack1.push(cs[i]-'0');
			}else{
				int num2 = stack1.pop();
				int num1 = stack1.pop();
				switch(cs[i]){
				case '+':
					temp=num1+num2;
					stack1.push(temp);
					break;
				case '-':
					temp=num1-num2;
					stack1.push(temp);
					break;
				case '*':
					temp=num1*num2;
					stack1.push(temp);
					break;
				case '/':
					temp = num1/num2;
					stack1.push(temp);
					break;
				}
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack(20);
		PostInfix pif = new PostInfix(stack);
		String str = "(3+2)/5-((7+8)*4-5)";
		//String str = "(3+2)/5+((7+8)*4-5)";
		String ret = pif.doTansfer(str);//32+5/78+4*5--
		System.out.println("ret=="+ret);
		int result = pif.calculate(ret);
		System.out.println(result);
	}
	
}
