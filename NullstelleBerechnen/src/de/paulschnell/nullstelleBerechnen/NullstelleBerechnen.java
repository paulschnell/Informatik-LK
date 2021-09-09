package de.paulschnell.nullstelleBerechnen;

import javax.swing.JOptionPane;

public class NullstelleBerechnen {

	public static void main(String[] args) {
		String eingabeP = JOptionPane.showInputDialog("Bitte gebe p ein: ");
		String eingabeQ = JOptionPane.showInputDialog("Bitte gebe q ein: ");
		
		Double p = Double.parseDouble(eingabeP);
		Double q = Double.parseDouble(eingabeQ);
		
		Double d = Math.sqrt(p / 2) - q;
		
		if (d > 0) {
			JOptionPane.showMessageDialog(null, "Die Funktion 0 = x^2 + " + p + "x + " + q + " hat 2 Nullstellen.");
		} else if (d == 0) {
			JOptionPane.showMessageDialog(null, "Die Funktion 0 = x^2 + " + p + "x + " + q + " hat 1 Nullstelle.");
		} else /*if (d < 0)*/ {
			JOptionPane.showMessageDialog(null, "Die Funktion 0 = x^2 + " + p + "x + " + q + " hat keine Nullstellen.");
		}
	}

}
