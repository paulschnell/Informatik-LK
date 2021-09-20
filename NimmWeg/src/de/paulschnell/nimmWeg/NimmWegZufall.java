package de.paulschnell.nimmWeg;

import java.util.Random;

import javax.swing.JOptionPane;

public class NimmWegZufall {

	public static void main(String[] args) {
		int streichhoelzer = 19;
		int anzahlWegnehmen = 0;
		int aktuellerSpieler = 0; // 0 Computer, 1 Spieler
		
		while (streichhoelzer > 0) {
			if (aktuellerSpieler == 0) {
				Random random = new Random();
				anzahlWegnehmen = random.nextInt(3 - 1) + 1;
				
				aktuellerSpieler = 1;
			} else {
				anzahlWegnehmen = Integer.parseInt(JOptionPane.showInputDialog("Der Computer hat " + anzahlWegnehmen + " Streichhoelzer weg genommen.\n"
						+ "Es liegen " + streichhoelzer + " Streichhoelzer auf dem Tisch.\n"
						+ "Wie viele Streichhölzer möchtest du weg nehmen?\n"
						+ "Schreibe 1, 2 oder 3."));

				aktuellerSpieler = 0;
			}
			streichhoelzer -= anzahlWegnehmen;
		}
		

		JOptionPane.showMessageDialog(null,
				"Spieler " + aktuellerSpieler + " hat verloren. Er hat das letzte Streichholz genommen.");
	}

}
