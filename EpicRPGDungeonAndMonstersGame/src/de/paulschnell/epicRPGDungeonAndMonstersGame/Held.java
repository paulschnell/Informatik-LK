package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Held {
	private String name;
	private int staerke;
	private int angriffswert;
	private int lebenspunkte;
	
	private Waffe waffe;

	public Held(String name, int staerke, int angriffswert, int lebenspunkte, Waffe waffe) {
		this.name = name;
		this.staerke = staerke;
		this.angriffswert = angriffswert;
		this.lebenspunkte = lebenspunkte;
		this.waffe = waffe;
	}
	
	void angreifen(Monster monster, Kampfregel kampfregel) {
		kampfregel.kampf(this, monster);
	}
	
	int angriffswertBerechnen() {
		return angriffswert + staerke + waffe.bonusBerechnen();
	}

	public int getStaerke() {
		return staerke;
	}

	public void setStaerke(int staerke) {
		this.staerke = staerke;
	}

	public String getName() {
		return name;
	}

	public int getAngriffswert() {
		return angriffswert;
	}

	public Waffe getWaffe() {
		return waffe;
	}

	public int getLebenspunkte() {
		return lebenspunkte;
	}

	public void setLebenspunkte(int lebenspunkte) {
		this.lebenspunkte = lebenspunkte;
	}
	
	
	
}
