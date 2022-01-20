package de.paulschnell.sortieren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sortieren {

	public static void main(String[] args) {
		Sortieren m = new Sortieren();

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

			long tp1 = System.nanoTime();
			int[] sortierteZahlen = m.sortieren(zahlen);
			long tp2 = System.nanoTime();
			long diff = tp2 - tp1;
			double secs = ((double) diff) / 1000000000;

			System.out.println("Unsortierter Array:");
			m.printArray(zahlen);

			System.out.println("\nSortierter Array:");
			m.printArray(sortierteZahlen);

			System.out.println("\nBerechnungszeit:");
			System.out.println(diff + "ns");
			System.out.println("%.9fs\n".formatted(secs));
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

		/*
		 * Durch jede Zahl zwischen dem Minimum und Maximum gehen, dabei jedes Mal durch
		 * alle Zahlen gehen und überprüfen, falls die aktuelle Zahl der zu
		 * überpfüfenden Zahl übereinstimmt.
		 */
		for (int j = min; j <= max; j++) {
			for (int i = 0; i < zahlen.length; i++) {
				if (zahlen[i] == j) {
					sortiert[sortiertZaehler] = j;
					sortiertZaehler++;
				}
			}
		}

		return sortiert;
	}

	void printArray(int[] array) {
		System.out.print("[ ");
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1)
			System.out.print(array[i] + ", ");
			else
				System.out.print(array[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}

}
