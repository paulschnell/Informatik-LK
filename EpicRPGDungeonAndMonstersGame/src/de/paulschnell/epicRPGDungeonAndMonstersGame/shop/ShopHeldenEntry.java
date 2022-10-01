package de.paulschnell.epicRPGDungeonAndMonstersGame.shop;

import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Held;

public class ShopHeldenEntry extends ShopEntry {

	private Held held;
	
	public ShopHeldenEntry(Held held, int kosten) {
		super(kosten);
		this.held = held;
	}
	
	public Held getHeld() {
		return held;
	}
	
}
