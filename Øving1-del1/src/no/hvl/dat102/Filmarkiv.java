package no.hvl.dat102;

import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private final static int STDK = 1;
	private Film[] filmTabell;
	private int antallFilmer;
	
	public Filmarkiv() {
		this(STDK);
	}
	
	public Filmarkiv(int antall) {
		this.filmTabell = new Film[antall];
		this.antallFilmer = 0;
	}
	
	@Override
	public Film[] hentFilmTabell() {
		return filmTabell;
	}
	
	@Override
	public void leggTilFilm(Film film) {
		if (sokNr(film.getFilmnr()) == -1) {
			if (antallFilmer == filmTabell.length) {
				utvidFilmarkiv();
			}
			filmTabell[antallFilmer] = film;
			System.out.println(
				"Filmen " + "\"" 
				+ filmTabell[antallFilmer].getTittel() 
				+ "\"" + " er nå lagt til."
			);
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
	
	@Override
	public boolean slettFilm(int filmNr) {
		int sok = sokNr(filmNr);
		
		if (sok != -1) {
			// comments show alternative solution
			antallFilmer--;
			System.out.println(
				"Filmen " + "\"" 
				+ filmTabell[sok].getTittel() + "\"" 
				+ " er nå slettet."
			);
			filmTabell[sok] = filmTabell[antallFilmer]; // -1
			filmTabell[antallFilmer] = null; // -1
			// antallFilmer--;
			return true;
		}
		
		System.out.println("Ingen film ble slettet.");
		return false;
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
	
	@Override
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
	
	@Override
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
	
	@Override
	public void skrivUtTitler() {
		System.out.println("=====TITLER=====");
		
		for (int i = 0; i < antallFilmer; i++) {
			System.out.println(filmTabell[i].getTittel());
		}
	}
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		int antallSjangere = 0;
		
		for (int i = 0; i < antallFilmer; i++) {
			Sjanger sj = filmTabell[i].getSjanger();
			
			if (sj != null && sj == sjanger) {
				antallSjangere++;
			}
		}
		
		return antallSjangere;
	}
	
	@Override
	public int antall() {
		return antallFilmer;
	}
}
