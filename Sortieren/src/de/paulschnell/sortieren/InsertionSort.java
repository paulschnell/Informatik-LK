package de.paulschnell.sortieren;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort m = new InsertionSort();

		int[] liste = m.listeAnlegen(100);

		m.printArray(liste);

		long time1 = System.nanoTime();
		int[] sortiert = m.insertionSort(liste);
		long time2 = System.nanoTime();
		long timeDiff = time2 - time1;

		m.printArray(sortiert);
		System.out.println("%.6f ms".formatted(timeDiff * 1e-6));
	}

	int[] listeAnlegen(int groesse) {
		int[] liste = new int[groesse];
		for (int i = 0; i < groesse; i++) {
			liste[i] = (int) (Math.random() * 100);
		}
		return liste;
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
