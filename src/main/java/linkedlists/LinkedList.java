package linkedlists;

import java.util.Iterator;

/** A class representing a singly linked list. */
public class LinkedList  implements  Iterable<Node> {
	private Node head, tail;

	/** Constructor */
	public LinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Creates a new node with the given element and adds it to the back of the
	 * list
	 */
	public void append(int elem) {
		Node newNode = new Node(elem);
		if (tail != null) {
			tail.setNext(newNode);
			tail = newNode;
		} else { // if it's an empty list
			head = tail = newNode;
		}
	}

	/** Prints all the nodes in the link list */
	public void printNodes() {
		Node current = head;
		while (current != null) {
			System.out.print(current.elem() + " ");
			current = current.next();
		}
		System.out.println();
	}

	/**
	 * Insert a new node with the given element in front of the linked list
	 * @param elem element
	 */
	public void insertAtFront(int elem) {
		// Insert a new node with elem in front of the linked list
		Node newNode = new Node(elem);
		if (head == null) {
			head = tail = newNode;
		}
		else {
			newNode.setNext(head);
			head = newNode;
		}
	}

	/**
	 * Insert a new node with the given element at index i
	 * @param i index
	 * @param elem element
	 */
	public void insertAtIndex(int i, int elem) {
		// Iinsert a new node with the given elem
		// at "index" i
		// Example:
		// If the linked list is 5 -> 7 - > 2 and we call
		// insertAtIndex(1, 8), the linked list will be
		// 5 -> 8 -> 7 -> 2  we inserted element 8 at "index" = 1.
		// 5->8->11->7->2
		// newNode = node with 11
		if (i < 0)
			return; // invalid i
		if (head == null && i != 0)
			return; // nothing to do
		if (i == 0) {
			insertAtFront(elem);
			return;
		}
		Node current = head;
		int count = 0;
		while (current != null && count < i - 1) {
			current = current.next();
			count += 1;
		}
		if (current == null)
			return; // no such index
		Node newNode = new Node(elem);
		if (current == tail)
			tail = newNode;
		newNode.setNext(current.next());
		current.setNext(newNode);
	}

	/** Remove a node after the prevNode (must be valid).
	 *
	 * @param prevNode node before the one we need to remove
	 */
	public void removeNodeAfter(Node prevNode) {
		if (head == null || prevNode == null || prevNode.next() == null)
			return; // nothing to do since no node after prevNode

		if (prevNode.next() == tail)
			tail = prevNode;
		prevNode.setNext(prevNode.next().next());
	}

	/**
	 * Return the head of the linked list
	 * @return head
	 */
	protected Node head() {
		return head;
	}

	/** Return the tail
	 *
	 * @return tail
	 */
	protected Node tail() {
		// Useful for testing
		return tail;
	}

	/**
	 * Return the iterator for this linked list
	 * @return iterator
	 */
	@Override
	public Iterator<Node> iterator() {
		return new MyLinkedListIterator();
	}

	/**
	 * Iterator for class LinkedList
	 */
	public class MyLinkedListIterator implements Iterator<Node> {
		private Node current;

		public MyLinkedListIterator() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Node next() {
			Node nextNode = current;
			current = current.next();
			return nextNode;
		}
	}

}
