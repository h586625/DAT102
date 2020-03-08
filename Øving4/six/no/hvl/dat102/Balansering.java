package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Balansering {
	// Her opphever du kommentarsetning når du har fått lagt inn
	// nødvendig kode
	// SirkulaerStabel<Parentesinfo>stabel = new
	// SirkulaerStabel<Parentesinfo>();

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
		// Fyll ut

	}//

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

	}// metode

}// class
