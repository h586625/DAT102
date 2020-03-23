package no.hvl.dat102.klient;

import static no.hvl.dat102.SorteringOgSoeking.bobleSort;
import static no.hvl.dat102.SorteringOgSoeking.fletteSort;
import static no.hvl.dat102.SorteringOgSoeking.kvikkSort;
import static no.hvl.dat102.SorteringOgSoeking.sorteringVedInnsetting;
import static no.hvl.dat102.SorteringOgSoeking.utvalgSort;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class KlientUtfoeringstider {
	private static final int SIZE_32K = 32000;
	private static final int SIZE_64K = 64000;
	private static final int SIZE_128K = 128000;

	public static Integer[] getElementer(int size) {
		// Creates a new array with n(SIZE) random integers
		Integer[] elementer = new Integer[size];
		Random rInt = new Random();
		for (int i = 0; i < elementer.length; i++) {
			elementer[i] = rInt.nextInt();
		}
		return elementer;
	}

	public static Integer[] tallTabell = {
			Integer.valueOf(14),
			Integer.valueOf(56),
			Integer.valueOf(10),
			Integer.valueOf(2),
			Integer.valueOf(17),
			Integer.valueOf(1),
			Integer.valueOf(8),
			Integer.valueOf(9),
			Integer.valueOf(0),
			Integer.valueOf(90)
	};

	public static Integer[] kopierOriginalTabell(Integer[] tabell){
		Integer[] kopi = new Integer[tabell.length];
		for (int i = 0; i < tabell.length; i++) {
			kopi[i] = tabell[i];
		}
		return kopi;
	}

	public static void skrivUtTallTabell(Integer[] tabell) {
		for (int i = 0; i < tabell.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(tabell[i]);
		}
	}

	public static void main(String[] args) {
		// Originale data
		System.out.println("\nOriginale data:");
		for (int i = 0; i < tallTabell.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(tallTabell[i]);
		}

		// Utvalgssortering
		System.out.println("\n\nUtvalgssortering:");
		Integer[] kopi3 = kopierOriginalTabell(tallTabell);
		utvalgSort(kopi3);
		skrivUtTallTabell(kopi3);

		// Sortering ved innsetting
		System.out.println("\n\nSortert ved innsetting:");
		Integer[] kopi4 = kopierOriginalTabell(tallTabell);
		sorteringVedInnsetting(kopi4);
		skrivUtTallTabell(kopi4);

		// Boblesortering
		System.out.println("\n\nBoblesortering:");
		Integer[] kopi5 = kopierOriginalTabell(tallTabell);
		bobleSort(kopi5);
		skrivUtTallTabell(kopi5);

		// Kvikksortering
		System.out.println("\n\nKvikksortering:");
		Integer[] kopi1 = kopierOriginalTabell(tallTabell);
		kvikkSort(kopi1);
		skrivUtTallTabell(kopi1);

		// Flettesortering
		System.out.println("\n\nFlettesortering:");
		Integer[] kopi2 = kopierOriginalTabell(tallTabell);
		fletteSort(kopi2, 0, kopi2.length-1);
		skrivUtTallTabell(kopi2);

		// Radix sort
		//		System.out.println("\n\nRadix-sort:");
		//		Integer[] kopi6 = kopierOriginalTabell(tallTabell);
		//		radixSort(kopi6);
		//		skrivUtTallTabell(kopi6);

		// ====================================================
		// Utføringstider
		// ====================================================

		System.out.println("=====UTFØRINGSTIDER=====");

		Integer[] elementer32K = getElementer(SIZE_32K);
		Instant start1 = Instant.now();
		utvalgSort(elementer32K);
		Instant finish1 = Instant.now();
		long timeElapsed1 = Duration.between(start1, finish1).toMillis();
		System.out.println("\nUtvalgssortering:");
		System.out.println("n \t Målt tid");
		System.out.print(SIZE_32K + "\t" + timeElapsed1 + "ms");
	} // main

}
