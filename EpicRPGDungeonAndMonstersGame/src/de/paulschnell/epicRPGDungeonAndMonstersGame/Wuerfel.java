package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Wuerfel {
	private int seiten;

	public Wuerfel(int seiten) {
		this.seiten = seiten;
	}

	public int wuerfeln() {
		return (int) (Math.random() * seiten + 1);
	}

	public int getSeiten() {
		return seiten;
	}
}
