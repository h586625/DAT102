package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			leggTilUbetinget(element);
		}
	}
	
	public void leggTilUbetinget(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom()) {
			throw new EmptyCollectionException("mengde");
		}

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {
		// Søker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom()) {
			throw new EmptyCollectionException("mengde");
		}

		boolean funnet = false;
		T svar = null;

		for (int i = 0; (i < antall) && (!funnet); i++) {
            if (this.inneholder(element)) {
            	svar = tab[i];
            	tab[i] = tab[antall - 1];
            	tab[antall -1] = null;
            	antall--;
            	funnet = true;
            }
		}
		
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(Object m2) {
		boolean likeMengder = true;
		T element;

		MengdeADT<T> mengde2 = (TabellMengde<T>)m2;

		if (this.antall() == mengde2.antall()) {
            Iterator<T> teller = mengde2.oppramser();
            while (teller.hasNext() && likeMengder) {
            	element = teller.next();
                if (!(this.inneholder(element))) {
                    likeMengder = false;
                }
            }
        } else {
            likeMengder = false;
        }
		
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			if (!inneholder(teller.next())) {
				leggTil(teller.next());
			}
		}
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();
		T element = null;

		for (int i = 0; i < antall; i++) {
			element = tab[i];
			// we have to type-cast because our interface 
			// doesn't define leggTilUbetinget()
			// and we can therefore not use it as a reference anymore
			((TabellMengde<T>) begge).leggTilUbetinget(element);
		}

		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			element = teller.next();
			if (!inneholder(element)) {
				((TabellMengde<T>) begge).leggTilUbetinget(element);
			}
		}

		return begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element = null;

		Iterator<T> teller = m2.oppramser();
		
		while (teller.hasNext()) {
			element = teller.next();
			if (inneholder(element)) {
				((TabellMengde<T>) snittM).leggTilUbetinget(element);
			}
		}

		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element;

		Iterator<T> teller = this.oppramser();

		while (teller.hasNext()) {
			element = teller.next();
			if (!m2.inneholder(element)) {
				((TabellMengde<T>) differensM).leggTilUbetinget(element);
			}
		}

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;

		if (m2.antall() > this.antall()) {
			return false;
		}
		
		T element;

		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext() && erUnderMengde) {
			element = teller.next();
			if (!inneholder(element)) {
				erUnderMengde = false;
			}
		}

		return erUnderMengde;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}

	

}// class
