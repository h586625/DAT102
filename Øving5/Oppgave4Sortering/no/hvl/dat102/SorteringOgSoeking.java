package no.hvl.dat102;

public class SorteringOgSoeking {

	/*************************************************************************************************/
	// Søkealgoritmer
	/*************************************************************************************************/

	/**
	 * Metoden gjør et lineært søk i en tabell av usorterte data
	 *
	 * @param data er data som skal søkes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   er verdien vi søker etter
	 * @return sann om elementet ble funnet ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSoekU(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks <= maks && !funnet) {
			if (data[indeks].compareTo(el) == 0)
				funnet = true;
			indeks++;
		} // while
		return funnet;
	}// metode

	/**
	 * Metoden gjør et lineært søk i en sortert tabell av data
	 *
	 * @param data er data som skal søkes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   verdien vi søker etter
	 * @return sann hvis funnet ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSoekS(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks < maks && data[indeks].compareTo(el) < 0) {
			indeks++;
		} // while

		if (data[indeks].compareTo(el) == 0) {
			funnet = true;
		}

		return funnet;

	}// metode

	/**
	 * Metoden gjør et binært søk i en *sortert* tabell av data
	 *
	 * @param data er data som skal søkes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   er elementet vi søker etter
	 * @return sann om elementet ble funnet ellers usann.
	 */

	// Alt 1
	public static <T extends Comparable<T>> boolean binaerSoek(T[] data, int min, int maks, T el) {
		if (min > maks) { // basistilfelle, ingen element
			return false;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		if (resultat == 0) { // basistilfelle, finner elementet
			return true;
		}
		if (resultat < 0) {// (her vil også fungere med else if)
			return binaerSoek(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}
	}//

	// Alt 2
	public static <T extends Comparable<T>> boolean binaerSoek2(T[] data, int min, int maks, T el) {
		boolean funnet;
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		if (min > maks) { // basistilfelle, ingen element
			funnet = false;
		} else if (resultat == 0) { // basistilfelle, funnet
			funnet = true;
		} else if (resultat < 0) {
			funnet = binaerSoek2(data, min, midtpunkt - 1, el);
		} else {
			funnet = binaerSoek2(data, midtpunkt + 1, maks, el);
		}

		return funnet;

	}

	/* Rekursiv binærsøk som returnerer indeks */
	// Alt 3
	public static <T extends Comparable<T>> int binaerSoek3(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		if (min > maks) { // basistilfelle, ingen element
			return -1;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) { // basistilfelle, finner elementet
			return midtpunkt;
		}
		if (resultat < 0) {// ( vil her også fungere med else if)
			return binaerSoek3(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSoek3(data, midtpunkt + 1, maks, el);
		}
	}// metode

	/* Ikke rekursiv binærsøk som returnerer indeks */
	// Alt 4
	public static <T extends Comparable<T>> int binaerSoek4(T[] data, int min, int maks, T el) {
		return maks;
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		// Fyll ut og kjør metoden
	}//

	/*************************************************************************************************/
	// Sorteringsalgoritmer
	/*************************************************************************************************/

	/**
	 * Utvalgssortering
	 *
	 * @param data er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgsSortering(T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
				}
			} // indre for-løkke

			/** Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		} // ytre for-løkke
	}// metode

	/**
	 * Sortering ved innsetting
	 *
	 * @param data er data som skal sorteres
	 */
	// ...
	/**
	 *
	 * @param <T>  generisk type
	 * @param data er tabellen som skal sorteres
	 */
	public static <T extends Comparable<T>> void bobleSort(T[] data) {
		T temp;
		for (int p = data.length - 1; p >= 0; p--) {
			for (int sok = 0; sok <= p - 1; sok++) {
				if (data[sok].compareTo(data[sok + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
				}
			} // indre løkke
		} // ytre løkke

	}// metode

	public static <T extends Comparable<T>> void bobleSortFlagg(T[] data) {
		/*
		 * Sjekker om det ha vært ombyttinger i nåværende gjennomløp. Dersom ingen
		 * ombyttinger så avbrytes prosessen.
		 */
		T temp = null;
		int fase = 1;
		boolean byttet = false;
		do {
			byttet = false;
			for (int i = 0; i < data.length - fase; i++) {
				if (data[i].compareTo(data[i + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					byttet = true;

				}

			} // indre løkke
			fase++;

		} while (byttet); // ytre løkke

	}// metode

}// class