package de.paulschnell.datenstrukturen;

public class Node<T> {
	
	private T content;
	private Node next;
	
	public Node(T content, Node next) {
		this.content = content;
		this.next = next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node next() {
		return next;
	}
	
	public T content() {
		return content;
	}

}
