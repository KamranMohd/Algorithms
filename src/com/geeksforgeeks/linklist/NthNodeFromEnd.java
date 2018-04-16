package com.geeksforgeeks.linklist;

/**
 * https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
 * @author kamran
 */

public class NthNodeFromEnd {

	public static void main(String[] args) {
		LinkedListOperations ll = new LinkedListOperations();
		ll.insertNodeAtStart(new SingleLLNode(10, null));
		ll.insertNodeAtStart(new SingleLLNode(20, null));
		ll.insertNodeAtStart(new SingleLLNode(30, null));
		ll.insertNodeAtEnd(new SingleLLNode(40, null));
		ll.insertAtPos(new SingleLLNode(100, null), 3);
		ll.printLL();
		getNthNodeFromList(ll,6);
	}
	
	public static void getNthNodeFromList(LinkedListOperations ll, int pos){
		int len = ll.getLength();
		int count = 1, resultNode = (len-pos+1);
		SingleLLNode p = ll.head;
		if(pos > len){
			System.out.println("Not enough element in the list");
			return;
		}
		while(count!=resultNode){
			p = p.next;
			count++;
		}
		System.out.println(p.getData());
	}
}