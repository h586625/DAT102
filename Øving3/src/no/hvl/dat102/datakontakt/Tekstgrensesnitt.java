package no.hvl.dat102.datakontakt;

import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Tekstgrensesnitt {
	public static Medlem lesMedlem(){
		Scanner leser = new Scanner(System.in);
		Medlem medlem = new Medlem();

		System.out.println("Skriv inn medlemsnavn:");
		String medlemsnavn = leser.nextLine();
		medlem.setNavn(medlemsnavn);

		System.out.println("Skriv inn hobbyer eller avslutt med q:");
		String hobbyStr = leser.nextLine();
		MengdeADT<Hobby> hobbyer = medlem.getHobbyer();
		while (!hobbyStr.equals("q")) {
			Hobby hobby = new Hobby(hobbyStr);
			hobbyer.leggTil(hobby);
			System.out.println("Hobbyen " + hobbyStr + " er nå lagt til.");
			hobbyStr = leser.nextLine();
		}

		System.out.println(hobbyStr);

		System.out.println("Medlemmet " + medlemsnavn + " er nå lagt til.");

		leser.close();

		return medlem;
	}

	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene:");
		System.out.print(medlem.getHobbyer().toString());
	}

	public static void skrivParListe (Datakontakt arkiv){
		System.out.println("PARNAVN HOBBYER");
		arkiv.skrivUtMedlemPar();

		System.out.println("==========");
		System.out.println("Antall par funnet: " + arkiv.getAntallPar());
	}
	/* Et slikt par skal kun vises én gang.

	Eksempel på utskrift:
	PARNAVN HOBBYER
	Erna og Jonas <ski, musikk, politikk>
	Eva og Adam <epleplukking, paradishopping>
	…………………….
	Antall par funnet: 12
	 */
}
