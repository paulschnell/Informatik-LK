package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Waffe {

	private final int bonus;
	private final String material;
	private final int magie;
	
	public Waffe(int bonus, String material, int magie) {
		this.bonus = bonus;
		this.material = material;
		this.magie = magie;
	}
	
	public int bonusBerechnen() {
		return bonus;
	}
	
}
