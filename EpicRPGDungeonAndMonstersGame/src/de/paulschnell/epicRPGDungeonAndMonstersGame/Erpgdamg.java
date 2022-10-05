package de.paulschnell.epicRPGDungeonAndMonstersGame;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;

import de.paulschnell.epicRPGDungeonAndMonstersGame.loader.HeldenLoader;
import de.paulschnell.epicRPGDungeonAndMonstersGame.loader.WaffenLoader;
import de.paulschnell.epicRPGDungeonAndMonstersGame.windows.Window;

public class Erpgdamg {

	// Fuer den Verlauf des Projektes und falls irgendwelche Probleme mit den Bilder
	// o. A. auftreten sollten:
	// https://github.com/erwartet/Informatik-LK/tree/main/EpicRPGDungeonAndMonstersGame

	// TODO: Shop items einfuegen

	public static Window frame;
	public static HeldenLoader heldenLoader;
	public static WaffenLoader waffenLoader;

	public static Monster[] monster = new Monster[] {
			new Monster(5, 100, "Guenther und seine Crew von Olaf", new Drops(1, 300, 0.0f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/g\u00FCnther_und_seine_crew_von_olaf.gif"),
			new Monster(10, 100, "Der schreckliche Sven", new Drops(2, 5, 0.0f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/der_schreckliche_sven.jpg"),
			new Monster(20, 100, "Lord Garmadon", new Drops(8, 20, 0.8f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/lord_garmadon.jpg"),
			new Monster(20, 100, "Der Fliegende Hollaender", new Drops(15, 20, 0.0f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/der_fliegende_hollander.png"),
			new Monster(25, 100, "Evil Morty", new Drops(20, 30, 0.0f, null),
					"/de/paulschnell/epicRPGDungeonAndMonstersGame/bilder/evil_morty.jpg") };

	public static void main(String[] args) {
		try {
			heldenLoader = new HeldenLoader("objects/helden.txt");
			waffenLoader = new WaffenLoader("objects/waffen.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		monster[2].getDrops().setWaffe(Erpgdamg.waffenLoader.get().get(0));
		monster[3].getDrops().setWaffe(Erpgdamg.waffenLoader.get().get(1));

		frame = new Window();
		frame.run();
	}

	public static ImageIcon pasteImage(URL url, int width, int height) {
		return new ImageIcon(
				new javax.swing.ImageIcon(url).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}

}
