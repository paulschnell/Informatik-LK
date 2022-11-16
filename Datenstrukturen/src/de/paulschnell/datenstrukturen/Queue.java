package de.paulschnell.datenstrukturen;

public class Queue<T> {

	private Node<T> head;
	private Node<T> tail;
	
	public Queue() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null || tail == null;
	}
	
	public void enqueue(T objekt) {
		Node<T> newTail = new Node<T>(objekt, null);
		if (!isEmpty())
			tail.setNext(newTail);
		else
			head = newTail;
		
			tail = newTail;
	}
	
	public T dequeue() {
		if (isEmpty())
			return null;
		
		T r = head.content();
		head = head.next();
		return r;
	}
	
	public Node<T> front() {
		return head;
	}
	
}
