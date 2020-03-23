package no.hvl.dat102;

public class SorteringOgSoeking {

	/*************************************************************************************************/
	// Søkealgoritmer
	/*************************************************************************************************/

	/**
	 * Metoden gjør et lineært søk i en tabell av usorterte data
	 *
	 * @param er data som skal søkes i
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
	}

	/**
	 * Metoden gjør et lineært søk i en sortert tabell av data
	 *
	 * @param er data som skal søkes i
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
	}

	/**
	 * Metoden gjør et binært søk i en *sortert* tabell av data
	 *
	 * @param er data som skal søkes i
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
		// verdi osv. selv om vi nødvendig ikke trenger det
		// om første betingelse viser seg å være sann

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

	/* Rekursivt binærsøk som returnerer "indeks" */
	// Alt 3
	public static <T extends Comparable<T>> int binaerSoek3(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til målelementet hvis det fins, ellers -1
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

	/* Ikke-rekursivt binærsøk som returnerer indeks */
	// Alt 4
	public static <T extends Comparable<T>> int binaerSoek4(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til målelementet hvis det fins ellers -1
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
	}

	public static <T extends Comparable<T>> void bobleSortFlagg(T[] data) {
		/*
		 * Sjekker om det ha vært ombyttinger i nåværende gjennomløp.
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

			} // indre løkke
			fase++;

		} while (byttet); // ytre løkke
	}

	/**
	 * Sortering ved innsetting
	 *
	 * @param T data som skal sorteres
	 */
	public static <T extends Comparable<T>> void sorteringVedInnsetting(T[] data) {
		for (int i = 1; i < data.length-1; i++) {
			T nokkel = data[i];
			int p = i;

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
			// Oppretter partisjon
			posPartisjon = finnPartisjon(data, min, maks);
			// Sorter venstreside
			kvikkSort(data, min, posPartisjon-1);
			// Sorter høyreside
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
		// Pivot som første element. Boka bruker midterste.
		pivot = data[min];
		venstre = min;
		hoyre = maks;

		while (venstre < hoyre) {
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}

			while (data[hoyre].compareTo(pivot) > 0) {
				hoyre--;
			}

			// Bytter elementene
			if (venstre < hoyre) {
				tmp = data[venstre];
				data[venstre] = data[hoyre];
				data[hoyre] = tmp;
			}
		} // ytre løkke

		// Flytter pivot til sin riktige og endelige plass
		tmp = data[min];
		data[min] = data[hoyre];
		data[hoyre] = tmp;

		return hoyre;
	} // finnPartisjon()

	/**
	 * Flettesortering
	 *
	 * @param data som skal sorteres
	 * @param <T> tabellen som skal sorteres
	 * @param int første
	 * @param int siste
	 */
	public static <T extends Comparable<T>> void fletteSort(T[] data, int forste, int siste) {
		if (forste < siste) { // Minst to elementer
			int midten = (forste + siste)/2;

			// Sorter venstre halvdel
			fletteSort(data, forste, midten);
			// Sorter høyre halvdel
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
	 * til en flettet sortert tabell
	 *
	 * @param data som skal sorteres
	 * @param <T> tabellen som skal sorteres
	 * @param int minsteverdi
	 * @param int midtverdi
	 * @param int maksverdi
	 */
	public static <T extends Comparable<T>> void flette(T[] data, int forste, int midten, int siste) {
		int stor = siste - forste + 1;
		@SuppressWarnings("unchecked")
		T[] hjelpeTabell = (T[])(new Comparable[stor]);

		// Start/slutt på venstre deltabell
		int forste1 = forste;
		int siste1 = midten;

		// Start/slutt på høyre deltabell
		int forste2 = midten+1;
		int siste2 = siste;

		// Så lenge deltabellene ikke er tomme,
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

		// Kopiere resten av venstre del (kan være tom)
		while (forste1 <= siste1) {
			hjelpeTabell[indeks] = data[forste1];
			forste1++;
			indeks++;
		}

		// kopiere resten av høyre del (kan være tom)
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

}// class
