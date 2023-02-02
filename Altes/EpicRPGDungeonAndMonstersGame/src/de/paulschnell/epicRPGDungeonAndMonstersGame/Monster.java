package de.paulschnell.epicRPGDungeonAndMonstersGame;

import de.paulschnell.epicRPGDungeonAndMonstersGame.shop.ShopEntry;

public class Monster {
	private int angriffswert;
	private int lebenspunkte;
	private int maxLebenspunkte;
	private String name;
	private Drops drops;
	private String imgSource;
	
	private ShopEntry[] entries = new ShopEntry[4]; // items, die im shop sind, wenn dieses das aktuelle monster ist

	public Monster(int angriffswert, int lebenspunkte, String name, Drops drops, String imgSource) {
		this.angriffswert = angriffswert;
		this.lebenspunkte = lebenspunkte;
		this.maxLebenspunkte = lebenspunkte;
		this.name = name;
		this.drops = drops;
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

	public Drops getDrops() {
		return drops;
	}

	public ShopEntry[] getEntries() {
		return entries;
	}
	
	public void setEntry(int index, ShopEntry entry) {
		this.entries[index] = entry;
	}
	
}
