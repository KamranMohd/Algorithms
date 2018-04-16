package com.geeksforgeeks.linklist;

public class LinkedListOperations {
	SingleLLNode head;
	public LinkedListOperations(){
		head = null;
	}
	
	public void insertNodeAtStart(SingleLLNode node){
		if(node==null)
			return;
		node.next = head;
		head = node;
	}
	
	public void insertNodeAtEnd(SingleLLNode node){
		SingleLLNode p = head;
		if(head == null){
			node.next = head;
			head = node;
		}
			
		while(p.next!=null){
			p = p.next;
		}
		p.next = node;
		node.next = null;
	}
	
	public void insertAtPos(SingleLLNode node, int pos){
		if(pos == 1)
			return ;
		int startIndex = 1;
		SingleLLNode p = head;
		while(startIndex < pos-1){
			p = p.next;
			startIndex++;
		}
		node.next = p.next;
		p.next = node;
	}
	
	public void deleteNodeFromStart(){
		if(getLength()==0)
			return;
		SingleLLNode temp = head;
		head = head.next;
		temp = null;
	}
	
	public void deleteNodeFromEnd(){
		if(getLength()==0)
			return;
		SingleLLNode temp = head;
		SingleLLNode temp2 = head.next;
		while(temp2.next != null){
			temp = temp2;
			temp2 = temp2.next;
		}
		temp.next = temp2.next;
		temp2 = null;
	}
	
	public void deleteNodeAtPos(int pos){
		if(getLength()==0)
			return;
		int startIndex = 1;
		SingleLLNode p = head;
		SingleLLNode q = head.next;
		while(q!=null && startIndex < pos-1){
			p = q;
			q = q.next;
			startIndex++;
		}
		p.next = q.next;
		q = null;
	}
	
	public int getPosition(int data){
		SingleLLNode p = head;
		int pos = 1;
		while(p!=null && p.data!=data){
			p = p.next;
			pos++;
		}
		return (pos > getLength() ? -1 : pos);
	}
	
	public void printLL(){
		SingleLLNode p = head;
		while(p!=null){
			System.out.print(p.data + (p.next!=null?" -> ":""));
			p = p.next;
		}
		System.out.println();
	}
	
	public int getLength(){
		SingleLLNode p = head;
		int length = 0;
		while(p!=null){
			length++;
			p = p.next;
		}
		return length;
	}
}
