package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.datakontakt.Datakontakt;
import no.hvl.dat102.datakontakt.Hobby;
import no.hvl.dat102.datakontakt.Medlem;
import no.hvl.dat102.datakontakt.Tekstgrensesnitt;

public class KlientDatakontakt {
	public static void main(String[] args) {
		Datakontakt arkiv1 = new Datakontakt();

		Medlem person = Tekstgrensesnitt.lesMedlem();
		Medlem chris = new Medlem("Chris");
		Medlem cortana = new Medlem("Cortana");
		Medlem adam = new Medlem("Adam");
		Medlem eva = new Medlem("Eva");
		Medlem bradP = new Medlem("Brad Pitt");
		Medlem jenA = new Medlem("Jennifer Anniston?");
		person.getHobbyer().leggTil(new Hobby("Gjemsel"));
		chris.getHobbyer().leggTil(new Hobby("Fjelltur"));
		cortana.getHobbyer().leggTil(new Hobby("Fjelltur"));
		adam.getHobbyer().leggTil(new Hobby("Epleplukking"));
		eva.getHobbyer().leggTil(new Hobby("Epleplukking"));
		bradP.getHobbyer().leggTil(new Hobby("Teater"));
		jenA.getHobbyer().leggTil(new Hobby("Teater"));
		arkiv1.leggTilMedlem(person);
		arkiv1.leggTilMedlem(chris);
		arkiv1.leggTilMedlem(cortana);
		arkiv1.leggTilMedlem(adam);
		arkiv1.leggTilMedlem(eva);
		arkiv1.leggTilMedlem(bradP);
		arkiv1.leggTilMedlem(jenA);

		System.out.println("Antall medlemmer: " + arkiv1.getAntall());
		System.out.println("Medlemsindeks for " +
				cortana.getNavn() + ": " +
				arkiv1.finnMedlemsIndeks("Nikita")
				);
		System.out.println("Partnerindeks for " +
				cortana.getNavn() + ": " +
				arkiv1.finnPartnerFor(cortana.getNavn())
				);
		if (arkiv1.finnPartnerFor(cortana.getNavn()) > -1) {
			System.out.println( cortana.getNavn() + " passer med " +
					arkiv1.hentMedlemFraIndeks(arkiv1.finnPartnerFor(cortana.getNavn())).getNavn()
					);
		} else {
			System.out.println("Ingen partnermatch for " + cortana.getNavn());
		}

		arkiv1.finnPartnerFor("chris");
		arkiv1.finnPartnerFor("Ensom Ulv");
		arkiv1.finnPartnerFor("Adam");
		arkiv1.finnPartnerFor("Eva");
		arkiv1.finnPartnerFor("Brad Pitt");
		arkiv1.finnPartnerFor("Jennifer Anniston?");

		System.out.println();
		Tekstgrensesnitt.skrivParListe(arkiv1);
		System.out.println();
		System.out.println(arkiv1.slettMedlem(eva));
		Tekstgrensesnitt.skrivParListe(arkiv1);
	}
}
