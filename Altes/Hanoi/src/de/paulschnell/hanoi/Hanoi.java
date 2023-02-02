package de.paulschnell.hanoi;

public class Hanoi {

	public static void main(String[] args) {
		Hanoi h = new Hanoi();
		
		h.hanoi(3, "A", "B", "C");
	}
	
	public void hanoi(int scheibenAnzahl, String start, String ablage, String ziel) {
		if (scheibenAnzahl == 1)
			System.out.println(start + " -> " + ziel);
		else {
			hanoi(scheibenAnzahl - 1, start, ziel, ablage);
			hanoi(scheibenAnzahl - 1, start, ablage, ziel);
			
		}
	}

}
