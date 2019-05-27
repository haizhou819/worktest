package com.yhz.test.dataStructure.queue;

public class LinkQueue<T> {
	private Node front,rear;
	private int size = 0;
	
	public LinkQueue(){
		front = null;
		rear = null;
	}
	
	public int length(){
		return size;
	}
	
	public void add(T data){
		Node newNode = new Node(data);
		if(front == null){
			front = newNode;
			rear = front;
		}else{
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
	
	public T peek(){
		return rear.data;
	}
	
	public T remove(){
		Node ret = front;
		front = front.next;
		ret.next = null;
		size--;
		return ret.data;
	}
	
	public String toString(){
		if(size == 0){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder("[");
			for(Node current = front;current != null;current = current.next){
				sb.append(current.data + ", ");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
	
	private class Node{
		private T data;
		private Node next;
		
		public Node(T data){
			this.data = data;
			this.next = null;
		}
	} 
	
	public static void main(String[] args) {
		LinkQueue<String> queue = new LinkQueue<String>();
		queue.add("a");
		queue.add("b");
		queue.add("c");
	
		System.out.println(queue);
		queue.remove();
		System.out.println("删除一个元素后的队列：" + queue);
		queue.add("d");
		queue.add("e");
		System.out.println("添加两个元素后的队列：" + queue);
	}
}
