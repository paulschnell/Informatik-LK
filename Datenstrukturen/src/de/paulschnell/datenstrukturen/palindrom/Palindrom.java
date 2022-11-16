package de.paulschnell.datenstrukturen.palindrom;

import javax.swing.JOptionPane;

import de.paulschnell.datenstrukturen.Stack;

public class Palindrom {

	private Stack<Character> stapel = new Stack<Character>();
	private String wort;
	
	public static void main(String[] args) {
		Palindrom p = new Palindrom();
		p.wort = JOptionPane.showInputDialog("Wort:");
		p.stackAnlegen();
		
		if (p.testen()) {
			JOptionPane.showMessageDialog(null, p.wort + " ist ein Palindrom!");
		} else {
			JOptionPane.showMessageDialog(null, p.wort + " ist kein Palindrom!");			
		}
	}
	
	public void stackAnlegen() {
		for (int i = 0; i < wort.length(); i++) {
			stapel.push(wort.charAt(i));
		}
	}
	
	public boolean testen() {
		String umgekehrt = "";
		while (!stapel.isEmpty()) {
			umgekehrt += stapel.pop();
		}
		return wort.equalsIgnoreCase(umgekehrt);
	}
	
}
