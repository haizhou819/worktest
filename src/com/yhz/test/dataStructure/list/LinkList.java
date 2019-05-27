package com.yhz.test.dataStructure.list;

public class LinkList {
	private LinkNode head;//头结点
	private LinkNode tail;//尾结点
	private int size = 0;//链表长度
	
	//插入节点(尾插法)
	public  void insert(int data){
		LinkNode newNode = new LinkNode(data);
		if(head == null){
			head = newNode;
			tail = newNode;
			size++;
		}else{
			tail.setNext(newNode);
			/*LinkNode tempNode = head;
			while(tempNode.getNext() != null){
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(newNode);*/
			tail = newNode;
			size++;
		}
	}
	//删除指定值的节点
	public boolean delete(int data){
		if(head == null){
			System.out.println("链表为空！");
			return false;
		}else{
			LinkNode tempNode = head;
			LinkNode parent = head;
			while(tempNode != null && tempNode.getValue() != data){
				parent = tempNode;
				tempNode = tempNode.getNext();
			}
			if(tempNode == null){
				System.out.println("没有找到要删除的数据！");
				return false;
			}else{
				if(tail.getValue() == data){
					tail = parent;  //如果删除的是链表的最后一位，tail引用前移一位
				}
				parent.setNext(tempNode.getNext());
				size--;
				return true;
			}
		}
	}
	
	//删除指定索引的节点
	public boolean deleteByIndex(int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		LinkNode tempNode = head;
		LinkNode parent = head;
		for(int i=0;i<size;i++){
			if(tempNode != null && i == index){
				if(index == size-1){
					tail = parent;//如果删除的是链表的最后一位，tail引用前移一位
				}
				parent.setNext(tempNode.getNext());
				size--;
				return true;
			}else{
				parent = tempNode;
				tempNode = tempNode.getNext();
			}
		}
		return false;
	}
	
	public LinkNode getNodeByIndex(int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		LinkNode tempNode = head;
		for(int i=0;i<size;i++){
			if(tempNode != null && i == index){
				return tempNode;
			}else{
				tempNode = tempNode.getNext();
			}
		}
		return tempNode;
	}
	
	public void print(LinkNode node){
		if(node == null){
			return;
		}else{
			while(node != null){
				System.out.println(node.value);
				node = node.getNext();
			}
		}
	}
	
	public int length(){//返回链表长度
		return size;
	}
	
	public String toString(){
		if(head == null){
			return "[]";
		}else{
			StringBuilder sb = new StringBuilder();
			LinkNode tempNode = head;
			sb.append("[");
			while(tempNode != null){
				if(tempNode.getNext() == null){
					sb.append(tempNode.value);
				}else{
					sb.append(tempNode.value+", ");
				}
				
				tempNode = tempNode.getNext();
			}
			sb.append("]");
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		LinkList list = new LinkList();
		int[] arr = {7,9,2,6,48,21,5};
		for(int i=0;i<arr.length;i++){
			list.insert(arr[i]);
		}
		list.print(list.head);
		System.out.println(list.size+"****");
		list.deleteByIndex(6);
		System.out.println("---------------------");
		list.print(list.head);
		System.out.println(list.size+"****");
		System.out.println(list.tail.getValue());
		System.out.println(list.getNodeByIndex(0).getValue()+"根据索引获取");
		System.out.println(list);
	}
}
