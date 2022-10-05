package de.paulschnell.laeufer;

public class Laeufer {
	private String name;
	private float zeit;
	private boolean qualifiziert;
	
	public Laeufer(String name) {
		this.name = name;
		this.zeit = 0.0f;
		this.qualifiziert = false;
	}
	
	public String getName() {
		return name;
	}
	
	public void setZeit(float zeit) {
		this.zeit = zeit;
	}
	
	public float getZeit() {
		return zeit;
	}
	
	public void setQualifiziert(boolean qualifiziert) {
		this.qualifiziert = qualifiziert;
	}
	
	public boolean isQualifiziert() {
		return qualifiziert;
	}
}
