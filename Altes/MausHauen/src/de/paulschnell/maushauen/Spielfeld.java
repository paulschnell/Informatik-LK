package de.paulschnell.maushauen;

import java.util.Scanner;

public class Spielfeld {

	private int nFeldWidth = 0;
	private int nFeldHeight = 0;
	private Maus maus = null;
	private char feld[][];

	public static void main(String[] args) {
		Spielfeld spielfeld = new Spielfeld(2, 2);
		
		spielfeld.setzeMaus();
		spielfeld.leeresSpielfeld();
		
		boolean fertig = false;
		while (!fertig) {
			spielfeld.ausgabe();
			fertig = spielfeld.mausHauen();
		}
		spielfeld.ausgabe();
	}

	public Spielfeld(int nFeldWidth, int nFeldHeight) {
		this.nFeldWidth = nFeldWidth;
		this.nFeldHeight = nFeldHeight;

		feld = new char[nFeldWidth][nFeldHeight];
	}

	public void ausgabe() {
		String line = null;
		for (int y = 0; y < nFeldHeight; y++) {
			line = "";
			for (int x = 0; x < nFeldWidth; x++)
				line += feld[y][x] + " ";
			System.out.println(line);
		}
	}

	public void leeresSpielfeld() {
		for (int y = 0; y < nFeldHeight; y++)
			for (int x = 0; x < nFeldWidth; x++)
				feld[y][x] = 'O';
	}

	public void setzeMaus() {
		int x = (int) (Math.random() * nFeldWidth);
		int y = (int) (Math.random() * nFeldHeight);
		maus = new Maus(x, y);
	}

	public boolean mausHauen() {
		Scanner scanner = new Scanner(System.in);
		int xPosHammer = -1;
		int yPosHammer = -1;
		while (!(xPosHammer >= 0 && xPosHammer < nFeldWidth)) {
			System.out.print("Gib die X-Position des Hammers ein: ");
			xPosHammer = scanner.nextInt();
		}
		while (!(yPosHammer >= 0 && yPosHammer < nFeldHeight)) {
			System.out.print("Gib die Y-Position des Hammers ein: ");
			yPosHammer = scanner.nextInt();
		}
		
		if (maus.IsGetroffen(xPosHammer, yPosHammer)) {
			feld[yPosHammer][xPosHammer] = 'M';
			System.out.println("Treffer!\n");
			return true;
		} else {
			feld[yPosHammer][xPosHammer] = 'H';
			System.out.println("Daneben!\n");
			return false;
		}
	}

}
