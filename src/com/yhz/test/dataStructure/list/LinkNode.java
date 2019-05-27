package com.yhz.test.dataStructure.list;

public class LinkNode {
	public int value;
	public LinkNode next;
	
	public LinkNode(int value,LinkNode next){
		this.value = value;
		this.next = next;
	}
	public LinkNode(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public LinkNode getNext() {
		return next;
	}
	public void setNext(LinkNode next) {
		this.next = next;
	}
	
}
