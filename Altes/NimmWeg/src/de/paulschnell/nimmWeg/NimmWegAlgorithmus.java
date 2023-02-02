package de.paulschnell.nimmWeg;

import javax.swing.JOptionPane;

public class NimmWegAlgorithmus {

	public static void main(String[] args) {
		int streichhoelzer = 19;
		int anzahlWegnehmen = 0;
		int aktuellerSpieler = 0; // 0 Spieler, 1 Computer
		
		anzahlWegnehmen = Integer.parseInt(JOptionPane.showInputDialog("Es liegen " + streichhoelzer + " Streichhoelzer auf dem Tisch.\n"
				+ "Wie viele Streichhölzer möchtest du weg nehmen?\n"
				+ "Schreibe 1, 2 oder 3."));
		aktuellerSpieler = 1;
		streichhoelzer -= anzahlWegnehmen;
		
		while (streichhoelzer > 0) {
			if (aktuellerSpieler == 0) {
				anzahlWegnehmen = Integer.parseInt(JOptionPane.showInputDialog("Der Computer hat " + anzahlWegnehmen + " Streichhoelzer weg genommen.\n"
						+ "Es liegen " + streichhoelzer + " Streichhoelzer auf dem Tisch.\n"
						+ "Wie viele Streichhölzer möchtest du weg nehmen?\n"
						+ "Schreibe 1, 2 oder 3."));
				
				while (anzahlWegnehmen > 3 || anzahlWegnehmen < 1) {
					anzahlWegnehmen = Integer.parseInt(
							JOptionPane.showInputDialog("Es liegen " + streichhoelzer + " Streichhoelzer auf dem Tisch.\n"
									+ "Spieler " + aktuellerSpieler + " bitte versuche es erneut:\n"
									+ "Wie viele Streichhölzer möchtest du weg nehmen?\n" + "Schreibe 1, 2 oder 3."));
				}
				
				aktuellerSpieler = 1;
			} else {
				if (streichhoelzer < 5) {
					anzahlWegnehmen = 4 - anzahlWegnehmen;
				} else {
					switch (streichhoelzer) {
					case 18:	anzahlWegnehmen = 3; 	break;
					case 17:	anzahlWegnehmen = 3;	break;
					case 16:	anzahlWegnehmen = 2;	break;
					case 15:	anzahlWegnehmen = 2; 	break;
					case 14:	anzahlWegnehmen = 1;	break;
					case 12:	anzahlWegnehmen = 3; 	break;
					case 11:	anzahlWegnehmen = 2; 	break;
					case 10:	anzahlWegnehmen = 1; 	break;
					case 8: 	anzahlWegnehmen = 3;	break;
					case 7:		anzahlWegnehmen = 2;	break;
					case 6:		anzahlWegnehmen = 1; 	break;
					default: 	break;
					}
				}

				aktuellerSpieler = 0;
			}
			streichhoelzer -= anzahlWegnehmen;
		}
		
		if (aktuellerSpieler == 1) {
		JOptionPane.showMessageDialog(null,
				"Du hast das letzte Streichholz genommen und damit verloren.");
		} else {
			JOptionPane.showMessageDialog(null,
					"Der Computer hat das letzte Streichholz genommen und damit verloren.\nGlückwunsch!");
		}
	}

}
