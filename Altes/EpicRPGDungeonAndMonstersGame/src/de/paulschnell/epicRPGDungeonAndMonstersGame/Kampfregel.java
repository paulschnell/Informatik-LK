package de.paulschnell.epicRPGDungeonAndMonstersGame;

import de.paulschnell.epicRPGDungeonAndMonstersGame.helden.Held;

public class Kampfregel {
	private Wuerfel wuerfel6;
	private Wuerfel wuerfel10;

	public Kampfregel() {
		this.wuerfel6 = new Wuerfel(6);
		this.wuerfel10 = new Wuerfel(10);
	}

	public void kampf(Held held, Monster monster) {
		int wertHeld = held.angriffswertBerechnen() * wuerfel6.wuerfeln();
		int wertMonster = monster.getAngriffswert() * wuerfel10.wuerfeln();

		if (wertHeld > wertMonster) {
			monster.setLebenspunkte(monster.getLebenspunkte() - 10);
		} else {
			held.setLebenspunkte(held.getLebenspunkte() - 10);
			if (held.getStaerke() > 0)
				held.setStaerke(held.getStaerke() - 2);
		}
	}
}
