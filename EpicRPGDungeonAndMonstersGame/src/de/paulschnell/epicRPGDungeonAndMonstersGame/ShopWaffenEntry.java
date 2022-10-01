package de.paulschnell.epicRPGDungeonAndMonstersGame;

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
