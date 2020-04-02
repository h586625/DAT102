package no.hvl.dat102;

import no.hvl.dat102.adt.TabellHaugADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellHaug<T extends Comparable<T>> implements TabellHaugADT<T> {
	private T[] data;
	private int antal;
	private static final int STDK = 100;

	public TabellHaug() {
		this(STDK);
	}

	@SuppressWarnings("unchecked")
	public TabellHaug(int startKapasitet) {
		data = (T[]) new Comparable[startKapasitet];
		antal = 0;
	}

	@Override
	public int antall() {
		return antal;
	}

	@Override
	public boolean erTom() {
		return antal == 0;
	}

	private void utvidTabell() {
		// ikkje implementert
	}

	@Override
	public void leggTilElement(T el) {
		if (antal == data.length) {
			utvidTabell();
		}

		data[antal] = el;
		antal++;

		if (antal > 1) {
			reparerOpp();
		}
	}

	/*
	 * Har komplett tre der alle nodane bortsett frå den siste har ein dataverdi
	 * som er større eller lik dataverdien i foreldernoden. Metoden reparer eventuell
	 * feil slik at vi etter kallet har fått ein haug
	 */
	private void reparerOpp() {
		int rettPlass = antal - 1;
		T tmp = data[rettPlass];
		int forelder = (rettPlass - 1) / 2;

		while (rettPlass > 0 && tmp.compareTo(data[forelder]) < 0) {
			data[rettPlass] = data[forelder];
			rettPlass = forelder;
			forelder = (rettPlass-1)/2;
		}

		data[rettPlass] = tmp;
	}

	@Override
	public T fjernMinste() throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("TabellHaug");
		}

		T minElement = data[0];
		data[0] = data[antal - 1];
		antal--;
		reparerNed();

		return minElement;
	}

	/*
	 * Har komplett tre der alle nodane bortsett frå rota har ein dataverdi som er mindre
	 * enn eller lik dataveriden i barna. Metoden reparer eventuell feil slik at vi etter
	 * kallet har fått ein haug
	 */
	private void reparerNed() {
		T tmp = data[0];
		int vb;
		int hb;
		int rettPlass = 0;
		int min;
		boolean ferdig = false;

		do {
			vb = 2 * rettPlass + 1;
			hb = vb + 1;
			// Viss noden ikkje er blad, må den ha venstrebarn (elles har vi ikkje eit komplett tre)
			if (vb < antal) {
				min = vb;
				if (hb < antal) {
					if (data[hb].compareTo(data[vb]) < 0) {
						min = hb;
					}
				}
				if (data[min].compareTo(tmp) < 0) {
					data[rettPlass] = data[min];
					rettPlass = min;
				} else {
					ferdig = true;
				}
			} else {
				ferdig = true;
			}
		} while (!ferdig);

		data[rettPlass] = tmp;
	}
}
