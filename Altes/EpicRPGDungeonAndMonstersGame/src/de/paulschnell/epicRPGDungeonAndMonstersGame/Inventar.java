package de.paulschnell.epicRPGDungeonAndMonstersGame;

import java.util.ArrayList;

import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Held;

public class Inventar {

	private ArrayList<Held> freigeschalteteHelden = new ArrayList<>();
	private ArrayList<Waffe> freigeschalteteWaffen = new ArrayList<>();

	private int gold = 0;

	public Inventar() {
	}

	public ArrayList<Held> getFreigeschalteteHelden() {
		return freigeschalteteHelden;
	}

	public ArrayList<Waffe> getFreigeschalteteWaffen() {
		return freigeschalteteWaffen;
	}

	public Held getHeld(int index) {
		return freigeschalteteHelden.get(index);
	}

	public void addHeld(Held held) {
		freigeschalteteHelden.add(held);
	}

	public Waffe getWaffe(int index) {
		return freigeschalteteWaffen.get(index);
	}

	public void addWaffe(Waffe waffe) {
		freigeschalteteWaffen.add(waffe);
	}

	public void addGold(int n) {
		gold += n;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getGold() {
		return gold;
	}

}
