package de.paulschnell.schule;

public class Schueler {

	private String vorname;
	private String name;
	private String geschlecht;
	private String strasse;
	private int nummber;
	private int plz;
	private String ort;
	private int jgs;
	private String geburtsdatum;

	public Schueler(String vorname, String name, String geschlecht, String strasse, int nummber, int plz, String ort,
			int jgs, String geburtsdatum) {
		this.vorname = vorname;
		this.name = name;
		this.geschlecht = geschlecht;
		this.strasse = strasse;
		this.nummber = nummber;
		this.plz = plz;
		this.ort = ort;
		if (jgs > 0 && jgs <= 13)
			this.jgs = jgs;
		else
			this.jgs = 0;
		this.geburtsdatum = geburtsdatum;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getNummber() {
		return nummber;
	}

	public void setNummber(int nummber) {
		this.nummber = nummber;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getJgs() {
		return jgs;
	}

	public void setJgs(int jgs) {
		if (jgs > 0 && jgs <= 13)
			this.jgs = jgs;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	public void versetzen() {
		if (jgs < 13)
			jgs++;
	}
	
	public String print() {
		return "Name: " + vorname + " " + name + "\nGeschlecht: " + geschlecht + "\nAdresse: " + strasse + " " + nummber + ", " + plz + " " + ort + "\nJahrgangsstufe: " + jgs + "\nGeburtsdatum: " + geburtsdatum + "\n";
	}

}
