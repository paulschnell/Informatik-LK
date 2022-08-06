package de.paulschnell.schule;

public class Schule {
	
	public static void main(String[] args) {
		Schule schule = new Schule();
		schule.init();
	}
	
	public void init() {
		Schueler patrick = new Schueler("Patrick", "Star", "Seestern", "Schneckenstraﬂe", 120, 12345, "Bikini Bottom", 2, "26.02.1986");
		System.out.println(patrick.print());
	}

}
