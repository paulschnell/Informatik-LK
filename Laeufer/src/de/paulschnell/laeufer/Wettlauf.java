package de.paulschnell.laeufer;

public class Wettlauf {

	private Laeufer[] laeufer = new Laeufer[8];

	public static void main(String[] args) {
		Wettlauf wettlauf = new Wettlauf();

		wettlauf.anDenStart();
		wettlauf.zeitMessen();
		wettlauf.rennenLaufen();

		for (int i = 0; i < wettlauf.getLaeufer().length; i++) {
			System.out.print(
					wettlauf.getLaeufer()[i].getName() + " ist " + wettlauf.getLaeufer()[i].getZeit() + " gelaufen. ");
			if (wettlauf.getLaeufer()[i].isQualifiziert())
				System.out.print("Er hat sich qualifiziert!");
			else
				System.out.print("Er hat sich nicht qualifiziert!");
			System.out.println("");
		}
	}

	public void anDenStart() {
		laeufer[0] = new Laeufer("Guenther");
		laeufer[1] = new Laeufer("Olaf");
		laeufer[2] = new Laeufer("Robert");
		laeufer[3] = new Laeufer("Manfred");
		laeufer[4] = new Laeufer("Frank");
		laeufer[5] = new Laeufer("Jeff");
		laeufer[6] = new Laeufer("Lebron James");
		laeufer[7] = new Laeufer("Elon");
	}

	public void zeitMessen() {
		for (int i = 0; i < laeufer.length; i++) {
			laeufer[i].setZeit((float) (Math.random() * 10.0D));
		}
	}

	public void rennenLaufen() {
		for (int i = 0; i < laeufer.length; i++) {
			if (laeufer[i].getZeit() > (float) (Math.random() * 10.0D))
				laeufer[i].setQualifiziert(true);
		}
	}

	public Laeufer[] getLaeufer() {
		return laeufer;
	}

}
