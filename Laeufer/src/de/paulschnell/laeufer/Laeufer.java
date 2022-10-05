package de.paulschnell.laeufer;

public class Laeufer {
	private String name;
	private double zeit;
	private boolean qualifiziert;
	
	public Laeufer(String name) {
		this.name = name;
		this.zeit = 0.0D;
		this.qualifiziert = false;
	}
	
	public String getName() {
		return name;
	}
	
	public void setZeit(double zeit) {
		this.zeit = zeit;
	}
	
	public double getZeit() {
		return zeit;
	}
	
	public void setQualifiziert(boolean qualifiziert) {
		this.qualifiziert = qualifiziert;
	}
	
	public boolean isQualifiziert() {
		return qualifiziert;
	}
}
