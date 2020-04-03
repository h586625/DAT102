package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 *
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T foerste() {
		if (erTom()) {
			throw new EmptyCollectionException("ordnet liste");
		}

		return foerste.getElement();
	}

	@Override
	public T siste() {
		if (erTom()) {
			throw new EmptyCollectionException("ordnet liste");
		}

		return siste.getElement();
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom()) {
			throw new EmptyCollectionException("ordnet liste");
		}

		T resultat = foerste.getElement();
		foerste = foerste.getNeste();
		antall--;

		if (erTom()) {
			siste = null;
		}

		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom()) {
			throw new EmptyCollectionException("ordnet liste");
		}

		T resultat = siste.getElement();
		antall--;
		if (antall == 0) {
			foerste = null;
			siste = null;
		} else {
			siste = foerste;
			for (int pos = 1; pos < antall; pos++) {
				siste = siste.getNeste();
			}
			siste.setNeste(null);
		}

		return resultat;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		// Finner evt. posisjonen til element som skal slettes
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		// Sjekker om elementet faktisk er ekvivalent med det som skal slettes
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> ny = new LinearNode<T>(element);

		LinearNode<T> denne = foerste;
		LinearNode<T> forrige = null;

		// finner ut hvor vi skal plassere elementet
		// her vil alltid denne være større enn element
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}

		if (forrige == null) { //sett inn foran
			ny.setNeste(foerste);
			foerste = ny;
		} else { //sett inn mellom forrige og denne
			ny.setNeste(denne);
			forrige.setNeste(ny);
		}
		if (denne == null) { //oppdaterer siste
			siste = ny;
		}
		antall++;
	}

}// class