package de.paulschnell.epicRPGDungeonAndMonstersGame;

import java.io.IOException;

import de.paulschnell.epicRPGDungeonAndMonstersGame.loader.HeldenLoader;
import de.paulschnell.epicRPGDungeonAndMonstersGame.loader.WaffenLoader;
import de.paulschnell.epicRPGDungeonAndMonstersGame.windows.Window;

public class EpicRPGDungeonAndMonstersGame {

	// Für den Verlauf des Projektes und falls irgendwelche Probleme mit den Bilder
	// o. A. auftreten sollten:
	// https://github.com/erwartet/Informatik-LK/tree/main/EpicRPGDungeonAndMonstersGame

	// TODO: Shop items einfügen
	
	public static Window frame;
	public static HeldenLoader heldenLoader;
	public static WaffenLoader waffenLoader;

	public static void main(String[] args) {
		try {
			heldenLoader = new HeldenLoader("helden.txt");
			waffenLoader = new WaffenLoader("waffen.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		frame = new Window();
		frame.run();
	}

}
