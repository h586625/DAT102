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
	public void start() {
		System.out.println("\nVelg et alternativ:");
		System.out.println("1 - Opprette nytt arkiv?");
		System.out.println("2 - Jobbe med eksisterende arkiv?");
		Scanner leser = new Scanner(System.in);
		int valg1 = Integer.parseInt(leser.nextLine());
		
		System.out.println("Skriv filnavn for filmarkivet");
		String filnavn = leser.nextLine();
		
		// nytt arkiv
		if (valg1 == 1) {
			Fil.skrivTilFil(filmer, filnavn);
			System.out.println("Nytt arkiv " + "\"" + filnavn + "\"" + " opprettet.");
		} // valg1 == 1
		
		// eksisterende arkiv
		if (valg1 == 2) {
			filmer = Fil.lesFraFil(filnavn);
			if (filmer != null) {
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
						System.out.println("Filmen er nå lagt til.");
						Fil.skrivTilFil(filmer, filnavn);
					} // valg3 == 1
					
					if (valg3 == 2) {
						System.out.println("Skriv inn filmnr du ønsker å slette:");
						int filmnr = Integer.parseInt(leser.nextLine());
						if (filmer.slettFilm(filmnr)) {
							Fil.skrivTilFil(filmer, filnavn);
						} else {
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
					if (valg3 == 2) {
						System.out.println("Skriv inn delstreng til filmen du leter etter:");
						String filmstr = leser.nextLine();
						tekstgr.skrivUtFilmDelstrengITittel(filmer, filmstr);
					}
					// søk opp produsent
					if (valg3 == 3) {
						System.out.println("Skriv inn delstreng til produsenten du leter etter:");
						String filmstr = leser.nextLine();
						tekstgr.skrivUtFilmProdusent(filmer, filmstr);
					} // valg3 == 3
				} // filmer != null
			} // valg2 == 2
		} // valg1 == 1
		
		leser.close();
	}
}
