package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Waffe {
	private String name;
	private int bonus;
	private String material;
	private int magie;
	private String imgSource;

	public Waffe(String name, int bonus, String material, int magie, String imgSource) {
		this.name = name;
		this.bonus = bonus;
		this.material = material;
		this.magie = magie;
		this.imgSource = imgSource;
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
		case "Gold":
			bonus += 3;
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
}
