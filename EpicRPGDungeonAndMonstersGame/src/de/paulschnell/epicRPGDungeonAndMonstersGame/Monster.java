package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Monster {

	private final int angriffswert;
	private int lebenspunkte;
	
	public Monster(int angriffswert, int lebenspunkte) {
		super();
		this.angriffswert = angriffswert;
		this.lebenspunkte = lebenspunkte;
	}
	
	public int getAngriffswert() {
		return angriffswert;
	}
	
	public int getLebenspunkte() {
		return lebenspunkte;
	}
	
}
