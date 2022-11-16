package de.paulschnell.datenstrukturen;

public class Stack<T> {

	private Node<T> head = null;
	
	public Stack() {
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(T object) {
		Node<T> newNode = new Node<T>(object, head);
		head = newNode;
	}
	
	public T pop() {
		T content = head.content();
		head = head.next(); // head.next() ist null, wenn es das letzte ist
		return content;
	}
	
	public Node<T> peek() {
		return head;
	}
	
}
