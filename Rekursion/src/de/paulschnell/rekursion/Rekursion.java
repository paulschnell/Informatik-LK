package de.paulschnell.rekursion;

public class Rekursion {

	public static void main(String[] args) {
		Rekursion m = new Rekursion();
//		int n = 11;
//		System.out.println(m.rekFib(n));
//		System.out.println(m.itFib(n));
//		
//		for (int i = 1; i <= 46; i++) {
//			System.out.println(i + " " + m.rekFib(i));
//		}
		
		m.rekFib(100000000);
	}
	
	
	
	// Aufgabe 1
	int rekFak(int n) {		// foo-Methode
		if (n == 0)
			return 1;
		else
			return rekFak(n - 1) * n;
	}
	
	int itFak(int n) {
		int wert = 1;
		for (int i = 2; i <= n; i++)
			wert *= i;
		return wert;
	}
	
	
	
	// Aufgabe 2
	int rekSum(int n) {
		if (n == 0)
			return 1;
		else
			return rekSum(n - 1) + n;
	}
	
	int itSum(int n) {
		int wert = 1;
		for (int i = 2; i <= n; i++)
			wert += i;
		return wert;
	}
	
	
	
	// Aufgabe 3
	int rekFib(int n) {
		if (n == 1 || n == 2)
			return 1;
		else
			return rekFib(n - 1) + rekFib(n - 2);
	}
	
	int itFib(int n) {
		return 0;
	}

}
