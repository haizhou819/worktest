package com.yhz.test.dataStructure.list.doubleList;

public class LinkNode<T> {
	private T value;
	private LinkNode<T> pre;
	private LinkNode<T> next;
	
	public LinkNode(T value){
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public LinkNode<T> getPre() {
		return pre;
	}
	public void setPre(LinkNode<T> pre) {
		this.pre = pre;
	}
	public LinkNode<T> getNext() {
		return next;
	}
	public void setNext(LinkNode<T> next) {
		this.next = next;
	}
	
}
