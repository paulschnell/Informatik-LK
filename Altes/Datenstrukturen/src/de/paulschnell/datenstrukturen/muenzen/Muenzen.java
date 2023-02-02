package de.paulschnell.datenstrukturen.muenzen;

import de.paulschnell.datenstrukturen.Stack;

public class Muenzen {
	private Stack<Integer> stapel = new Stack<Integer>();
	private final int muenzen[] = { 10, 20, 50, 100, 200 };
	
	public static void main(String[] args) {
		Muenzen m = new Muenzen();		
		
		m.stackAnlegen();
		m.sortieren();
	}
	
	public void stackAnlegen() {
		for (int i = 0; i < 20; i++) {
			int muenze = (int) (Math.random() * 20 + 1);
			stapel.push(muenze);
		}
	}
	
	public void sortieren() {
		System.out.println("Sortiert:");
		int nArt[] = new int[muenzen.length];
		while (!stapel.isEmpty()) {
			int art = stapel.pop();
			for (int i = 0; i < muenzen.length; i++) {
				if (muenzen[i] == art) {
					nArt[i]++;
					break;
				}
			}
		}
		
		int insgesamt = 0;
		for (int i = 0; i < nArt.length; i++) {
			System.out.println((nArt[i] + 1) + ": " + muenzen[i]);
			insgesamt += (nArt[i] + 1) * muenzen[i];
		}
		
		System.out.println("Insgesamt: " + (float)insgesamt / 100 + "€");
	}
	
	public void stackAusgeben() {
		System.out.println("LIFO\n--------------");
		while (!stapel.isEmpty()) {
			System.out.println(stapel.pop());
		}
		System.out.println("--------------");
	}

}
