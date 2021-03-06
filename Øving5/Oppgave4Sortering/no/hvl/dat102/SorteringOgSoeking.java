package no.hvl.dat102;

import no.hvl.dat102.adt.KoeADT;

public class SorteringOgSoeking {

	/*************************************************************************************************/
	// S�kealgoritmer
	/*************************************************************************************************/

	/**
	 * Metoden gj�r et line�rt s�k i en tabell av usorterte data
	 *
	 * @param er data som skal s�kes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   er verdien vi s�ker etter
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
	}

	/**
	 * Metoden gj�r et line�rt s�k i en sortert tabell av data
	 *
	 * @param er data som skal s�kes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   verdien vi s�ker etter
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
	}

	/**
	 * Metoden gj�r et bin�rt s�k i en *sortert* tabell av data
	 *
	 * @param er data som skal s�kes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   er elementet vi s�ker etter
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
		if (resultat < 0) {
			return binaerSoek(data, min, midtpunkt-1, el);
		} else { // resultat > 0
			return binaerSoek(data, midtpunkt+1, maks, el);
		}
	}

	// Alt 2
	public static <T extends Comparable<T>> boolean binaerSoek2(T[] data, int min, int maks, T el) {
		boolean funnet;
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		// tregere enn alt1 da vi regner ut midtpunkt sin
		// verdi osv. selv om vi n�dvendig ikke trenger det
		// om f�rste betingelse viser seg � v�re sann

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

	/* Rekursivt bin�rs�k som returnerer "indeks" */
	// Alt 3
	public static <T extends Comparable<T>> int binaerSoek3(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til m�lelementet hvis det fins, ellers -1
		if (min > maks) { // basistilfelle, ingen element
			return -1;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		if (resultat == 0) { // basistilfelle, finner elementet
			return midtpunkt;
		}
		if (resultat < 0) {
			return binaerSoek3(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSoek3(data, midtpunkt + 1, maks, el);
		}
	}

	/* Ikke-rekursivt bin�rs�k som returnerer indeks */
	// Alt 4
	public static <T extends Comparable<T>> int binaerSoek4(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til m�lelementet hvis det fins ellers -1
		boolean funnet = false;
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		while (min < maks && !funnet) {
			midtpunkt = (min + maks) / 2;
			resultat = el.compareTo(data[midtpunkt]);

			if (resultat == 0) { // finner elementet
				funnet = true;
				return midtpunkt;
			}
			if (resultat < 0) {
				maks = midtpunkt-1;
			} else { // resultat > 0
				min = midtpunkt+1;
			}
		}

		return -1;
	}

	/*************************************************************************************************/
	// Sorteringsalgoritmer
	/*************************************************************************************************/

	/**
	 * Utvalgssortering
	 *
	 * @param data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgSort(T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
				}
			} // indre for-l�kke

			/** Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		} // ytre for-l�kke
	}

	/**
	 * Boblesortering
	 *
	 * @param data som skal sorteres
	 * @param <T>  generisk type
	 * @param tabellen som skal sorteres
	 */
	public static <T extends Comparable<T>> void bobleSort(T[] data) {
		T temp;
		for (int p = data.length - 1; p >= 0; p--) { // moves from right-to-left
			for (int sok = 0; sok <= p - 1; sok++) {
				if (data[sok].compareTo(data[sok + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
				}
			} // indre l�kke
		} // ytre l�kke
	}

	public static <T extends Comparable<T>> void bobleSortFlagg(T[] data) {
		/*
		 * Sjekker om det ha v�rt ombyttinger i n�v�rende gjennoml�p.
		 * Dersom ingen ombyttinger avbrytes prosessen.
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

			} // indre l�kke
			fase++;

		} while (byttet); // ytre l�kke
	}

	/**
	 * Sortering ved innsetting
	 *
	 * @param T data som skal sorteres
	 */

	// e.g. 3, 4, 2, 1, 5  i=2
	// 3, 2, 4, 1, 5
	// j=1
	// 2, 3, 4, 1, 5
	// j=0 exit while()
	// 2, 3, 4, 1, 5       i=3
	// 2, 3, 1, 4, 5
	// j = 2
	// 2, 1, 3, 4, 5
	// j=1
	// 1, 2, 3, 4, 5
	// j=0 exit while()
	public static <T extends Comparable<T>> void sorteringVedInnsetting(T[] data) {
		for (int i = 1; i < data.length; i++) {
			T nokkel = data[i];
			int p = i;

			// shift smaller elements to the left
			while (p > 0 && data[p-1].compareTo(nokkel) > 0) {
				T tmp = data[p];
				data[p] = data[p-1];
				data[p-1] = tmp;
				p--;
			}
		}
	} // sorteringVedInnsetting()

	public static <T extends Comparable<T>> void sorteringVedInnsetting2(T[] data) {
		for (int i = 1; i < data.length; i++) {
			T nokkel = data[i];
			int p = i;

			// shift bigger elements to the right
			while (p > 0 && data[p-1].compareTo(nokkel) > 0) {
				data[p] = data[p-1];
				p--;
			}

			// if p-- in while() above, then we perform the swap
			// otherwise, the value of the element
			// will just be assigned to itself (no change)
			data[p] = nokkel;
		}
	} // sorteringVedInnsetting()

	/**
	 * Kvikksortering
	 *
	 * @param <T> data som skal sorteres
	 */
	public static <T extends Comparable<T>> void kvikkSort(T[] data) {
		kvikkSort(data, 0, data.length-1);
	}

	/**
	 * Kvikksortering med minste- og maksverdi
	 *
	 * @param data som skal sorteres
	 * @param <T> tabellen som skal sorteres
	 * @param int minsteverdi
	 * @param int maksverdi
	 */
	private static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {
		int posPartisjon;

		if (min < maks) { // Minst to elementer
			// Oppretter partisjon og velger pivot
			posPartisjon = finnPartisjon(data, min, maks);
			// Sorter venstreside
			kvikkSort(data, min, posPartisjon-1);
			// Sorter h�yreside
			kvikkSort(data, posPartisjon+1, maks);
		}
	} // kvikkSort()

	/**
	 * Finn partisjon (brukes sammen med kvikkSort metoden)
	 *
	 * @param data som skal sorteres
	 * @param <T> tabellen som skal sorteres
	 * @param int minsteverdi
	 * @param int maksverdi
	 * @return int
	 */
	private static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
		int venstre, hoyre;
		T tmp, pivot;
		// Pivot som f�rste element. Boka bruker midterste.
		pivot = data[min];
		venstre = min;
		hoyre = maks;

		while (venstre < hoyre) {
			while (data[venstre].compareTo(pivot) <= 0) {
				// Move to the right until we find an element
				// to the left that's > pivot
				venstre++;
			}

			while (data[hoyre].compareTo(pivot) > 0) {
				// Move to the left until we find an element
				// to the right that's <= pivot
				hoyre--;
			}

			// Bytter venstre element med h�yre element
			// dersom venstre indeks < h�yre indeks (de har ikke krysset hverandre)
			if (venstre < hoyre) {
				tmp = data[venstre];
				data[venstre] = data[hoyre];
				data[hoyre] = tmp;
			}
		} // ytre l�kke

		// Flytter pivot til sin riktige og endelige plass
		// h�yre vil n� representere det midterste elementet
		// og det er dit vi flytter pivot
		tmp = data[min];
		data[min] = data[hoyre];
		data[hoyre] = tmp;

		return hoyre;
	} // finnPartisjon()

	/**
	 * Flettesortering
	 *
	 * Delproblem: del tabellen i to og flett dem sammen sortert
	 *
	 * @param data som skal sorteres
	 * @param <T> tabellen som skal sorteres
	 * @param int f�rste indeks
	 * @param int siste indeks
	 */
	public static <T extends Comparable<T>> void fletteSort(T[] data, int forste, int siste) {
		if (forste < siste) { // Minst to elementer
			int midten = (forste + siste)/2;

			// Sorter venstre halvdel
			fletteSort(data, forste, midten);
			// Sorter h�yre halvdel
			fletteSort(data, midten+1, siste);
			// Fletter de to halvdelene
			flette(data, forste, midten, siste);
		}
	} // fletteSort()

	/**
	 * Flette (Brukes sammen med fletteSort metoden)
	 *
	 * Fletter to sorterte deltabeller,
	 * tabell[forste, midten] og tabell[midten+1, siste]
	 * til en hjelpetabell og kopierer resultatet til den originale tabellen
	 *
	 * Forkrav: forste <= midten <= siste
	 *
	 * @param data som skal sorteres
	 * @param <T> tabellen som skal sorteres
	 * @param int forste indeks
	 * @param int midten indeks
	 * @param int siste indeks
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void flette(T[] data, int forste, int midten, int siste) {
		// Oppretter hjelpetabell med riktig st�rrelse
		int stor = siste - forste + 1;
		T[] hjelpeTabell = (T[])(new Comparable[stor]);

		// Start/slutt p� venstre deltabell
		int forste1 = forste;
		int siste1 = midten;

		// Start/slutt p� h�yre deltabell
		int forste2 = midten+1;
		int siste2 = siste;

		// S� lenge deltabellene ikke er tomme,
		// kopier det minste elementet til hjelpetabellen
		int indeks = 0;
		while ((forste1 <= siste1) && (forste2 <= siste2)) {
			if (data[forste1].compareTo(data[forste2]) <= 0) {
				hjelpeTabell[indeks] = data[forste1];
				forste1++;
			} else {
				hjelpeTabell[indeks] = data[forste2];
				forste2++;
			}
			indeks++;
		}

		// Kopier resten av venstre del (kan v�re tom)
		while (forste1 <= siste1) {
			hjelpeTabell[indeks] = data[forste1];
			forste1++;
			indeks++;
		}

		// kopier resten av h�yre del (kan v�re tom)
		while (forste2 <= siste2) {
			hjelpeTabell[indeks] = data[forste2];
			forste2++;
			indeks++;
		}

		// Kopier resultatet tilbake til den originale tabellen
		int h = 0;
		for (indeks = forste; indeks <= siste; indeks++) {
			data[indeks] = hjelpeTabell[h];
			h++;
		}
	} // flette()

	/**
	 * Radix sort
	 *
	 * Overloads radixSort(data, numOfDigits).
	 * Defaults to two digits.
	 *
	 * @param T data som skal sorteres
	 */
	public static <T extends Comparable<T>> void radixSort(T[] data) {
		radixSort(data, 2);
	}

	/**
	 * Radix sort
	 *
	 * Implemented with circular queues.
	 *
	 * @param T data som skal sorteres
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void radixSort(T[] data, int numOfDigits) {
		String temp;
		T nrObj;
		int digit, nr;
		KoeADT<T>[] digitKoer = new SirkulaerKoe[10];

		// 10 allowed digit-values
		// therefore, we create 10 circular queues
		// and reuse them when necessary down below
		for (int digitValue = 0; digitValue <= 9; digitValue++) {
			digitKoer[digitValue] = new SirkulaerKoe<T>();
		}

		// Sort list
		for (int pos = 0; pos < numOfDigits; pos++) { // per digit
			for (int i = 0; i < data.length; i++) { // per item in array
				temp = String.valueOf(data[i]); // e.g. 213
				// from right to left
				// e.g. 213.charAt(-1, 10) = 2
				digit = Character.digit(temp.charAt(1-pos), 10);
				// insert digit into the queue
				digitKoer[digit].innKoe(data[i]);
			}

			// Gather numbers back into list
			nr = 0;
			for (int digitValue = 0; digitValue <= 9; digitValue++) { // per digit value
				while (!(digitKoer[digitValue].isEmpty())) { // so long as the queue isn't empty
					nrObj = digitKoer[digitValue].utKoe(); // remove from queue
					data[nr] = nrObj; // insert back into array
					nr++; // next
				}
			}
		} // outer loop
	} // radixSort()

}// class
