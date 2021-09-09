package de.paulschnell.stringOderZahlen;

import javax.swing.JOptionPane;

public class StringsOderZahlen {

	public static void main(String[] args) {
		String eingabe1 = JOptionPane.showInputDialog("Gebe eine Zahl ein:");
		String operator = JOptionPane.showInputDialog("Gebe einen Rechenoperator ein (+, -, *, /):");
		String eingabe2 = JOptionPane.showInputDialog("Gebe eine weitere Zahl ein:");
		
		Double zahl1 = Double.parseDouble(eingabe1);
		Double zahl2 = Double.parseDouble(eingabe2);
		Double ergebnis = 0.0;
		
		/*if (operator.equals("+")) {
			ergebnis = zahl1 + zahl2;
		} else if (operator.equals("-")) {
			ergebnis = zahl1 - zahl2;
		} else if (operator.equals("*")) {
			ergebnis = zahl1 * zahl2;
		} else if (operator.equals("/")) {
			if (zahl2 != 0) {
				ergebnis = zahl1 / zahl2;
			} else {
				JOptionPane.showMessageDialog(null, "Man kann nicht durch 0 teilen. Bitte versuche es erneut.");
			}
		}*/
		
		switch (operator) {
		case "+":
			ergebnis = zahl1 + zahl2;
			break;
		case "-":
			ergebnis = zahl1 - zahl2;
			break;
		case "*":
			ergebnis = zahl1 * zahl2;
			break;
		case "/":
			if (zahl2 != 0) {
				ergebnis = zahl1 / zahl2;
			} else {
				JOptionPane.showMessageDialog(null, "Man kann nicht durch 0 teilen. Bitte versuche es erneut.");
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Bitte gebe +, -, * oder / ein.");
			break;
		}
		
		if (zahl2 != 0 && !operator.equals("/")) {
			JOptionPane.showMessageDialog(null, "Das Ergebnis von " + eingabe1 + " " + operator + " " + eingabe2 + " ist " + ergebnis + ".");
		}
	}

}
