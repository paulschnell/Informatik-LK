package de.paulschnell.epicRPGDungeonAndMonstersGame;

import java.io.IOException;

import de.paulschnell.epicRPGDungeonAndMonstersGame.loader.HeldenLoader;
import de.paulschnell.epicRPGDungeonAndMonstersGame.loader.WaffenLoader;
import de.paulschnell.epicRPGDungeonAndMonstersGame.windows.Window;

public class EpicRPGDungeonAndMonstersGame {

	// F�r den Verlauf des Projektes und falls irgendwelche Probleme mit den Bilder
	// o. A. auftreten sollten:
	// https://github.com/erwartet/Informatik-LK/tree/main/EpicRPGDungeonAndMonstersGame

	// TODO: Shop items einf�gen

	public static Window frame;
	public static HeldenLoader heldenLoader;
	public static WaffenLoader waffenLoader;

	public static Monster[] monster = new Monster[] {
			new Monster(5, 100, "G�nther und seine Crew von Olaf", new Drops(1, 3, 0.0f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/g\u00FCnther_und_seine_crew_von_olaf.gif"),
			new Monster(10, 100, "Der schreckliche Sven", new Drops(2, 5, 0.0f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/der_schreckliche_sven.jpg"),
			new Monster(15, 100, "OpTic Gaming", new Drops(5, 10, 0.2f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/optic_gaming.png"),
			new Monster(20, 100, "Lord Garmadon", new Drops(8, 20, 0.8f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/lord_garmadon.jpg"),
			new Monster(20, 100, "Der Fliegende Holl�nder", new Drops(15, 20, 0.0f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/der_fliegende_hollander.png"),
			new Monster(25, 100, "Evil Morty", new Drops(20, 30, 0.0f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/evil_morty.jpg"),
			new Monster(30, 100, "this guy", new Drops(100, 100, 0.0f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/this_guy.jpg") };

	public static void main(String[] args) {
		try {
			heldenLoader = new HeldenLoader("objects/helden.txt");
			waffenLoader = new WaffenLoader("objects/waffen.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		monster[2].getDrops().setWaffe(EpicRPGDungeonAndMonstersGame.waffenLoader.get().get(0));
		monster[3].getDrops().setWaffe(EpicRPGDungeonAndMonstersGame.waffenLoader.get().get(1));

		frame = new Window();
		frame.run();
	}

}
