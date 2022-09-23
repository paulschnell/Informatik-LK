package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Monster {
	private int angriffswert;
	private int lebenspunkte;
	private int maxLebenspunkte;
	private String name;
	private String imgSource;
	
	public Monster(int angriffswert, int lebenspunkte, String name, String imgSource) {
		this.angriffswert = angriffswert;
		this.lebenspunkte = lebenspunkte;
		this.maxLebenspunkte = lebenspunkte;
		this.name = name;
		this.imgSource = imgSource;
	}

	public int getAngriffswert() {
		return angriffswert;
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
	
	public String getName() {
		return name;
	}

	public String getImgSource() {
		return imgSource;
	}

	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}
	
}
