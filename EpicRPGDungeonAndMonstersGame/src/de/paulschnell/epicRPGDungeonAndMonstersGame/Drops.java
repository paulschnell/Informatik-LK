package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Drops {
	private int minMünzen;
	private int maxMünzen;
	private float wahrWaffe;
	private Waffe waffe;

	public Drops(int minMünzen, int maxMünzen, float wahrWaffe, Waffe waffe) {
		this.minMünzen = minMünzen;
		this.maxMünzen = maxMünzen;
		this.wahrWaffe = wahrWaffe;
		this.waffe = waffe;
	}

	public int getMinMünzen() {
		return minMünzen;
	}

	public int getMaxMünzen() {
		return maxMünzen;
	}

	public float getWahrWaffe() {
		return wahrWaffe;
	}

	public Waffe getWaffe() {
		return waffe;
	}

	public int münzen() {
		return (int) (Math.random() * maxMünzen) + minMünzen;
	}

	public boolean dropWaffe() {
		float rng = (float) Math.random();
		return rng < wahrWaffe;
	}

}
