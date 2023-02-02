package de.paulschnell.epicRPGDungeonAndMonstersGame.helden;

public class Magier extends Held {
	
	private int zauberkraft;

	public Magier(String name, int staerke, int angriffswert, int lebenspunkte, String imgSource, int zauberkraft) {
		super(name, staerke, angriffswert, lebenspunkte, imgSource);
		this.zauberkraft = zauberkraft;
	}
	
	public boolean ability() {
		if (getLebenspunkte() >= getMaxLebenspunkte())
			return false;

		if (zauberkraft < 2)
			return false;

		setLebenspunkte(getLebenspunkte() + 10);
		if (getLebenspunkte() > getMaxLebenspunkte())
			setLebenspunkte(getMaxLebenspunkte());
		zauberkraft -= 2;
		return true;
	}
	
	public void aufladen() {
		zauberkraft++;
	}

	public int getZauberkraft() {
		return zauberkraft;
	}

	public void setZauberkraft(int zauberkraft) {
		this.zauberkraft = zauberkraft;
	}

}
