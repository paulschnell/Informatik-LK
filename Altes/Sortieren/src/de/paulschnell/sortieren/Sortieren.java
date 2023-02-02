package de.paulschnell.sortieren;

public class Sortieren {
	
	public static void main(String[] args) {
		Sortieren m = new Sortieren();
		final int laenge = 100;
		
		int[] liste = m.listeAnlegen(laenge);
	}
	
	int[] listeAnlegen(int groesse) {
		int[] liste = new int[groesse];
		for (int i = 0; i < groesse; i++) {
			liste[i] = (int) (Math.random() * 100);
		}
		return liste;
	}
	
	int[] bubbleSort(int[] liste) {
		int[] liste1 = liste;
		for (int n = 0; n < liste1.length; n++) {
			for (int m = 0; m < liste1.length - 1; m++) {
				if (liste1[m] > liste1[m + 1]) {
					int hilf = liste1[m + 1];
					liste1[m + 1] = liste1[m];
					liste1[m] = hilf;
				}
			}
		}
		return liste1;
	}
	
	int[] selectionSort(int[] liste) {
		int minIndex;
		int hilf;
		
		for (int d = 0; d < liste.length - 1; d++) {
			minIndex = d;
			for (int i = d + 1; i < liste.length; i++) {
				if (liste[i] < liste[minIndex]) {
					// Speichern der Stelle
					minIndex = i;
				}
			}
			
			// Tauschen der Werte
			hilf = liste[d];
			liste[d] = liste[minIndex];
			liste[minIndex] = hilf;
		}
		
		return liste;
	}
	
	int[] insertionSort(int[] liste) {
		int temp;
		for (int i = 1; i < liste.length; i++) {
			for (int j = i; j > 0 && liste[j - 1] > liste[j]; j--) {
				temp = liste[j - 1];
				liste[j - 1] = liste[j];
				liste[j] = temp;
			}
		}

		return liste;
	}

}
