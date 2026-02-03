package linkedlists;

/* A class representing a node in a singly linked list */
public class Node {
	private int elem;
	private Node next;

	/**
	 * Constructor for class Node
	 * @param elem element
	 * @param next reference to the next node
	 */
	public Node(int elem, Node next) {
		this.elem = elem;
		this.next  = next;
	}

	/**
	 * Constructor for class Node
	 * @param elem element
	 */
	public Node(int elem) {
		this.elem = elem;
		next = null;
	}

	/**
	 * Return an element stored in the given node
	 * @return element
	 */
	public int elem() {
		return elem;
	}

	/**
	 * Set the element
	 * @param elem element
	 */
	public void setElem(int elem) {
		this.elem = elem;
	}

	/**
	 * Return the reference to the next node
	 * @return reference to the next node
	 */
	public Node next() {
		return next;
	}
	
	public void setNext(Node other) {
		next = other;
	}

	/**
	 * Return a string representing the node
	 * @return
	 */
	@Override
	public String toString() {
		return elem + ", ";
	}
}
