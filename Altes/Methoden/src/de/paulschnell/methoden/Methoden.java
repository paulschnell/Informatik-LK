package de.paulschnell.methoden;

public class Methoden {
	
	/* Schreiben Sie ein Programm, das es dem Benutzer erm�glicht, zwischen folgenden Berechnungen zu w�hlen:
	1   printMax(a,b)
	2   printMax(a,b,c)
	3   printSqrt(x)
	4   Vorzeichen bestimmen einer Zahl x
	5   BMI berechnen
	6   Umfang eines Dreiecks
	7   Fl�che eines Quadrats
	Programmieren Sie f�r jede der 7 M�glichkeiten eine eigene Methode.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Methoden methoden = new Methoden();
		methoden.printSqrt(16);
		methoden.printVorzeichen(-1298419834);
		methoden.printBMI(60, 1.7);
		methoden.printDreieckUmfang(3, 3, 4);
		methoden.printFlaecheQuadrat(8);
	}
	
	void printMax(double a, double b) {
		if (a < b) {
			System.out.println(b);
		} else {
			System.out.println(a);
		}
	}
	
	void printMax(double a, double b, double c) {
		if (a > b) {
			if (a > c) {
				System.out.println(a);
			} else {
				System.out.println(c);
			}
		} else {
			if (b > c) {
				System.out.println(b);
			} else {
				System.out.println(c);
			}
		}
	}
	
	void printSqrt(double x) {
		System.out.println(Math.sqrt(x));
	}
	
	void printVorzeichen(double y) {		
		String s;
		if (y >= 0) {
			s = "+";
		} else {
			s = "-";
		}
		System.out.println(s);
	}
	
	/**
	 * @param gewicht in kg
	 * @param groe�e in m
	 */
	void printBMI(double gewicht, double groe�e) {
		double bmi = gewicht / (groe�e * groe�e);
		System.out.println(bmi);
	}
	
	void printDreieckUmfang(double a, double b, double c) {
		System.out.println(a + b + c);
	}
	
	void printFlaecheQuadrat(double x) {
		System.out.println(x * x);
	}

}
