package com.yhz.test.dataStructure.list.doubleList;

public class DoubleLinkList<T> {
	private LinkNode<T> head;
	private LinkNode<T> tail;
	private int size;
	
	public int length(){
		return size;
	}
	
	//尾插法
	public void insert(T data){
		LinkNode<T> newNode = new LinkNode<T>(data);
		if(head == null){
			head = newNode;
			tail = newNode;
			size++;
		}else{
			tail.setNext(newNode);
			newNode.setPre(tail);
			tail = newNode;
			size++;
		}
	}
	
	@SuppressWarnings("unused")
	public boolean delete(T data){
		if(head == null){
			return false;
		}else{
			LinkNode<T> tempNode = head;
			while(tempNode != null){
				if(tempNode.getValue() == data){
					tempNode.getPre().setNext(tempNode.getNext());
					if(tempNode == tail){
						tail = tempNode.getPre();
						size--;
						return true;
					}else{
						tempNode.getNext().setPre(tempNode.getPre());
						tail = tempNode.getPre();
						size--;
						return true;
					}
				}else{
					tempNode = tempNode.getNext();
				}
			}
			if(tempNode == null){
				System.out.println("链表中没有待删除的数据！");
				return false;
			}
		}
		return false;
	}
	
	public boolean deleteByIndex(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("链表索引越界！");
		}
		if(head == null){
			System.out.println("链表为空!");
			return false;
		}else{
			LinkNode<T> tempNode = head;
			for(int i=0;i<size;i++){
				if(tempNode != null && i == index){
					tempNode.getPre().setNext(tempNode.getNext());
					if(tempNode == tail){
						tail = tempNode.getPre();
						size--;
						return true;
					}else{
						tempNode.getNext().setPre(tempNode.getPre());
						tail = tempNode.getPre();
						size--;
						return true;
					}
				}else{
					tempNode = tempNode.getNext();
				}
			}
		}
		return false;
	}
	
	public String toString(){
		if(head == null){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder();
			LinkNode<T> tempNode = head;
			sb.append("[");
			while(tempNode != null){
				if(tempNode.getNext() == null){
					sb.append(tempNode.getValue());
				}else{
					sb.append(tempNode.getValue()+", ");
				}
				
				tempNode = tempNode.getNext();
			}
			sb.append("]");
			return sb.toString();
		}
	}
	
	public LinkNode<T> getNodeByIndex(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("链表索引越界！");
		}
		LinkNode<T> tempNode = head;
		if(tempNode == null){
			System.out.println("链表为空!");
			return null;
		}else{
			for(int i=0;i<size;i++){
				if(tempNode != null && i == index){
					return tempNode;
				}else{
					tempNode = tempNode.getNext();
				}
			}
		}
		return tempNode;
	}
	
	public static void main(String[] args) {
		DoubleLinkList<Integer> list = new DoubleLinkList<Integer>();
		int[] arr = {7,9,2,6,48,21,5};
		for(int i=0;i<arr.length;i++){
			list.insert(arr[i]);
		}
		System.out.println(list);
		//list.print(list.head);
		System.out.println(list.size+"****");
		list.delete(5);
		//list.deleteByIndex(6);
		System.out.println("---------------------");
		//list.print(list.head);
		System.out.println(list.size+"****");
		System.out.println(list.tail.getValue());
		System.out.println(list.getNodeByIndex(6).getValue()+"根据索引获取");
		System.out.println(list);
	}
	
}
