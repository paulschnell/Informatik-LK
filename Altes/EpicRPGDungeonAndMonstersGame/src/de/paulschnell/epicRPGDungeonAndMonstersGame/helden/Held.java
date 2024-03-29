package de.paulschnell.epicRPGDungeonAndMonstersGame.helden;

import de.paulschnell.epicRPGDungeonAndMonstersGame.Kampfregel;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Monster;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Waffe;

public class Held {
	private String name;
	private int staerke;
	private int angriffswert;
	private int lebenspunkte;
	private int maxLebenspunkte;
	private String imgSource;

	private Waffe waffe;

	public Held(String name, int staerke, int angriffswert, int lebenspunkte, String imgSource) {
		this.name = name;
		this.staerke = staerke;
		this.angriffswert = angriffswert;
		this.lebenspunkte = lebenspunkte;
		this.maxLebenspunkte = lebenspunkte;
		this.waffe = waffe;
		this.imgSource = imgSource;
	}

	// erfolgreich? ja / nein
	public boolean ability() {
		return false;
	}

	public void angreifen(Monster monster, Kampfregel kampfregel) {
		kampfregel.kampf(this, monster);
	}

	public int angriffswertBerechnen() {
		if (waffe != null)
			return angriffswert + staerke + waffe.bonusBerechnen();
		else
			return angriffswert + staerke;
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

	public void setWaffe(Waffe waffe) {
		this.waffe = waffe;
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
