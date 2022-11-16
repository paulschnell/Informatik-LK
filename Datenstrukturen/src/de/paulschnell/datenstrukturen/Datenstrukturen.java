package de.paulschnell.datenstrukturen;

public class Datenstrukturen {

	Queue<String> warteschlange = new Queue<>();
	Stack<String> stapel = new Stack<>();
	
	public static void main(String[] args) {
		Datenstrukturen d = new Datenstrukturen();
		
		d.queueAnlegen();
		d.stackAnlegen();
		
		d.queueAusgeben();
		d.stackAusgeben();
	}
	
	public void queueAnlegen() {
		warteschlange.enqueue("Katsuki"); 
		warteschlange.enqueue("Deku");
		warteschlange.enqueue("Pres Mic");
	}
	
	public void stackAnlegen() {
		stapel.push("Katsuki"); 
		stapel.push("Deku");
		stapel.push("Pres Mic");
	}
	
	public void queueAusgeben() {
		System.out.println("FIFO\n--------------");
		while (!warteschlange.isEmpty()) {
			System.out.println(warteschlange.dequeue());
		}
		System.out.println("--------------");
	}
	
	public void stackAusgeben() {
		System.out.println("LIFO\n--------------");
		while (!stapel.isEmpty()) {
			System.out.println(stapel.pop());
		}
		System.out.println("--------------");
	}
	
}
