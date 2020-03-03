package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.datakontakt.Datakontakt;
import no.hvl.dat102.datakontakt.Hobby;
import no.hvl.dat102.datakontakt.Medlem;

public class KlientDatakontakt {
	public static void main(String[] args) {
		Datakontakt arkiv1 = new Datakontakt();
		Medlem chris = new Medlem("Chris");
		Medlem testP = new Medlem("testP");
		chris.getHobbyer().leggTil(new Hobby("Fjelltur"));
		testP.getHobbyer().leggTil(new Hobby("Fjelltur"));
		arkiv1.leggTilMedlem(chris);
		arkiv1.leggTilMedlem(testP);
		System.out.println(arkiv1.getAntall());
		System.out.println(arkiv1.finnMedlemsIndeks("testP"));
		System.out.println(arkiv1.finnPartnerFor("Chris"));
	}
}
