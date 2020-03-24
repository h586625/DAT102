package no.hvl.dat102.klient;

import static no.hvl.dat102.SorteringOgSoeking.bobleSort;
import static no.hvl.dat102.SorteringOgSoeking.fletteSort;
import static no.hvl.dat102.SorteringOgSoeking.kvikkSort;
import static no.hvl.dat102.SorteringOgSoeking.radixSort;
import static no.hvl.dat102.SorteringOgSoeking.sorteringVedInnsetting;
import static no.hvl.dat102.SorteringOgSoeking.utvalgSort;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class KlientUtfoeringstider {
	private static final int SIZE_32K = 32000;
	private static final int SIZE_64K = 64000;
	private static final int SIZE_128K = 128000;
	private static final double c = 5.45898438e-7;

	enum Sorteringsalgoritme {
		UTVALG,
		INNSETTING,
		BOBLE,
		KVIKK,
		FLETTING,
		RADIX
	}

	public static Integer[] getElementer(int size) {
		// Creates a new array with n(SIZE) random integers
		Integer[] elementer = new Integer[size];
		// Random integers [0, 99]
		Random rInt = new Random(1);
		int min = 10;
		int max = 99;
		for (int i = 0; i < elementer.length; i++) {
			elementer[i] = rInt.nextInt(max + 1 - min) + min;
		}
		return elementer;
	}

	public static Integer[] tallTabell = {
			// Must be two digits for radix-sort to work ATM
			Integer.valueOf(14),
			Integer.valueOf(56),
			Integer.valueOf(10),
			Integer.valueOf(22),
			Integer.valueOf(12),
			Integer.valueOf(34),
			Integer.valueOf(81),
			Integer.valueOf(93),
			Integer.valueOf(70),
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

	/**
	 * Run appropriate sorting algorithm.
	 *
	 * Instead of a switch-case dependent on an ENUM,
	 * it would be better if we could just pass
	 * a method as a parameter so this would be a
	 * higher-order function, but I don't know how
	 * to do that in Java yet.
	 *
	 * @param Sorteringsalgoritme sortType
	 * @param  Integer[] elementer
	 */
	public static void runSortingAlgorithm(Sorteringsalgoritme sortType, Integer[] elementer) {
		switch (sortType) {
		case UTVALG:
			utvalgSort(elementer);
			break;
		case INNSETTING:
			sorteringVedInnsetting(elementer);
			break;
		case BOBLE:
			bobleSort(elementer);
			break;
		case KVIKK:
			kvikkSort(elementer);
			break;
		case FLETTING:
			fletteSort(elementer, 0, elementer.length-1);
			break;
		case RADIX:
			radixSort(elementer);
			break;
		default:
			System.out.println("Du må angi en eksisterende sorteringsalgoritme.");
			break;
		}
	}

	/**
	 * We measure the time it takes for (size) elements to be sorted
	 * and use it as a constant for our other
	 * sorting algorithms' t(n) equations.
	 *
	 * @param Sorteringsalgoritme sortType
	 * @param int size of dataset (n elements)
	 */
	public static int utfoerTeoretiskEstimering(Sorteringsalgoritme sortType, int size) {
		int teoretiskTid = 0;

		Integer[] utgspktElementer = getElementer(SIZE_32K);
		Instant utgspktStart = Instant.now();

		if (sortType.UTVALG != null || sortType.INNSETTING != null || sortType.BOBLE != null) {
			System.out.println("O(n^2)");
			runSortingAlgorithm(sortType, utgspktElementer);
		} else if (sortType.KVIKK != null || sortType.FLETTING != null) {
			System.out.println("O(nlog2(n))");
			runSortingAlgorithm(sortType, utgspktElementer);
		} else if (sortType.RADIX != null) {
			System.out.println("O(n)");
			runSortingAlgorithm(sortType, utgspktElementer);
		} else {
			System.out.println("Oppgi en gyldig O(f(n))");
		}

		Instant utgspktFinish = Instant.now();
		long utgspktTimeElapsed = Duration.between(utgspktStart, utgspktFinish).toMillis();

		if (size == SIZE_32K) {
			teoretiskTid = (int)utgspktTimeElapsed;
			return teoretiskTid;
		}

		System.out.println("loool" + utgspktTimeElapsed);
		// n^2:
		// Teoretisk tid 32K: 780ms = c*32000^2 <=> c = (7.6171875*10^-7)
		// Teoretisk tid 64K: (7.6171875*10^-7)*64000^2 = t(n) = 3120ms
		// Teoretisk tid 128K: (7.6171875*10^-7)*128000^2 = t(n) = 12480ms

		return teoretiskTid;
	}

	/**
	 * Measures time and prints out the results
	 * for an arbitrary but existing sorting algorithm.
	 *
	 * @param Sorteringsalgoritme sortType
	 * @param int size of dataset (n elements)
	 */
	// Method could be much more modularized/split
	public static void utfoerSorteringEstimering(Sorteringsalgoritme sortType, int size) {
		Integer[] elementer = getElementer(size);

		long teoretiskTid = utfoerTeoretiskEstimering(sortType, size);

		// Benchmarking
		Instant start = Instant.now();
		runSortingAlgorithm(sortType, elementer);
		Instant finish = Instant.now();
		long praktiskTid = Duration.between(start, finish).toMillis();

		// Output
		System.out.println("n \t\t Målt tid");
		System.out.println("n målinger \t Teoretisk tid c*f(n)");
		System.out.print(size + "\t\t " + praktiskTid + "ms");
		System.out.print("\n1 \t\t " + teoretiskTid + "ms\n");

	} //utfoerSorteringEstimering()



	public static void main(String[] args) {
		// Original data
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
		System.out.println("\n\nRadix-sort:");
		Integer[] kopi6 = kopierOriginalTabell(tallTabell);
		radixSort(kopi6);
		skrivUtTallTabell(kopi6);

		// ====================================================
		// Utføringstider
		// ====================================================

		System.out.println("\n\n=====UTFØRINGSTIDER=====");
		System.out.println("OBS! Det kan ta en stund før målingene vises.");

		System.out.println("\nUTVALGSSORTERING");
		utfoerSorteringEstimering(Sorteringsalgoritme.UTVALG, SIZE_32K);
		//		utfoerSorteringEstimering(Sorteringsalgoritme.RADIX, SIZE_64K);
		//		utfoerSorteringEstimering(Sorteringsalgoritme.RADIX, SIZE_128K);

	} // main

}
