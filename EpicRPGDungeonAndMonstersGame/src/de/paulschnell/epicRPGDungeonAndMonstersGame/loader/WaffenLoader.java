package de.paulschnell.epicRPGDungeonAndMonstersGame.loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import de.paulschnell.epicRPGDungeonAndMonstersGame.Waffe;

public class WaffenLoader extends ObjectLoader {

	private ArrayList<Waffe> waffen;

	public WaffenLoader(String fileSrc) throws IOException, FileNotFoundException {
		super(fileSrc);
	}

	@Override
	protected void read(String line) {
		if (waffen == null) // super wird IMMER vor dem constructor und der klasse aufgerufen
			waffen = new ArrayList<Waffe>();

		String[] split = line.split(" ");
		try {
			waffen.add(new Waffe(split[0], Integer.valueOf(split[1]), split[2], Integer.valueOf(split[3]),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/" + split[4]));
		} catch (NumberFormatException ex) {
			System.out.println("Es gab ein Problem beim Laden der Waffen.\n"
					+ "Stelle sicher, dass die Waffen richtig eingetragen sind.");
		}
	}

	public ArrayList<Waffe> get() {
		return waffen;
	}

}
