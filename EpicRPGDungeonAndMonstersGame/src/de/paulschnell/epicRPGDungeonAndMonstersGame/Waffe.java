package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Waffe {
	private String name;
	private int bonus;
	private String material;
	private int magie;
	private String imgSource;
	private Held[] moeglicheHelden;

	public Waffe(String name, int bonus, String material, int magie, String imgSource, Held... moeglicheHelden) {
		this.name = name;
		this.bonus = bonus;
		this.material = material;
		this.magie = magie;
		this.imgSource = imgSource;
		this.moeglicheHelden = moeglicheHelden;
	}

	public int bonusBerechnen() {
		switch (material) {
		case "Stein":
			bonus += 2;
			break;
		case "Diamant":
			bonus += 5;
			break;
		case "Holz":
			bonus += 1;
			break;
		case "Schwarzeichenholz":
			bonus += 5;
			break;
		default:
			break;
		}

		bonus += magie;
		return bonus;
	}
	
	public String getName() {
		return name;
	}

	public int getBonus() {
		return bonus;
	}

	public String getMaterial() {
		return material;
	}

	public int getMagie() {
		return magie;
	}

	public String getImgSource() {
		return imgSource;
	}

	public Held[] getMoeglicheHelden() {
		return moeglicheHelden;
	}

	public boolean kannTragen(Held held) {
		for (int i = 0; i < moeglicheHelden.length; i++)
			if (moeglicheHelden[i] == held)
				return true;
		return false;
	}
}
