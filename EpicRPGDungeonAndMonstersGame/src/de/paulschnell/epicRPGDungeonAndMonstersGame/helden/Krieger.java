package de.paulschnell.epicRPGDungeonAndMonstersGame.helden;

public class Krieger extends Held {

	private int ausdauer;
	
	public Krieger(String name, int staerke, int angriffswert, int lebenspunkte, String imgSource, int ausdauer) {
		super(name, staerke, angriffswert, lebenspunkte, imgSource);
		this.ausdauer = ausdauer;
	}
	
	public void erhohlen() {
		ausdauer += 1;
	}
	
	public int angriffswertBerechnen() {
		if (getWaffe() != null)
			return getAngriffswert() + getStaerke() + getWaffe().bonusBerechnen() + ausdauer;
		else
			return getAngriffswert() + getStaerke() + ausdauer;
	}

	public int getAusdauer() {
		return ausdauer;
	}

	public void setAusdauer(int ausdauer) {
		this.ausdauer = ausdauer;
	}
	
}
