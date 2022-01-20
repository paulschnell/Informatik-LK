package de.paulschnell.sortieren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VisuellSortieren {

	public static void main(String[] args) {
		VisuellSortieren m = new VisuellSortieren();

		while (true) {
			System.out.print("Wie viele Zahlen? ");
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			int anzahl = 0;
			try {
				anzahl = Integer.parseInt(r.readLine());
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int[] zahlen = new int[anzahl];
			for (int i = 0; i < zahlen.length; i++) {
				zahlen[i] = (int) (Math.random() * 100);
			}

			int[] sortiert = m.sortieren(zahlen);
		}
	}

	int[] sortieren(int[] zahlen) {
		// kleinste und groeßte Zahl speichern
		int min = zahlen[0];
		int max = zahlen[0];
		for (int i = 0; i < zahlen.length; i++) {
			if (zahlen[i] < min)
				min = zahlen[i];
			if (zahlen[i] > max)
				max = zahlen[i];
		}

		int[] sortiert = new int[zahlen.length];
		int sortiertZaehler = 0;
		
		for (int j = min; j <= max; j++) {
			int szo = sortiertZaehler;
			for (int i = 0; i < zahlen.length; i++) {
				if (zahlen[i] == j) {
					sortiert[sortiertZaehler] = j;
					sortiertZaehler++;
				}
			}
			
			if (szo != sortiertZaehler) {
			System.out.println("Stelle " + sortiertZaehler);
			System.out.println("Unsortierter Array: " + arrayToString(zahlen));
			System.out.println("Sortierter Array:   " + arrayToString(sortiert));
			System.out.println();
			}
		}

		return sortiert;
	}
	
	String arrayToString(int[] array) {
		StringBuffer sb = new StringBuffer();
		sb.append("[ ");
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1)
				sb.append(array[i] + ", ");
			else
				sb.append(array[i] + " ");
		}
		sb.append("]");
		return sb.toString();
	}

}
