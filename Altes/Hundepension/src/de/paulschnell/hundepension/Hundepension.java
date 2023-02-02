package de.paulschnell.hundepension;

import javax.swing.JOptionPane;

public class Hundepension {
	
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Gebe einen Namen für einen Hund ein:");
		Double gewicht = 8000.0;

		String eingabe = JOptionPane.showInputDialog("Gebe 1 ein, um " + name + " zu füttern (+200g).\n"
				+ "Gebe 2 ein, um mit " + name + " Gassi zu gehen (-100g).");
		
		while (gewicht > 4000 && gewicht < 30000 && !eingabe.equals("0")) {
			if (eingabe.equals("1")) {
				gewicht += 200.0;
				eingabe = JOptionPane.showInputDialog(null, "Du hast " + name + " gefüttert. Aktuelles Gewicht: " + gewicht + "g.\n"
						+ "Gebe 1 ein, um " + name + " zu füttern (+200g).\n"
						+ "Gebe 2 ein, um mit " + name + " Gassi zu gehen (-100g).\n"
						+ "Gebe 0 zum Schließen des Programms ein.");
				
			} else if (eingabe.equals("2")) {
				gewicht -= 100.0;
				eingabe = JOptionPane.showInputDialog(null, "Du bist mit " + name + " Gassi gelaufen. Aktuelles Gewicht: " + gewicht + "g.\n"
						+ "Gebe 1 ein, um " + name + " zu füttern (+200g).\n"
						+ "Gebe 2 ein, um mit " + name + " Gassi zu gehen (-100g).\n"
						+ "Gebe 0 zum Schließen des Programms ein.");				
			
			} else {
				eingabe = JOptionPane.showInputDialog("Bitter versuche es erneut.\n"
						+ "Gebe 1 ein, um " + name + " zu füttern (+200g).\n"
						+ "Gebe 2 ein, um mit " + name + " Gassi zu gehen (-100g).\n"
						+ "Gebe 0 zum Schließen des Programms ein.");
			}
		}
		
		if (eingabe.equals("0")) {
			JOptionPane.showMessageDialog(null, "Du hast die Hundepension abgebrochen.\n"
					+ "Letztes Gewicht von " + name + ": " + gewicht + "g");
		} else {
			JOptionPane.showMessageDialog(null, name + " ist gestorben. Du hast dich nicht genug um ihn gekümmert.\n"
					+ "Letztes Gewicht: " + gewicht + "g");
		}
	}
	
}
