package de.paulschnell.epicRPGDungeonAndMonstersGame.shop;

import de.paulschnell.epicRPGDungeonAndMonstersGame.Inventar;

public class Shop {
	
	private Inventar inv;

	private ShopHeldenEntry[] heldenEntries = new ShopHeldenEntry[2];
	private ShopWaffenEntry[] waffenEntries = new ShopWaffenEntry[2];

	public Shop(Inventar inv) {
		this.inv = inv;
	}
	
	public Inventar getInv() {
		return inv;
	}
	
	public void setHeldenEntry(int index, ShopHeldenEntry entry) {
		if (index >= 0 && index < heldenEntries.length)
			heldenEntries[index] = entry;
	}
	
	public ShopHeldenEntry getHeldenEntry(int index) {
		return heldenEntries[index];
	}
	
	public void setWaffenEntry(int index, ShopWaffenEntry entry) {
		if (index >= 0 && index < waffenEntries.length)
			waffenEntries[index] = entry;
	}
	
	public ShopWaffenEntry getWaffenEntry(int index) {
		return waffenEntries[index];
	}

}
