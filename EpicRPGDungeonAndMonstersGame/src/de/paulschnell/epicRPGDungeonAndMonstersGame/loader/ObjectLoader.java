package de.paulschnell.epicRPGDungeonAndMonstersGame.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ObjectLoader {

	private File file;

	public ObjectLoader(String fileSrc) throws IOException, FileNotFoundException {
		this.file = new File(fileSrc);

		FileInputStream fis = new FileInputStream(file); // Datei lesen
		int r = 0; // Aktueller Charakter/Byte
		String line = "";
		while ((r = fis.read()) != -1) { // Jeden Byte der Datei einzeln lesen
			char c = (char) r; // In Java char umwandeln
			
			// Wenn ein umsprung ist, soll read() ausgefuehrt und eine neue
			// Zeile in line gespeichert werden
			if ((r == 13 || r == 10) && !line.equals("")) { // 10, bzw, 13 ist der keycode fuer die enter taste

				read(line);

				line = "";
			}

			if (r != 13 && r != 10)
				line += c;
		}
		fis.close();
	}

	protected abstract void read(String line);

}
