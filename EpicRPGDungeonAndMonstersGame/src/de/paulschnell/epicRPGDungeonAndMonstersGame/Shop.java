package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Shop {

	private ShopEntry[] entries = new ShopEntry[4];

	public Shop() {
		
	}
	
	public void setEntry(int index, ShopEntry entry) {
		if (index >= 0 && index < entries.length)
			entries[index] = entry;
	}
	
	public ShopEntry getEntry(int index) {
		return entries[index];
	}

}
