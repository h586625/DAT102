package no.hvl.dat102.klient;

import no.hvl.dat102.Kontakt;
import no.hvl.dat102.SorteringOgSoeking;

public class KlientTelefonliste {

	public static void main(String[] args) {

		Kontakt[] venner = new Kontakt[7];
		venner[0] = new Kontakt("Jon", "Samulesen", "55535879");
		venner[1] = new Kontakt("Sarah", "Barvik", "56512102");
		venner[2] = new Kontakt("Marhus", "Rein", "57210233");
		venner[3] = new Kontakt("Laura", "Gjertsen", "54237761");
		venner[4] = new Kontakt("Frank", "Alstad", "55425699");
		venner[5] = new Kontakt("Lars", "Selvik", "57734421");
		venner[6] = new Kontakt("Elise", "Alstad", "53425699");
		/**************************************************/
		Kontakt[] vennerS = new Kontakt[7];
		for (int i = 0; i < vennerS.length; i++) {
			vennerS[i] = venner[i];
		}

		// Lager noen flere usorterte data for de ulike sorterinsgmetodene

		Kontakt[] venner1 = new Kontakt[7];
		for (int i = 0; i < venner1.length; i++) {
			venner1[i] = venner[i];
		}

		Kontakt[] venner2 = new Kontakt[7];
		for (int i = 0; i <= venner2.length - 1; i++) {
			venner2[i] = venner[i];
		}

		Kontakt[] venner3 = new Kontakt[7];
		for (int i = 0; i < venner3.length; i++) {
			venner3[i] = venner[i];
		}
		Kontakt[] venner4 = new Kontakt[7];
		for (int i = 0; i <= venner4.length - 1; i++) {
			venner4[i] = venner[i];
		}

		Kontakt[] venner5 = new Kontakt[7];
		for (int i = 0; i < venner5.length ; i++) {
			venner5[i] = venner[i];
		}

		Kontakt[] venner6 = new Kontakt[7];
		for (int i = 0; i < venner6.length; i++) {
			venner6[i] = venner[i];
		}

		// Utskrift av data
		System.out.println("\n Originale data ");
		for (int i = 0; i < venner.length; i++) {
			System.out.println(venner[i]);
		}
		/* Lineær søking i usortert tabell , venner */
		/* Lineærsøking som returnerer sann eller usann */
		Kontakt kontakt1 = venner[2];
		Kontakt kontakt2 = new Kontakt("Ole", "Olsen", "55555555");
		boolean funnet = false;

		System.out.println("\nUtskrift fra  linearSok som returnerer sann eller usann ");

		funnet = SorteringOgSoeking.linearSoekS(venner, 0, venner.length - 1, kontakt1);

		if (funnet) {
			System.out.print(kontakt1);
			System.out.println(" er med");
		} else {
			System.out.print(kontakt1);
			System.out.println(" er ikke med");
		}

		funnet = SorteringOgSoeking.linearSoekS(venner, 0, venner.length - 1, kontakt2);

		if (funnet) {
			System.out.print(kontakt2);
			System.out.println(" er med");
		} else {
			System.out.print(kontakt2);
			System.out.println(" er ikke med");
		}

		/* Søking i sortert tabell */

		kontakt1 = vennerS[3];
		// OBS! Lager først en tabell av sorterte data før vi bruker
		// linearsøking i sortert tabell og binærsøking.
		/* Sorterer tabellen */
		SorteringOgSoeking.utvalgsSortering(vennerS);

		// Utskrift av data
		System.out.println("\n Sorterete  data ");
		for (int i = 0; i < vennerS.length; i++) {
			System.out.println(vennerS[i]);
		}

		/*
		 * Lineær søking i en sortert tabell * / /* Lineærsøking som returnerer sann
		 * eller usann
		 */
		System.out.println("\nUtskrift fra linearSokSortert som returnerer sann eller usann ");

		funnet = SorteringOgSoeking.linearSoekS(vennerS, 0, vennerS.length - 1, kontakt1);

		if (funnet) {
			System.out.print(kontakt1);
			System.out.println(" er med");
		} else {
			System.out.print(kontakt1);
			System.out.println(" er ikke med");
		}

		funnet = SorteringOgSoeking.linearSoekS(vennerS, 0, vennerS.length - 1, kontakt2);

		if (funnet) {
			System.out.print(kontakt2);
			System.out.println(" er med");
		} else {
			System.out.print(kontakt2);
			System.out.println(" er ikke med");
		}

		/* Binærsøking - tabellen er sortert */

		/* Binærsøking som returnerer sann eller usann */
		System.out.println("\nUtskrift fra rekursiv binaersoking som returnerer sann eller usann ");

		funnet = SorteringOgSoeking.binaerSoek(vennerS, 0, vennerS.length - 1, kontakt1);

		if (funnet) {
			System.out.print(kontakt1);
			System.out.println(" er med");
		} else {
			System.out.print(kontakt1);
			System.out.println(" er ikke med");
		}

		funnet = SorteringOgSoeking.binaerSoek(vennerS, 0, vennerS.length - 1, kontakt2);

		if (funnet) {
			System.out.print(kontakt2);
			System.out.println(" er med");
		} else {
			System.out.print(kontakt2);
			System.out.println(" er ikke med");
		}

		/* Rekursiv binærsøking som returnerer true ved funn ellers false */
		System.out.println("\nUtskrift fra ikke rekursiv binaersoking som returnerer indeksen, -1 ved ikke-funn.");

		funnet = SorteringOgSoeking.binaerSoek(vennerS, 0, vennerS.length - 1, kontakt1);

		if (funnet) {
			System.out.print(kontakt1);
			System.out.println(" er med");
		} else {
			System.out.print(kontakt1);
			System.out.println(" er ikke med");
		}

		funnet = SorteringOgSoeking.binaerSoek2(vennerS, 0, vennerS.length - 1, kontakt2);

		if (funnet) {
			System.out.print(kontakt2);
			System.out.print(" er med");
		} else {
			System.out.print(kontakt2);
			System.out.println(" er ikke med");
		}

		/* Rekursiv binærsøking som returnerer true ved funn ellers false */
		System.out.println("\nUtskrift fra rekursiv binaersoking som returnerer indeksen, -1 ved ikke-funn.");

		funnet = SorteringOgSoeking.binaerSoek2(vennerS, 0, vennerS.length - 1, kontakt1);

		if (funnet) {
			System.out.print(kontakt1);
			System.out.println(" er med");
		} else {
			System.out.print(kontakt1);
			System.out.println(" er ikke med");
		}

		funnet = SorteringOgSoeking.binaerSoek2(vennerS, 0, vennerS.length - 1, kontakt2);

		if (funnet) {
			System.out.print(kontakt2);
			System.out.println(" er med");
		} else {
			System.out.print(kontakt2);
			System.out.println(" er ikke med");
		}

		/* TODO
		 *  Rekursiv binærsøk som returnerer indeks
		 */

		/* Sortering av usorterte tabeller , venner1, venner2, venner3 */

		/* Sortering ved utvalg */
		System.out.println("\nUtvalgsortering");
		SorteringOgSoeking.utvalgsSortering(venner1);

		for (int indeks = 0; indeks < venner1.length; indeks++) {
			System.out.println(venner1[indeks]);
		}

		/*
		 * TODO Sortering ved innsetting
		 * System.out.println("\nSortering ved innsetting");
		 * SoekingOgSortering.sorteringVedInnsetting(venner2);
		 *
		 * for (int indeks = 0; indeks < venner2.length; indeks++) {
		 * System.out.println(venner2[indeks]); }
		 *
		 */

		/* Boblesortering */
		System.out.println("\nBoblesortering");
		SorteringOgSoeking.bobleSort(venner3);

		for (int indeks = 0; indeks < venner3.length; indeks++) {
			System.out.println(venner3[indeks]);
		}



		System.out.println("\nBoblesortering med flagg");
		SorteringOgSoeking.bobleSortFlagg(venner6);

		for (int indeks = 0; indeks < venner6.length; indeks++) {
			System.out.println(venner6[indeks]); }


		/*
		 * TODO Kvikksortering System.out.println("\nKvikksortering");
		 * SoekingOgSortering.kvikkSort(venner4, 0, venner4.length - 1);
		 *
		 * for (int indeks = 0; indeks < venner4.length; indeks++) {
		 * System.out.println(venner4[indeks]); }
		 */

		/*
		 * TODO Flettesortering System.out.println("\nFlettesortering");
		 * SoekingOgSortering.fletteSort(venner5, 0, venner5.length - 1);
		 *
		 * for (int indeks = 0; indeks < venner5.length; indeks++) {
		 * System.out.println(venner5[indeks]); }
		 */
	}// main
}// class