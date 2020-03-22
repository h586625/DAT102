package no.hvl.dat102.klient;

import no.hvl.dat102.Person;
import no.hvl.dat102.SorteringOgSoeking;

public class KlientPersonliste {

	public static void main(String[] args) {

		Person[] personer = new Person[7];
		personer[0] = new Person("Ole", "Sandvik");
		personer[1] = new Person("Lise", "Barvik");
		personer[2] = new Person("Marius", "Rein");
		personer[3] = new Person("Laura", "Gjertsen");
		personer[4] = new Person("Frank", "Alstad");
		personer[5] = new Person("Lars", "Selvik");
		personer[6] = new Person("Elise", "Alstad");
		/**************************************************/
		Person[] personerS = new Person[7];
		for (int i = 0; i <= personerS.length - 1; i++) {
			personerS[i] = personer[i];
		}

		// Utskrift av data
		System.out.println("\n Originale data ");
		for (int i = 0; i < personer.length; i++) {
			System.out.println(personer[i]);
		}
		/* Lineær søking i usortert tabell , venner */
		/* Lineærsøking som returnerer sann eller usann */
		Person person1 = personer[2];
		Person person2 = new Person("Ole", "Olsen");
		boolean funnet = false;

		System.out.println("\nUtskrift fra  linearSok som returnerer sann eller usann ");

		funnet = SorteringOgSoeking.linearSoekU(personer, 0, personer.length-1, person1);

		if (funnet) {
			System.out.println(person1 + " er med");
		} else {
			System.out.println(person1 + " er ikke med");
		}

		funnet = SorteringOgSoeking.linearSoekU(personer, 0, personer.length-1, person2);

		if (funnet) {
			System.out.println(person2 + " er med");
		} else {
			System.out.println(person2 + " er ikke med");
		}

		/* Søking i sortert tabell */

		person1 = personerS[3];
		// OBS! Lager først en tabell av sorterte data før vi bruker
		// linearsøking i sortert tabell og binærsøking.
		/* Sorterer tabellen */
		SorteringOgSoeking.utvalgsSortering(personerS);

		// Utskrift av data
		System.out.println("\n Sorterte  data ");
		for (int i = 0; i < personerS.length; i++) {
			System.out.println(personerS[i]);
		}

		/*
		 * Lineær søking i en sortert tabell * / Lineærsøking som returnerer
		 * sann eller usann
		 */
		System.out.println("\nUtskrift fra linearSokSortert som returnerer sann eller usann ");

		funnet = SorteringOgSoeking.linearSoekS(personerS, 0, personerS.length-1, person1);

		if (funnet) {
			System.out.println(person1 + " er med");
		} else {
			System.out.println(person1 + " er ikke med");
		}

		funnet = SorteringOgSoeking.linearSoekS(personerS, 0, personerS.length-1, person2);

		if (funnet) {
			System.out.println(person2 + " er med");
		} else {
			System.out.println(person2 + " er ikke med");
		}

		/* Binærsøking - tabellen er sortert */

		/* Alt 1 Binærsøking som returnerer sann eller usann */
		System.out.println("\n Alt 1 Utskrift fra rekursiv binaersoking som returnerer sann eller usann ");

		funnet = SorteringOgSoeking.binaerSoek(personerS, 0, personerS.length-1, person1);

		if (funnet) {
			System.out.println(person1 + " er med");
		} else {
			System.out.println(person1 + " er ikke med");
		}

		funnet = SorteringOgSoeking.binaerSoek(personerS, 0, personerS.length-1, person2);
		if (funnet) {
			System.out.println(person2 + " er med");
		} else {
			System.out.println(person2 + " er ikke med");
		}

		//
		/* Alt 2 Binærsøking som returnerer sann eller usann */
		System.out.println("\n Alt 2 :Utskrift fra rekursiv binaersoking som returnerer sann eller usann ");

		funnet = SorteringOgSoeking.binaerSoek2(personerS, 0, personerS.length-1, person1);

		if (funnet) {
			System.out.println(person1 + " er med");
		} else {
			System.out.println(person1 + " er ikke med");
		}

		funnet = SorteringOgSoeking.binaerSoek(personerS, 0, personerS.length-1, person2);
		if (funnet) {
			System.out.println(person2 + " er med");
		} else {
			System.out.println(person2 + " er ikke med");
		}


		// Alt 3
		/* Rekursiv binærsøking som returnerer indeksen, -1 ved ikke-funn */
		System.out.println("\n Alt 3 Utskrift fra  rekursiv binaersoking som returnerer indeksen, -1 ved ikke-funn.");

		int ind = SorteringOgSoeking.binaerSoek3(personerS, 0, personerS.length-1, person1);

		if (ind > 1) {
			System.out.println(personerS[ind] + " er med");
		} else {
			System.out.println(person2 + " er ikke med");
		}

		ind = SorteringOgSoeking.binaerSoek3(personerS, 0, personerS.length-1, person2);

		if (ind > 1) {
			System.out.println(personerS[ind] + " er med");
		} else {
			System.out.println(person2 + " er ikke med");
		}

		/* TODO
		 * Ikke-rekursiv binærsøking som returnerer indeksen, -1 ved ikke-funn
		 */

		/*
		 * System.out.
		 * println("\nUtskrift fra rekursiv binaersoking som returnerer indeksen, -1 ved ikke-funn."
		 * );
		 *
		 * ind = SoekingOgSortering.binaerSoek4(personerS, 0, personerS.length -
		 * 1, person1);
		 *
		 * if (ind > 1) { System.out.println(personerS[ind] + " er med"); } else
		 * { System.out.print(person1 + " er ikke med"); }
		 *
		 */

	}// main
}// class