package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Wuerfel {
	final int anzahlSeiten;
	
	public Wuerfel(int anzahlSeiten) {
		this.anzahlSeiten = anzahlSeiten;
	}
	
	public int wuerfeln() {
		return (int) (Math.random() * anzahlSeiten) + 1;
	}
	
	public int getAnzahlSeiten() {
		return anzahlSeiten;
	}
}
