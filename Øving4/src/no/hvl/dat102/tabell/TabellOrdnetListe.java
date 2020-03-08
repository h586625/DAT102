package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		resultat = siste();
		liste[bak - 1] = null;
		bak--;

		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];

		bak--;
		int j = 0;
		while (j < bak) {
			liste[j] = liste[j + 1];
			j++;
		}

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return liste[0];
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return liste[bak - 1];
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		if (bak == liste.length) {
			utvid();
		}

		int i = 0;
		while (i < bak && element.compareTo(liste[i]) > 0) {
			i++;
		}
		int j = bak;
		while (j > i) {
			liste[j] = liste[j - 1];
			j--;
		}
		liste[i] = element;
		bak++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {

		T resultat = null;

		int indeks = finn(element);

		if (indeks >= 0 && indeks < bak) {
			resultat = liste[indeks];
			for (int pos = indeks; pos < bak - 1; pos++) {
				liste[pos] = liste[pos + 1];
			}
			liste[bak] = null;
			bak--;
		}

		return resultat;

	}

	private int finn(T el) {
		int pos = 0, resultat = IKKE_FUNNET;

		while (pos < bak && resultat == IKKE_FUNNET) {
			if (liste[pos].equals(el) && liste[pos] != null) {
				resultat = pos;
			} else {
				pos++;
			}
		}

		return resultat;
	}

	@Override
	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class