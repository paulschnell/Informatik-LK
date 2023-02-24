package de.paulschnell.caesar;

public class CHeating {

	public static void main(String[] args) {
		String input = "Hyhnvyu'lps{l'~lp{ly'klu'Ilyn'o";
		StringBuilder result = new StringBuilder();
		int key = 121;
		for (int i = 0; i < input.length(); i++) {
			int c = (int)(input.charAt(i)) + key;
			if (c > 127) {
				result.append((char)(c - 128));
			} else {
				result.append(c);
			}
		}
		System.out.println(result.toString());

	}

}
