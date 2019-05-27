package com.yhz.test.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BSTree {
	private TreeNode root;
	
	public void insert(int data){
		TreeNode newNode = new TreeNode(data);
		if(root == null){
			root = newNode;
		}else{
			TreeNode tempNode = root;
			TreeNode parent = root;
			boolean isLeft = true;
			while(tempNode != null){
				parent = tempNode;
				if(tempNode.getData() > data){
					tempNode = tempNode.getLeft();
					isLeft = true;
				}else{
					tempNode = tempNode.getRight();
					isLeft = false;
				}
			}
			if(isLeft){
				parent.setLeft(newNode);
			}else{
				parent.setRight(newNode);
			}
		}
	}
	
	public boolean delete(int data){
		if(root == null){
			System.out.println("空树，无法找到要删除数据："+data);
			return false;
		}
		//找到待删除的节点
		TreeNode tempNode = root;
		TreeNode parent = root;
		boolean isLeft = true;
		while (tempNode.getData() != data) {
			parent = tempNode;
			if(tempNode.getData() > data){
				tempNode = tempNode.getLeft();
				isLeft = true;
			}else if(tempNode.getData() < data){
				tempNode = tempNode.getRight();
				isLeft = false;
			}
			if(tempNode == null){
				System.out.println("树中没有待删除的数据！");
				return false;
			}
		}
		//没有子节点
		if (tempNode.getLeft() == null && tempNode.getRight() == null) {
			noChildDel(parent, tempNode, isLeft);
		}
		//只有一个子节点---左子节点
		else if (tempNode.getRight() == null) {
			oneLeftChildDel(parent, tempNode, isLeft);
		}
		//只有一个子节点---右子节点
		else if (tempNode.getLeft() == null) {
			oneRightChildDel(parent, tempNode, isLeft);
		}
		//有两个子节点
		else{
			doubleChildDel(tempNode, tempNode, isLeft);
		}
		return true;
	}
	
	public void noChildDel(TreeNode parent,TreeNode delNode,boolean isLeft){
		if(delNode == root){
			root = null;
		}
		if (isLeft) {
			parent.setLeft(null);
		}else {
			parent.setRight(null);
		}
	}
	
	public void oneLeftChildDel(TreeNode parent,TreeNode delNode,boolean isLeft){
		if (delNode == root) {
			root = delNode.getLeft();
		}
		if (isLeft) {
			parent.setLeft(delNode.getLeft());
		}else {
			parent.setRight(delNode.getLeft());
		}
	}
	
	public void oneRightChildDel(TreeNode parent,TreeNode delNode,boolean isLeft) {
		if (delNode == root) {
			root = delNode.getRight();
		}
		if (isLeft) {
			parent.setLeft(delNode.getRight());
		}else {
			parent.setRight(delNode.getRight());
		}
	}
	
	public void doubleChildDel(TreeNode parent,TreeNode delNode,boolean isLeft) {
		TreeNode successNode = findSuccessor(delNode);
		if (delNode == root) {
			root = successNode;
		}
		if (isLeft) {
			parent.setLeft(successNode);
		}else {
			parent.setRight(successNode);
		}
		successNode.setLeft(delNode.getLeft());
	}
	
	public TreeNode findSuccessor(TreeNode delNode){
		TreeNode tempNode = delNode.getRight();
		TreeNode parentNode = delNode;
		TreeNode successorNode = delNode;
		
		while (tempNode != null) {
			parentNode = successorNode;
			successorNode = tempNode;
			tempNode = tempNode.getLeft();
		}
		//当后继节点不是被删除节点的右节点且后继节点右节点不空的情况
		if (successorNode != delNode.getRight()) {
			parentNode.setLeft(successorNode.getRight());
			successorNode.setRight(delNode.getRight());
		}
		return successorNode;
	}
	
	public TreeNode find(int data){
		TreeNode tempNode = root;
		while(tempNode != null){
			if(tempNode.getData() > data){
				tempNode = tempNode.getLeft();
			}else if(tempNode.getData() < data){
				tempNode = tempNode.getRight();
			}else{
				return tempNode;
			}
		}
		return tempNode;
	}
	
	//递归中序遍历
	public void midSearch(TreeNode node){
		if(node != null){
			midSearch(node.getLeft());
			System.out.print(node.getData() + " ");
			midSearch(node.getRight());
		}
	}
	
	//递归前序遍历
	public void preSearch(TreeNode node){
		if(node != null){
			System.out.print(node.getData() + " ");
			preSearch(node.getLeft());
			preSearch(node.getRight());
		}
	}
	
	//递归后序遍历
	public void postSearch(TreeNode node) {
		if (node != null) {
			postSearch(node.getLeft());
			postSearch(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}
	
	//非递归中序遍历
	public void midSearch2(TreeNode node){
		if (node == null) {
			System.out.println("空树！");
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.empty() || node != null) {
			if(node != null){//左节点不空一直入栈
				stack.push(node);
				node = node.getLeft();
			}else{
				node = stack.pop();
				System.out.print(node.getData() + " ");
				node = node.getRight();
			}
		}
	}
	
	//非递归前序遍历
	public void preSearch2(TreeNode node){
		if(node == null){
			System.out.println("空树！");
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while(!stack.empty()){
			node = stack.pop();
			System.out.print(node.getData() + " ");
			if(node.getRight() != null){
				stack.push(node.getRight());
			}
			if(node.getLeft() != null){
				stack.push(node.getLeft());
			}
		}
	}

	//非递归后序遍历
	public void postSearch2(TreeNode node){
		if(node == null){
			System.out.println("空树！");
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tempNode = null;
		while( node != null || !stack.empty()){
			while(node != null){
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.pop();
			while(node != null && (node.getRight() == null || node.getRight() == tempNode)){
				System.out.print(node.getData() + " ");
				tempNode = node;//记录上次访问过的节点
				
				if(stack.empty()){
					return;
				}
				node = stack.pop();
			}
			stack.push(node);
			node = node.getRight();
		}
	}
	
	//层次遍历
	public void levelSearch(TreeNode node){
		if(node == null){
			System.out.println("空树！");
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			node = queue.poll();
			System.out.print(node.getData() + " ");
			if(node.getLeft() != null){
				queue.add(node.getLeft());
			}
			if(node.getRight() != null){
				queue.add(node.getRight());
			}
		}
	}
	
	public void preSearch3(TreeNode node){
		if(node == null){
			System.out.println("空树！");
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while(!stack.empty()){
			node = stack.pop();
			System.out.print(node.getData() + " ");
			if(node.getRight() != null){
				stack.push(node.getRight());
			}
			if(node.getLeft() != null){
				stack.push(node.getLeft());
			}
		}
	}
	
	public void midSearch3(TreeNode node){
		if(node == null){
			System.out.println("空树！");
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.empty() || node != null){
			while(node != null){
				stack.push(node);
				node = node.getLeft();
			}
			if(!stack.empty()){
				node = stack.pop();
				System.out.print(node.getData() + " ");
				node = node.getRight();
			}
		}
	}
	
	public void postSearch3(TreeNode node){
		if(node == null){
			System.out.println("空树！");
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		TreeNode temp = null;//前一次访问的结点
		while(!stack.empty()){
			node = stack.peek();
			if((node.getLeft() == null && node.getRight() == null)
					|| (temp != null) && (temp == node.getLeft() ||temp == node.getRight())){
				System.out.print(node.getData() + " ");//如果当前结点没有孩子结点或者孩子节点都已被访问过 
				stack.pop();
				temp = node;
			}else{
				if(node.getRight() != null){
					stack.push(node.getRight());
				}
				if(node.getLeft() != null){
					stack.push(node.getLeft());
				}
			}
		}
	}
	
	//求二叉树的深度
	public int getDepth(TreeNode node){
    	int depth1;
    	int depth2;
    	
    	if(node == null){
    		return 0;
    	}else{
    		depth1 = getDepth(node.getLeft());
    		depth2 = getDepth(node.getRight());
    	}
    	//当遇到叶子节点时，它的左孩子和右孩子都为空，此时depth1=0，depth2=0，调用depth2+1返回1，得到叶节点的深度为1
    	//递归得到根节点的深度
    	return depth1 > depth2 ? depth1 + 1 : depth2 + 1;
	}
	
	public static void main(String[] args) {
		BSTree tree = new BSTree();
		int[] dataArr = {21,12,26,6,15,25,32,10};
		for(int i=0;i<dataArr.length;i++){
			tree.insert(dataArr[i]);
		}
		
		tree.postSearch3(tree.root);
		
		System.out.println();
		int depth = tree.getDepth(tree.root);
		System.out.println("树的深度是：" + depth);
	}
}
