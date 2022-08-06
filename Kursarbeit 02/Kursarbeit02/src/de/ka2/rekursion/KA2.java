package de.ka2.rekursion;

// Name: Paul Schnell füge deinen Namen hier ein!

public class KA2 {

	public static void main(String[] args) {
		
		KA2 k = new KA2();
		System.out.println("Fakultät: "+k.fakultaet(5));	//120
		System.out.println("Summe: "+k.summe(100));	//5050
		System.out.println("Potenz: "+k.potenz(2, 3));	//8
		System.out.println("Binomialkoeffizient: "+ k.binKoeff(9, 4));//126

	}

	//1.1 Fakultät einer natürlichen Zahl n (rekursiv)
	int fakultaet (int n) {
		if (n == 0)
			return 1;
		else
			return fakultaet(n - 1) * n;
	}
	
	//1.2 Summe der ersten n natürlichen Zahlen (rekursiv)
	int summe (int n) {
		if (n == 0)
			return 0;
		else
			return summe(n - 1) + n;
	}
	
	//2. Potenz der Zahlen x und y mit x hoch y (rekursiv)
	int potenz(int x, int y) {
		if (y == 0)	
			return 1;
		else
			return x * potenz(x, y - 1);
	}
	
	//3. Binomialkoeffizient zweier natürlichen Zahlen n und k (rekursiv ;) )
	int binKoeff(int n, int k) {
		if (k == 0 || k == n)
			return 1;
		else
			return binKoeff(n - 1, k) + binKoeff(n - 1, k - 1);
	}
	
	
}



