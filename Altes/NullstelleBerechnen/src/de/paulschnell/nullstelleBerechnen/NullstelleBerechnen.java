package de.paulschnell.nullstelleBerechnen;

import javax.swing.JOptionPane;

public class NullstelleBerechnen {

	public static void main(String[] args) {
		Double p = Double.parseDouble(JOptionPane.showInputDialog("Bitte gebe p ein: "));
		Double q = Double.parseDouble(JOptionPane.showInputDialog("Bitte gebe q ein: "));
		
		Double d = Math.pow(p / 2, 2) - q;
		
		if (d > 0) {
			Double x1 = -p/2 + Math.sqrt(d);
			Double x2 = -p/2 - Math.sqrt(d);
			
			JOptionPane.showMessageDialog(null, "Die Funktion 0 = x^2 + " + p + "x + " + q + " hat 2 Nullstellen.\n"
					+ "x1 = " + x1 + "\nx2 = " + x2);
		} else if (d == 0) {
			Double x = -p/2;
			
			JOptionPane.showMessageDialog(null, "Die Funktion 0 = x^2 + " + p + "x + " + q + " hat 1 Nullstelle.\n"
					+ "x = " + x);
		} else /*if (d < 0)*/ {
			JOptionPane.showMessageDialog(null, "Die Funktion 0 = x^2 + " + p + "x + " + q + " hat keine Nullstellen.");
		}
	}

}
