package de.paulschnell.bubblesort;

public class BubbleSort {

	public static void main(String[] args) {
		
		BubbleSort b = new BubbleSort();
		
		int[] liste = b.listeAnlegen(100);
//		b.printArray(liste);
		
		int[] sortiert;
		
		long time1 = System.nanoTime();
		sortiert = b.optimiertSortieren(liste);
		long time2 = System.nanoTime();
		long timeDiff = time2 - time1;
		
//		b.printArray(sortiert);
		System.out.println("%.6f ms".formatted(timeDiff * 1e-6));
	}
	
	int[] listeAnlegen(int groesse) {
		int[] liste = new int[groesse];
		for (int i = 0; i < groesse; i++) {
			liste[i] = (int) (Math.random() * 100);
		}
		return liste;
	}
	
	int[] sortieren(int[] liste) {
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
	
	int[] optimiertSortieren(int[] liste) {
		boolean aenderung;

		int[] liste1 = liste;
		for (int n = 0; n < liste1.length - 1; n++) {
			aenderung = false;
			for (int m = 0; m < liste1.length - n - 1; m++) {
				if (liste1[m] > liste1[m + 1]) {
					int hilf = liste1[m + 1];
					liste1[m + 1] = liste1[m];
					liste1[m] = hilf;
					aenderung = true;
				}
			}
			if (!aenderung)
				break;
		}
		return liste1;
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
