package com.yhz.test.dataStructure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
/**
 * 栈的顺序存储结构实现
 * @author sunny
 *
 * @param <T>
 */
public class MyStack<T> {
	private int DEFAULT_SIZE = 10;
	private Object[] datas;
	private int topIndex = 0;
	private int capacity = 10;
	
	//默认数组长度创建空顺序栈
	public MyStack(){
		capacity = DEFAULT_SIZE;
		datas = new Object[capacity];
	}
	
	public MyStack(int len){
		datas = new Object[len];
	}
	
	//获取顺序栈的大小
	public int length(){
		return topIndex;
	}
	
	public void push(T data){
		ensureCapacity(topIndex);
		datas[topIndex++] = data;
	}
	
	private void ensureCapacity(int minCapacity){
		if(minCapacity >= capacity){
			capacity  = capacity*2;
			datas = Arrays.copyOf(datas, capacity);
		}
	}
	
	@SuppressWarnings("unchecked")
	public T pop(){
		T ret = null;
		if(topIndex != 0){
			ret =  (T)datas[topIndex-1];
			//释放栈顶元素
			datas[--topIndex] = null;
		}else{
			throw new EmptyStackException();
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public T peek(){
		return (T)datas[topIndex-1];
	}
	
	public boolean isEmpty(){
		return topIndex == 0;
	}
	
	public void clear(){
		Arrays.fill(datas, null);
		topIndex = 0;
	}
	
	public String toString(){
		if(topIndex == 0){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(int i=topIndex-1;i>=0;i--){
				sb.append(datas[i].toString()+", ");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();//删除最后的“， ”两个字符
		}
	}
	
	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<String>();
		stack.push("aa");
		stack.push("bb");
		stack.push("cc");
		stack.push("dd");
		stack.push("aa");
		stack.push("bb");
		stack.push("cc");
		stack.push("dd");
		
		System.out.println(stack);
		System.out.println(stack.capacity);
		System.out.println("访问栈顶元素："+stack.peek());
		System.out.println("第一次弹出栈顶元素："+stack.pop());
		System.out.println("第二次弹出栈顶元素："+stack.pop());
		System.out.println(stack);
		stack.clear();
		System.out.println(stack);
		
	}
}
