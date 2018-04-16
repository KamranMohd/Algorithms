package com.geeksforgeeks.linklist;

public class SingleLLNode {
	int data;
	SingleLLNode next;
	public SingleLLNode(int data, SingleLLNode next) {
		this.data = data;
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public SingleLLNode getNext() {
		return next;
	}
	public void setNext(SingleLLNode next) {
		this.next = next;
	}
	
}