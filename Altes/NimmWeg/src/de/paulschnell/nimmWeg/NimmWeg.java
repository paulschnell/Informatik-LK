package de.paulschnell.nimmWeg;

import javax.swing.JOptionPane;

public class NimmWeg {

	public static void main(String[] args) {
		int streichhoelzer = 19;
		int aktuellerSpieler = 2; // 1 oder 2. Ist auf 2 damit Spieler 1 beginnt.
		int anzahlWegnehmen;

		while (streichhoelzer > 0) {
			if (aktuellerSpieler == 1) {
				aktuellerSpieler = 2;
			} else {
				aktuellerSpieler = 1;
			}

			anzahlWegnehmen = Integer.parseInt(JOptionPane.showInputDialog("Es liegen " + streichhoelzer + " Streichhoelzer auf dem Tisch.\n"
					+ "Spieler " + aktuellerSpieler + ": Wie viele Streichhölzer möchtest du weg nehmen?\n"
					+ "Schreibe 1, 2 oder 3."));

			while (anzahlWegnehmen > 3 || anzahlWegnehmen < 1) {
				anzahlWegnehmen = Integer.parseInt(
						JOptionPane.showInputDialog("Es liegen " + streichhoelzer + " Streichhoelzer auf dem Tisch.\n"
								+ "Spieler " + aktuellerSpieler + " bitte versuche es erneut:\n"
								+ "Wie viele Streichhölzer möchtest du weg nehmen?\n" + "Schreibe 1, 2 oder 3."));
			}

			streichhoelzer -= anzahlWegnehmen;
		}

		JOptionPane.showMessageDialog(null,
				"Spieler " + aktuellerSpieler + " hat verloren. Er hat das letzte Streichholz genommen.");
	}

}
