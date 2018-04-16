package com.geeksforgeeks.linklist;

public class LinkedList {

	public static void main(String[] args) {
		LinkedListOperations ll = new LinkedListOperations();
		//System.out.println(ll.getLength());
		ll.insertNodeAtStart(new SingleLLNode(10, null));
		ll.insertNodeAtStart(new SingleLLNode(20, null));
		ll.insertNodeAtStart(new SingleLLNode(30, null));
		ll.insertNodeAtEnd(new SingleLLNode(40, null));
		ll.insertAtPos(new SingleLLNode(100, null), 3);
		ll.printLL();
		ll.deleteNodeFromStart();
		ll.printLL();
		ll.deleteNodeFromEnd();
		//ll.deleteNodeAtPos(3);
		ll.printLL();
		System.out.println(ll.getPosition(10));	
	}
}