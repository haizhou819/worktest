package com.yhz.test.dataStructure.queue;

import java.util.Arrays;

/**
 * 队列的顺序存储结构的实现
 * @author sunny
 *
 * @param <T>
 */
public class MyQueue<T> {
	private int DEFAULT_SIZE = 10;
	private int capacity;
	private Object[] datas;
	private int front = 0;
	private int rear = 0;
	
	public MyQueue(){//构造函数
		capacity = DEFAULT_SIZE;
		datas = new Object[capacity];
	}
	
	public int length(){//获取顺序队列的大小
		return rear - front;
	} 
	
	public void add(T data){//插入队列
		//ensureCapacity(rear);
		if(rear > capacity-1){
			throw new IndexOutOfBoundsException("队列长度越界异常!");
		}
		datas[rear++] = data;
	}
	
	public void ensureCapacity(int minCapacity){
		if(minCapacity >= datas.length){
			capacity = capacity * 2;
			datas = Arrays.copyOf(datas, capacity);
		}
	}
	
	@SuppressWarnings("unchecked")
	public T remove(){//移除队列
		T ret = (T)datas[front];
		//释放队列front端的元素
		datas[front++] = null;
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public T peek(){//返回队列顶元素，但不删除该元素
		return (T)datas[front];
	}
	
	public boolean empty(){//判断队列是否为空
		return front == rear;
	}
	
	public void clear(){//清空队列
		Arrays.fill(datas, null);
		front = 0;
		rear = 0;
	}
	
	public String toString(){
		if(empty()){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(int i=front;i<rear;i++){
				sb.append(datas[i].toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
	
	public static void main(String[] args) {
		MyQueue<String> queue = new MyQueue<String>();
		queue.add("aa");
		queue.add("bb");
		queue.add("cc");
		queue.add("dd");
		queue.add("aa");
		queue.add("bb");
		queue.add("cc");
		queue.add("dd");
		System.out.println(queue);
		System.out.println("访问队列的front端元素："+queue.peek());
		System.out.println("移除队列的front端元素："+queue.remove());
		System.out.println("移除队列的front端元素："+queue.remove());
		System.out.println("两次调用remove方法后的队列："+queue);
		queue.clear();
		System.out.println("调用clear方法后的队列："+queue);
		System.out.println(queue.datas.length);
	}
}
