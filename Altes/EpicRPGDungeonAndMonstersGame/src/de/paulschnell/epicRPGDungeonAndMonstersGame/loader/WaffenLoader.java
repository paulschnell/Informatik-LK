package de.paulschnell.epicRPGDungeonAndMonstersGame.loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import de.paulschnell.epicRPGDungeonAndMonstersGame.Erpgdamg;
import de.paulschnell.epicRPGDungeonAndMonstersGame.Waffe;
import de.paulschnell.epicRPGDungeonAndMonstersGame.shop.ShopWaffenEntry;

public class WaffenLoader extends ObjectLoader {

	// Für Kommentare in HeldenLoader.java gucken
	
	private ArrayList<Waffe> waffen;

	public WaffenLoader(String fileSrc) throws IOException, FileNotFoundException {
		super(fileSrc);
	}

	@Override
	protected void read(String line) {
		if (waffen == null)
			waffen = new ArrayList<Waffe>();

		String[] split = line.split(" ");

		for (int i = 0; i < split.length; i++)
			split[i] = split[i].replace('-', ' ');

		try {
			waffen.add(new Waffe(split[0], Integer.valueOf(split[1]), split[2], Integer.valueOf(split[3]),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/" + split[4]));

			int i = Integer.valueOf(split[5]);
			if (i != 999)
				if (Erpgdamg.monster[i].getEntries()[2] == null)
					Erpgdamg.monster[i].setEntry(2,
							new ShopWaffenEntry(waffen.get(waffen.size() - 1), Integer.valueOf(split[6])));
				else
					Erpgdamg.monster[i].setEntry(3,
							new ShopWaffenEntry(waffen.get(waffen.size() - 1), Integer.valueOf(split[6])));
		} catch (NumberFormatException ex) {
			System.out.println("Es gab ein Problem beim Laden der Waffen.\n"
					+ "Stelle sicher, dass die Waffen richtig eingetragen sind.");
		}
	}

	public ArrayList<Waffe> get() {
		return waffen;
	}

}
