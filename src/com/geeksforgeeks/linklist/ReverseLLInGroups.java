package com.geeksforgeeks.linklist;

/*
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class ReverseLLInGroups {

	public static void main(String[] args) {
		LinkedListOperations ll = new LinkedListOperations();
		ll.insertNodeAtStart(new SingleLLNode(9, null));
		ll.insertNodeAtStart(new SingleLLNode(8, null));
		ll.insertNodeAtStart(new SingleLLNode(7, null));
		ll.insertNodeAtStart(new SingleLLNode(6, null));
		ll.insertNodeAtStart(new SingleLLNode(5, null));
		ll.insertNodeAtStart(new SingleLLNode(4, null));
		ll.insertNodeAtStart(new SingleLLNode(3, null));
		ll.insertNodeAtStart(new SingleLLNode(2, null));
		ll.insertNodeAtStart(new SingleLLNode(1, null));
		System.out.println("Linked list before reversing");
		ll.printLL();
		ll.head = reverseInGroups(ll.head, 3);
		System.out.println("Linked list after reversal");
		ll.printLL();
	}

	public static SingleLLNode reverseInGroups(SingleLLNode head, int k) {
		if (head == null)
			return head;
		int count = 0;
		SingleLLNode prev = null, next = null, current = head;
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if (next != null)
			head.next = reverseInGroups(current, k);
		return prev;
	}
}
