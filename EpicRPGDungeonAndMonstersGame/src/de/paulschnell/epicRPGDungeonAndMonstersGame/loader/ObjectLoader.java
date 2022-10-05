package de.paulschnell.epicRPGDungeonAndMonstersGame.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ObjectLoader {

	private File file;

	public ObjectLoader(String fileSrc) throws IOException, FileNotFoundException {
		this.file = new File(fileSrc);

		FileInputStream fis = new FileInputStream(file);
		int r = 0;
		String line = "";
		while ((r = fis.read()) != -1) {
			char c = (char) r;
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

	protected File getFile() {
		return file;
	}

}
