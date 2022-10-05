package de.paulschnell.epicRPGDungeonAndMonstersGame.loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import de.paulschnell.epicRPGDungeonAndMonstersGame.Erpgdamg;
import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Held;
import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Krieger;
import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Magier;
import de.paulschnell.epicRPGDungeonAndMonstersGame.shop.ShopHeldenEntry;

public class HeldenLoader extends ObjectLoader {

	private ArrayList<Held> helden;

	public HeldenLoader(String fileSrc) throws IOException, FileNotFoundException {
		super(fileSrc);
	}

	@Override
	protected void read(String line) {
		if (helden == null) // super wird IMMER vor dem constructor und der klasse aufgerufen
			helden = new ArrayList<Held>();

		String[] split = line.split(" ");

		for (int i = 0; i < split.length; i++)
			split[i] = split[i].replace('-', ' ');

		try {
			switch (split[1]) {
			case "magier":
				helden.add(new Magier(split[0], Integer.valueOf(split[2]), Integer.valueOf(split[3]),
						Integer.valueOf(split[4]), "/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/" + split[5],
						Integer.valueOf(split[6])));
				break;
			case "krieger":
				helden.add(new Krieger(split[0], Integer.valueOf(split[2]), Integer.valueOf(split[3]),
						Integer.valueOf(split[4]), "/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/" + split[5],
						Integer.valueOf(split[6])));
				break;
			}

			int i = Integer.valueOf(split[7]);
			if (i != 999)
				if (Erpgdamg.monster[i].getEntries()[0] == null)					
					Erpgdamg.monster[i].setEntry(0,
							new ShopHeldenEntry(helden.get(helden.size() - 1), Integer.valueOf(split[8])));
				else
					Erpgdamg.monster[i].setEntry(1,
							new ShopHeldenEntry(helden.get(helden.size() - 1), Integer.valueOf(split[8])));
		} catch (NumberFormatException ex) {
			System.out.println("Es gab ein Problem beim Laden der Helden.\n"
					+ "Stelle sicher, dass die Helden richtig eingetragen sind.");
		}
	}

	public ArrayList<Held> get() {
		return helden;
	}

}
