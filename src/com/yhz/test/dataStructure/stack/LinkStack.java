package com.yhz.test.dataStructure.stack;

public class LinkStack<T> {
	private Node top;
	private int size;
	
	public LinkStack(){
		top = null;
	}
	
	public int length(){
		return size;
	}
	
	public void push(T data){
		//让top指向新创建的元素，新元素的next引用指向原来的栈顶元素
		Node newNext = top;
		top = new Node(data,newNext);
		size++;
	}
	
	public T pop(){
		Node oldTop = top;
		top = top.next;
		//释放原栈顶元素的next引用
		oldTop.next = null;
		size--;
		return oldTop.data;
	}
	
	public T peek(){
		return top.data;
	}
	
	public boolean empty(){
		return size == 0;
	}
	
	public void clear(){
		top = null;
		size = 0;
	}
	
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(Node current = top;current != null;current = current.next){
				sb.append(current.data.toString()+", ");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
	
	public static void main(String[] args) {
		LinkStack<String> stack = new LinkStack<String>();
		stack.push("aa");
		stack.push("bb");
		stack.push("cc");
		stack.push("dd");
		stack.push("ee");
		System.out.println(stack);
		System.out.println("访问栈顶元素："+stack.peek());
		System.out.println("第一次弹出栈顶元素："+stack.pop());
		System.out.println("第二次弹出栈顶元素："+stack.pop());
		System.out.println("两次pop之后的栈"+stack);
	}
	
	
	private class Node{
		private T data;
		private Node next;
		
		@SuppressWarnings("unused")
		public Node(){}
		
		public Node(T data,Node next){
			this.data = data;
			this.next = next;
		}
	}
}
