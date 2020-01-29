package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import java.util.Scanner;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmer;
	
	public Meny(FilmarkivADT filmer) {
		this.filmer = filmer;
		tekstgr = new Tekstgrensesnitt();
	}
	
	// TODO: Tilbake i meny
	// TODO: Lukk meny
	// TODO: Skriv evt. endringer til fil
	public void start() {
		System.out.println("\nVelg et alternativ:");
		System.out.println("1 - Opprette nytt arkiv?");
		if (filmer.antall() > 0) {
			System.out.println("2 - Jobbe med eksisterende arkiv?");
		}
		Scanner leser = new Scanner(System.in);
		int valg1 = Integer.parseInt(leser.nextLine());
		
		System.out.println("Skriv filnavn for filmarkivet");
		String filnavn = leser.nextLine();
		
		// nytt arkiv
		// TODO: make it work (returns error atm)
		if (valg1 == 1) {
			Fil.skrivTilFil(filmer, filnavn);
		} // valg1 == 1
		
		// eksisterende arkiv
		if (valg1 == 2) {
			System.out.println("Hva ønsker du å gjøre?");
			System.out.println("1 - Utføre endringer");
			System.out.println("2 - Skrive ut informasjon");
			
			int valg2 = Integer.parseInt(leser.nextLine());
			
			// utføre endringer
			if (valg2 == 1) {
				System.out.println("Hvilken endring ønsker du å utføre?");
				System.out.println("1 - Legg til film");
				System.out.println("2 - Slett film");
				
				int valg3 = Integer.parseInt(leser.nextLine());
				
				if (valg3 == 1) {
					Film film = tekstgr.lesFilm();
					filmer.leggTilFilm(film);
					System.out.println();
				} // valg3 == 1
				
				if (valg3 == 2) {
					System.out.println("Skriv inn filmnr du ønsker å slette:");
					int filmnr = Integer.parseInt(leser.nextLine());
					if (!filmer.slettFilm(filmnr)) {
						System.out.println("Ingen film med dette nr. ble slettet.");
					}
				} // valg3 == 2
			} // valg2 == 1
			
			// skrive ut informasjon
			if (valg2 == 2) {
				System.out.println("Hvilken informasjon vil du ha?");
				System.out.println("1 - Filmstatistikk");
				System.out.println("2 - Søk opp tittel");
				System.out.println("3 - Søk opp produsent");
				
				int valg3 = Integer.parseInt(leser.nextLine());
				
				// skriv ut statistikk
				if (valg3 == 1) {
					tekstgr.skrivUtStatistikk(filmer);
				}
				
				// søk opp tittel
				// TODO: currently, you have to know the ID, but you should be able to
				// just write the name of the movie, 
				// and choose one of those that are listed
				if (valg3 == 2) {
					System.out.println("Skriv inn nr. på filmen du leter etter:");
					int filmnr = Integer.parseInt(leser.nextLine());
					int sok = filmer.sokNr(filmnr);
					if ( sok != -1 ) {
						tekstgr.visFilm(filmer.hentFilmTabell()[sok]);
					}
				}
				// søk opp produsent
				if (valg3 == 3) {
					
				} // valg3 == 3
			} // valg2 == 2
		} // valg1 == 1
		
		leser.close();
	}
}
