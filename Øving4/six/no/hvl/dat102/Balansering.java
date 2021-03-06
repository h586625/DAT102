package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import no.hvl.dat102.stabel.adt.StabelADT;
import no.hvl.dat102.stabel.tabell.TabellStabel;

public class Balansering {
	StabelADT<Parentesinfo>syntaksStabel = new TabellStabel<Parentesinfo>();
	private boolean feil = false;

	private boolean passer(char �pent, char lukket) {
		switch (�pent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}

	public void foretaBalansering(String innDataStreng, int linjenr) {
		int lengde = innDataStreng.length();

		for (int i = 0; i < lengde; i++) {
			char parentes = innDataStreng.charAt(i);

			// Push if it's a starting parenthesis
			if (parentes == '{' || parentes == '(' || parentes == '[') {
				syntaksStabel.push(new Parentesinfo(linjenr, i, parentes));
			}

			// If the character is an ending parenthesis
			// then pop from stack and check if the
			// popped parenthesis is a matching pair
			if (parentes == '}' || parentes == ')' || parentes == ']') {
				// If we see an ending parenthesis without
				// a pair then return false
				if (syntaksStabel.erTom()) {
					feil = true;
					System.out.println(
							new Parentesinfo(linjenr, i+1, parentes).toStringTomStabel()
							);
				}
				// Pop the top element from stack, if
				// it is not a pair parenthesis of character
				// then there is a mismatch. This happens for
				// expressions like {(})
				else {
					Parentesinfo poppet = syntaksStabel.pop();
					if (!passer(poppet.getVenstreparentes(), parentes)) {
						feil = true;
						System.out.println(poppet.toStringIkkeBalansert());
					}
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
		int linjenr = 1;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				foretaBalansering(linje, linjenr);
				linje = tekstLeser.readLine();
				linjenr++;
			}

			if (!syntaksStabel.erTom()) {
				System.out.println("Stabelen er ikke tom etter innlesing.");
				while (!syntaksStabel.erTom()) {
					feil = true;
					Parentesinfo rest = syntaksStabel.pop();
					System.out.println(rest.toStringRest());
				}
			}
			if (!feil) {
				System.out.println("Filen er balansert.");
			} else {
				System.out.println("Filen er dermed ikke balansert.");
			}
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
