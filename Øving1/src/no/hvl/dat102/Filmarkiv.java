package no.hvl.dat102;

import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmTabell;
	private int antallFilmer;
	
	public Filmarkiv(int antall) {
		filmTabell = new Film[antall];
	}
	
	public void leggTilFilm(Film film) {
		if (sokNr(film.getFilmnr()) == -1) {
			if (antallFilmer == filmTabell.length) {
				utvidFilmarkiv();
			}
			filmTabell[antallFilmer] = film;
			antallFilmer++;
		} else {
			System.out.println("Denne filmen eksisterer allerede.");
		}
	}
	
	/**
	 * Add 10% more empty slots to our array
	 */
	public void utvidFilmarkiv() {
		Film[] biggerArray = new Film[(int)Math.ceil(1.1 * filmTabell.length)];
		
		for (int i = 0; i < filmTabell.length; i++) {
			biggerArray[i] = filmTabell[i];
		}
		
		filmTabell = biggerArray;
	}
	
	public boolean slettFilm(int filmNr) {
		int sok = sokNr(filmNr);
		if (sok != -1) {
			// comments show alternative solution
			antallFilmer--;
			filmTabell[sok] = filmTabell[antallFilmer]; // -1
			filmTabell[antallFilmer] = null; // -1
			// antallFilmer--;
			return true;
		}
		
		return false;
	}
	
	public Film[] hentFilmTabell() {
		return filmTabell;
	}
	
	public int sokNr(int filmNr) {
		for (int i = 0; i < antallFilmer; i++) {
			Film fi = filmTabell[i];
			if (fi != null && filmNr == fi.getFilmnr()) {
				return i;
			}
		}
		return -1;
	}
	
	// TODO: nullpointer exception
	public Film[] sokTittel(String delstreng) {
		Film[] tittelTabell = new Film[antallFilmer];
		int teller = 0;
		for (int i = 0; i < antallFilmer; i++) {
			Film fi = filmTabell[i];
			if (fi.getTittel() != null && fi.getTittel().contains(delstreng)) {
				tittelTabell[teller] = fi;
				teller++;
			}
		}
		return tittelTabell;
	}
	
	// TODO: nullpointer exception
	public Film[] sokProdusent(String delstreng) {
		Film[] produsentTabell = new Film[antallFilmer];
		int teller = 0;
		
		for (int i = 0; i < antallFilmer; i++) {
			Film fi = filmTabell[i];
			if (fi.getProdusent() != null && fi.getProdusent().contains(delstreng)) {
				produsentTabell[teller] = fi;
				teller++;
			}
		}
		return produsentTabell;
	}
	
	public void skrivUtTitler() {
		for (int i = 0; i < antallFilmer; i++) {
			System.out.println(filmTabell[i].getTittel());
		}
	}
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; i < antallFilmer; i++) {
			if (filmTabell[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}
	
	public int antall() {
		return antallFilmer;
	}
}
