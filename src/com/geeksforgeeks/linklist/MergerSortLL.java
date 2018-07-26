package com.geeksforgeeks.linklist;

public class MergerSortLL {

	public static void main(String[] args) {
		LinkedListOperations ll = new LinkedListOperations();
		ll.insertNodeAtStart(new SingleLLNode(10, null));
		ll.insertNodeAtStart(new SingleLLNode(20, null));
		ll.insertNodeAtStart(new SingleLLNode(30, null));
		ll.insertNodeAtEnd(new SingleLLNode(40, null));
		ll.insertAtPos(new SingleLLNode(100, null), 3);
		System.out.println("Linked list before sorting");
		ll.printLL();
		System.out.println("Linked list after sorting");
		ll.head = mergeSort(ll.head);
		ll.printLL();

	}

	public static SingleLLNode mergeSort(SingleLLNode head) {
		// If there is 0 or 1 nodes, then no need to sort
		if (head == null || head.next == null)
			return head;

		// Get the middle element of the linked list
		SingleLLNode middle = getMiddleNode(head);
		// System.out.println("Middle : " + middle.data);

		SingleLLNode nextToMiddlle = middle.next;
		middle.next = null;

		// Now we have 2 linked list with head: head and nextToMiddle
		// Recursively split the LL into 2 halves
		// System.out.println(head.data + " " + nextToMiddlle.data);
		SingleLLNode left = mergeSort(head);
		SingleLLNode right = mergeSort(nextToMiddlle);
		
		SingleLLNode sortedList = mergeList(left, right);
		return sortedList;
	}

	private static SingleLLNode mergeList(SingleLLNode left, SingleLLNode right) {
		// If one of the heads is null, return the other one
		if (left == null)
			return right;
		if (right == null)
			return left;

		SingleLLNode result = null;
		// Check for the lower value and move accordingly
		if (left.data <= right.data) {
			result = left;
			result.next = mergeList(left.next, right);
		} else {
			result = right;
			result.next = mergeList(left, right.next);
		}
		return result;
	}

	private static SingleLLNode getMiddleNode(SingleLLNode h) {
		// Base case
		if (h == null)
			return h;
		SingleLLNode fastptr = h.next;
		SingleLLNode slowptr = h;

		// Move fastptr by two and slow ptr by one
		// Finally slowptr will point to middle node
		while (fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
		}
		return slowptr;
	}
}