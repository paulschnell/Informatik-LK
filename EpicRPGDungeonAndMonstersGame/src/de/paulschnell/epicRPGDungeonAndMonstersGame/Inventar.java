package de.paulschnell.epicRPGDungeonAndMonstersGame;

import java.util.ArrayList;

public class Inventar {
	
	private ArrayList<Held> freigeschalteteHelden = new ArrayList<>();
	private ArrayList<Waffe> freigeschalteteWaffen = new ArrayList<>();
	
	public Inventar() {
		freigeschalteteHelden.add(new Held("Erik", 2, 1, 100, "/de/paulschnell/epicRPGDungeonAndMonstersGame/erik.png"));
		freigeschalteteHelden.add(new Held("Loud", 3, 2, 100, "/de/paulschnell/epicRPGDungeonAndMonstersGame/loud.png"));
		
		freigeschalteteWaffen.add(new Waffe("Revolver", 5, "Diamant", 0, "/de/paulschnell/epicRPGDungeonAndMonstersGame/revolver.png"));
		freigeschalteteWaffen.add(new Waffe("pancada", 6, "Stein", 0, "/de/paulschnell/epicRPGDungeonAndMonstersGame/pancada.jpg"));
	}

	public ArrayList<Held> getFreigeschalteteHelden() {
		return freigeschalteteHelden;
	}

	public ArrayList<Waffe> getFreigeschalteteWaffen() {
		return freigeschalteteWaffen;
	}
	
}
