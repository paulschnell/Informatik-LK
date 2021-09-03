package de.schnell.stringOderZahlen;

import javax.swing.JOptionPane;

public class StringOderZahlen {

	public static void main(String[] args) {
		String eingabe1 = JOptionPane.showInputDialog("Gebe eine Zahl ein:");
		String operator = JOptionPane.showInputDialog("Gebe einen Rechenoperator ein (+, -, *, /):");
		String eingabe2 = JOptionPane.showInputDialog("Gebe eine weitere Zahl ein:");
		
		Double zahl1 = Double.parseDouble(eingabe1);
		Double zahl2 = Double.parseDouble(eingabe2);
		Double ergebnis = null;
		
		if (operator.equals("+")) {
			ergebnis = zahl1 + zahl2;
		} else if (operator.equals("-")) {
			ergebnis = zahl1 - zahl2;
		} else if (operator.equals("*")) {
			ergebnis = zahl1 * zahl2;
		} else if (operator.equals("/")) {
			ergebnis = zahl1 / zahl2;
		}
		
		JOptionPane.showMessageDialog(null, "Das Ergebnis von " + eingabe1 + operator + eingabe2 + " ist " + ergebnis + ".");
	}

}
