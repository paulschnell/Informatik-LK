package de.schnell.nullstelleBerechnen;

import javax.swing.JOptionPane;

public class NullstelleBerechnen {

	public static void main(String[] args) {
		Double p = Double.parseDouble(JOptionPane.showInputDialog("p:"));
		Double q = Double.parseDouble(JOptionPane.showInputDialog("q:"));
		Double d = (Math.sqrt(p / 2) - q);
		
		if (d > 0) {
			JOptionPane.showMessageDialog(null, "Die Funktion hat 2 Nullstellen.");
		} else if (d == 0) {
			JOptionPane.showMessageDialog(null, "Die Funktion hat 1 Nullstelle.");
		} else {
			JOptionPane.showMessageDialog(null, "Die Funktion hat keine Nullstellen.");
		}
	}

}
