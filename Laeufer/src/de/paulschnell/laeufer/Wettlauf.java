package de.paulschnell.laeufer;

public class Wettlauf {

	private Laeufer[] laeufer = new Laeufer[8];

	public static void main(String[] args) {
		Wettlauf wettlauf = new Wettlauf();

		wettlauf.anDenStart();
		wettlauf.rennenLaufen();

		int i0 = 0;
		int i1 = 0;
		for (int i = 1; i < wettlauf.getLaeufer().length; i++) {
			if (wettlauf.getLaeufer()[i0].getZeit() > wettlauf.getLaeufer()[i].getZeit()) {
				i1 = i0;
				i0 = i;
			} else if (wettlauf.getLaeufer()[i1].getZeit() > wettlauf.getLaeufer()[i].getZeit())
				i1 = i;
		}
		wettlauf.getLaeufer()[i0].setQualifiziert(true);
		wettlauf.getLaeufer()[i1].setQualifiziert(true);

		for (int i = 0; i < wettlauf.getLaeufer().length; i++) {
			System.out.println("Bahn " + i + ": " + wettlauf.getLaeufer()[i].getName() + " ist "
					+ String.format("%.4f", wettlauf.getLaeufer()[i].getZeit()) + "s gelaufen.");
		}
		
		System.out.println("Bahnen " + i0 + " und " + i1 + " sind qualifizerit.");
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

	public void zeitMessen(Laeufer laeufer) {
		laeufer.setZeit((double) (Math.random() * 10.0D + 10.0D));
	}

	public void rennenLaufen() {
		for (int i = 0; i < laeufer.length; i++) {
			zeitMessen(laeufer[i]);
		}
	}

	public Laeufer[] getLaeufer() {
		return laeufer;
	}

}
