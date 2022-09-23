package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Held {
	private String name;
	private int staerke;
	private int angriffswert;
	private int lebenspunkte;
	private int maxLebenspunkte;
	private String imgSource;
	
	private Waffe waffe;

	public Held(String name, int staerke, int angriffswert, int lebenspunkte, Waffe waffe, String imgSource) {
		this.name = name;
		this.staerke = staerke;
		this.angriffswert = angriffswert;
		this.lebenspunkte = lebenspunkte;
		this.maxLebenspunkte = lebenspunkte;
		this.waffe = waffe;
		this.imgSource = imgSource;
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
	
	public int getMaxLebenspunkte() {
		return maxLebenspunkte;
	}

	public String getImgSource() {
		return imgSource;
	}
	
}
