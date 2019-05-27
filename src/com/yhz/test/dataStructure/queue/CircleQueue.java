package com.yhz.test.dataStructure.queue;

import java.util.Arrays;

/**
 * 顺序存储结构的循环队列
 * @author sunny
 *
 */
public class CircleQueue<T> {
	private final int DEFAULT_SIZE = 10;
	private int capacity;
	private Object[] datas;
	private int front = 0,rear = 0;
	
	public CircleQueue(){
		capacity = DEFAULT_SIZE;
		datas = new Object[capacity];
	}
	
	public CircleQueue(int length){
		capacity = length;
		datas = new Object[capacity];
	}
	
	public int length(){
		if(isEmpty()){
			return 0;
		}
		return rear > front ? rear - front : capacity - (front - rear);
	}
	
	public boolean isEmpty(){
		if(front == rear && datas[front] == null){
			return true;
		}else{
			return false;
		}
	}
	
	public void add(T data){
		if(front == rear && datas[front] != null){
			throw new IndexOutOfBoundsException("队列满异常！");
		}
		datas[rear++] = data;
		if(rear == capacity){
			rear = 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T peek(){
		if(isEmpty()){
			throw new IndexOutOfBoundsException("空队列异常！");
		}
		return (T)datas[front];
	}
	
	@SuppressWarnings("unchecked")
	public T remove(){
		/**
		 * 如果直接这样写return datas[front++];
		 * 比如front值是2；执行datas[front++]后front值变为3
		 * 但是datas[2]的引用的对象所占据的空间还是存在的，但是datas[2]这个引用
		 * 我们确用不到，造成内存泄露。
		 */
		if(isEmpty()){
			throw new IndexOutOfBoundsException("空队列异常！");
		}
		T ret = (T)datas[front];
		//释放队列front端的元素
		datas[front++] = null;
		if(front == capacity){
			front = 0;
		}
		return ret;
	}
	
	public void clear(){
		Arrays.fill(datas, null);
		front = 0;
		rear = 0;
	}
	
	public String toString(){
		if(isEmpty()){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			if(rear > front ){
				for(int i=front;i<rear;i++){
					sb.append(datas[i].toString() + ", ");
				}
			}else{
				for(int i=front;i<capacity;i++){
					sb.append(datas[i].toString() + ", ");
				}
				for(int i=0;i<rear;i++){
					sb.append(datas[i].toString() + ", ");
				}
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
	
	public static void main(String[] args) {
		CircleQueue<String> queue = new CircleQueue<String>();
		queue.add("aa");
		queue.add("bb");
		queue.add("cc");
		queue.add("dd");
		System.out.println(queue);
		System.out.println(queue.length());
		
		for(int i=0;i<4;i++){
			queue.remove();
		};
		System.out.println(queue);
		
		queue.add("aa");
		queue.add("bb");
		queue.add("cc");
		queue.add("dd");
		queue.add("ee");
		queue.add("ff");
		queue.add("gg");
		queue.add("hh");
		System.out.println(queue);
		System.out.println("访问队列的front端元素："+queue.peek());
		System.out.println("移除队列的front端元素："+queue.remove());
		System.out.println("移除队列的front端元素："+queue.remove());
		System.out.println("两次调用remove方法后的队列："+queue);
		System.out.println(queue.length());
		queue.clear();
		System.out.println("调用clear方法后的队列："+queue);
		System.out.println(queue.length());
	}
}
