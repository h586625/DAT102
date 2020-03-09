package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import no.hvl.dat102.stabel.adt.StabelADT;
import no.hvl.dat102.stabel.tabell.TabellStabel;

public class Balansering {
	StabelADT<Parentesinfo>syntaksStabel = new TabellStabel<Parentesinfo>();

	private boolean passer(char åpent, char lukket) {
		switch (åpent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {
		int lengde = innDataStreng.length();
		StabelADT<Character>parentesStabel = new TabellStabel<Character>();

		for (int i = 0; i < lengde; i++) {
			char tegn = innDataStreng.charAt(i);

			// Push if it's a starting parenthesis
			if (tegn == '{' || tegn == '(' || tegn == '[') {
				parentesStabel.push(tegn);
			}

			// If the character is an ending parenthesis
			// then pop from stack and check if the
			// popped parenthesis is a matching pair
			if (tegn == '}' || tegn == ')' || tegn == ']') {

				// If we see an ending parenthesis without
				// a pair then return false
				if (parentesStabel.erTom()) {
					System.out.println("Lukkesymbol ] på linje nr x, tegn nr y har feil åpnesymbol");
				}

				// Pop the top element from stack, if
				// it is not a pair parenthesis of character
				// then there is a mismatch. This happens for
				// expressions like {(})
				else if (!passer(parentesStabel.pop(), tegn)) {
					System.out.println("Lukkesymbol ] på linje nr x, tegn nr y har feil åpnesymbol");
				}
			}
		}
	}// foretaBalansering

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ike filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				// kalle metode her!
				// Fyll ut

			} // while
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// lesFraFil

}// class
