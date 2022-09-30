package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Drops {
	private int minM�nzen;
	private int maxM�nzen;
	private float wahrWaffe;
	private Waffe waffe;

	public Drops(int minM�nzen, int maxM�nzen, float wahrWaffe, Waffe waffe) {
		this.minM�nzen = minM�nzen;
		this.maxM�nzen = maxM�nzen;
		this.wahrWaffe = wahrWaffe;
		this.waffe = waffe;
	}

	public int getMinM�nzen() {
		return minM�nzen;
	}

	public int getMaxM�nzen() {
		return maxM�nzen;
	}

	public float getWahrWaffe() {
		return wahrWaffe;
	}

	public Waffe getWaffe() {
		return waffe;
	}

	public int m�nzen() {
		return (int) (Math.random() * maxM�nzen) + minM�nzen;
	}

	public boolean dropWaffe() {
		float rng = (float) Math.random();
		return rng < wahrWaffe;
	}

}
