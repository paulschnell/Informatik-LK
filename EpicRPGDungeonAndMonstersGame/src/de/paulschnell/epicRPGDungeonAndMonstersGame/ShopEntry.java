package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class ShopEntry {

	private int kosten;
	private boolean gekauft = false;
	
	public ShopEntry(int kosten) {
		this.kosten = kosten;
	}

	public int getKosten() {
		return kosten;
	}

	public boolean isGekauft() {
		return gekauft;
	}
	
	public void setGekauft() {
		gekauft = true;
	}
	
}
