package de.paulschnell.arrays;

public class Arrays {

	public static void main(String[] args) {
		Arrays arrays = new Arrays();
		arrays.aufgabe1();
	}

	void aufgabe1() {
		int[] liste = new int[100];		
		for (int i = 0; i < liste.length; i++) {
			liste[i] = i;
			System.out.print(liste[i] + " ");
		}
	}

	void aufgabe2() {
		int[] liste = new int[1000];
		for (int i = 0; i < liste.length; i++) {
			liste[i] = 2 * i;
			System.out.print(liste[i] + " ");
		}
	}

	void aufgabe3() {
		String[] liste = new String[30];
		for (int i = 0; i < liste.length; i++) {
			if (i < 10)
				liste[i] = "A";
			else
				liste[i] = "B";
			System.out.print(liste[i] + " ");
		}
	}
	
	void aufgabe4() {
		int[] liste = new int[1000];
		for (int i = 0; i < liste.length; i++) {
			liste[i] = (int) (Math.random() * 100);
			System.out.print(liste[i] + " ");
		}
	}
	
	void aufgabe5() {
		int[] liste = new int[100];
		for (int i = 0; i < liste.length; i++) {
			liste[i] = 17;
			System.out.print(liste[i] + " ");
		}
	}

}
