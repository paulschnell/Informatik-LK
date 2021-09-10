package de.paulschnell.pythagoras;

import javax.swing.JOptionPane;

public class Pythagoras {

	public static void main(String[] args) {
		String eingabeA = JOptionPane.showInputDialog("Gebe a ein: \n"
				+ "(Falls du a berechnen lassen möchtest, gebe 0 für a ein.)\n"
				+ "Der Rechtewinkel liegt bei C.");
		String eingabeB = JOptionPane.showInputDialog("Gebe b ein: \n"
				+ "(Falls du b berechnen lassen möchtest, gebe 0 für b ein.)\n"
				+ "Der Rechtewinkel liegt bei C.");
		String eingabeC = JOptionPane.showInputDialog("Gebe c ein: \n"
				+ "(Falls du c berechnen lassen möchtest, gebe 0 für c ein.)\n"
				+ "Der Rechtewinkel liegt bei C.");
		
		Double a = Double.parseDouble(eingabeA);
		Double b = Double.parseDouble(eingabeB);
		Double c = Double.parseDouble(eingabeC);
		
		if (eingabeA.equals("0") && !eingabeB.equals("0") && !eingabeC.equals("0")) {
			
			a = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
			JOptionPane.showMessageDialog(null, "Die Länge von der Seite a bei b = " + b + " und c = " + c + " ist a = " + a + ".");
			
		} else if (!eingabeA.equals("0") && eingabeB.equals("0") && !eingabeC.equals("0")) {
			
			b = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
			JOptionPane.showMessageDialog(null, "Die Länge von der Seite b bei a = " + a + " und c = " + c + " ist b = " + b + ".");
			
		} else if (!eingabeA.equals("0") && !eingabeB.equals("0") && eingabeC.equals("0")) {
			
			c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
			JOptionPane.showMessageDialog(null, "Die Länge von der Seite c bei a = " + a + " und b = " + b + " ist c = " + c + ".");
			
		} else {
			JOptionPane.showMessageDialog(null, "Deine Eingaben sind inkorrekt. Bitte versuche es erneut.");
		}
	}

}
