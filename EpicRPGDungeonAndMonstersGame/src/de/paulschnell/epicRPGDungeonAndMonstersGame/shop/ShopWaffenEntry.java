package de.paulschnell.epicRPGDungeonAndMonstersGame.shop;

import de.paulschnell.epicRPGDungeonAndMonstersGame.Waffe;

public class ShopWaffenEntry extends ShopEntry {

	private Waffe waffe;
	
	public ShopWaffenEntry(Waffe waffe, int kosten) {
		super(kosten);
		this.waffe = waffe;
	}
	
	public Waffe getWaffe() {
		return waffe;
	}
	
}
