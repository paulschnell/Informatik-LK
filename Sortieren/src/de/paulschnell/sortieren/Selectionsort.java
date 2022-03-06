package de.paulschnell.sortieren;

public class Selectionsort {

	public static void main(String[] args) {
		
		final int n = 100; // Länge des Arrays
		int[] A = new int[n]; // Erstellen der Liste A vom Typ Integer der Länge n
		
		// Anlegen des Arrays
		for (int i = 0; i < n; i++) {
			// Zufälligen Wert an Stelle i setzten
			A[i] = (int) (Math.random() * 100);
		}
		
		// Ausgeben des Arrays
		for (int i = 0; i< n; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
		
		// Erster Zeitpunkt
		long p1 = System.nanoTime();
		
		
		// Benötogte Werte
		int minIndex;
		int hilf; // für Dreickekstausch
		
		// Sortieren durch Auswahl
		
		for (int d = 0; d < n - 1; d++) {
			minIndex = d;
			// Innere Schleife -> einzelne Stellen des Arrays durchlaufen
			for (int i = d + 1; i < n; i++) {
				// Finde Index des kleinsten Wertes im Array
				if (A[i] < A[minIndex]) {
					// Speichern der Stelle
					minIndex = i;
				}
			}
			
			// Tauschen der Werte
			hilf = A[d];
			A[d] = A[minIndex];
			A[minIndex] = hilf;
		}
		
		
		// Zeitpunkt 2
		long p2 = System.nanoTime();
		
		
		// Ausgeben des Arrays
		for (int i = 0; i< n; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
		
		// Zeitdifferenz
		long diff = p2 - p1;
		System.out.println("%.6f ms".formatted(diff * 1e-6));
	}
	
}
