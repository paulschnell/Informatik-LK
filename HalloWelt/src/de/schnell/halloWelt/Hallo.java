package de.schnell.halloWelt;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Hallo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2. Ausgabe
		System.out.println("Heinz Dieter.");

		// 3. Eingbe
		//System.out.println("Was ist dein Name?");
		//Scanner eingabe = new Scanner(System.in);
		//String name = eingabe.next();
		//System.out.println("Du bist also " + name + "!");
		//Eingabe.close();
		
		// 4. Dialog mit Schwung
		String name1 = JOptionPane.showInputDialog("Hallo, wer bist Du?");
		JOptionPane.showMessageDialog(null, "Hallo " + name1 + "!");
		
		// 5. Verzweigungen
		String antwort = JOptionPane.showInputDialog(name1 + ", wie geht es Dir? (gut oder schlecht)");
		
		if (antwort.equals("gut")) {
			JOptionPane.showMessageDialog(null, "Das freut mich!");
		} else if (antwort.equals("schlecht")) {
			JOptionPane.showMessageDialog(null, "Kopf hoch!");
		} else {
			JOptionPane.showMessageDialog(null, "Bitte schreibe 'gut' oder 'schlecht'.");
		}
	}

}
