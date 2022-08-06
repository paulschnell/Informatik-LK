package de.paulschnell.epicRPGDungeonAndMonstersGame;

public class Held {

	private final String name;
	private int staerke;
	private int angriffswert;
	private int lebenspunkte;
	
	public Held(String name, int staerke, int angriffswert, int lebenspunkte) {
		this.name = name;
		this.staerke = staerke;
		this.angriffswert = angriffswert;
		this.lebenspunkte = lebenspunkte;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStaerke() {
		return staerke;
	}
	
	public void setStaerke(int staerke) {
		this.staerke = staerke;
	}
	
	public int getAngriffswert() {
		return angriffswert;
	}
	
	public void setAngriffswert(int angriffswert) {
		this.angriffswert = angriffswert;
	}
	
	public int getLebenspunkte() {
		return lebenspunkte;
	}
	
	public void setLebenspunkte(int lebenspunkte) {
		this.lebenspunkte = lebenspunkte;
	}
	
	public void angreifen(Monster monster/*TODO: Kampfregel*/) {
		/*TODO: ANGREIFEN*/
	}
	
	public int angriffsWertBerechnen() {
		return angriffswert + staerke;
	}
		
}
