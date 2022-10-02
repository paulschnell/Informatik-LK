package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Drops {
	private int minMuenzen;
	private int maxMuenzen;
	private float wahrWaffe;
	private Waffe waffe;

	public Drops(int minMuenzen, int maxMuenzen, float wahrWaffe, Waffe waffe) {
		this.minMuenzen = minMuenzen;
		this.maxMuenzen = maxMuenzen;
		this.wahrWaffe = wahrWaffe;
		this.waffe = waffe;
	}

	public int getMinMuenzen() {
		return minMuenzen;
	}

	public int getMaxMuenzen() {
		return maxMuenzen;
	}

	public float getWahrWaffe() {
		return wahrWaffe;
	}

	public Waffe getWaffe() {
		return waffe;
	}
	
	public void setWaffe(Waffe waffe) {
		this.waffe = waffe;
	}

	public int muenzen() {
		return (int) (Math.random() * maxMuenzen) + minMuenzen;
	}

	public boolean dropWaffe() {
		float rng = (float) Math.random();
		return rng < wahrWaffe;
	}

}
