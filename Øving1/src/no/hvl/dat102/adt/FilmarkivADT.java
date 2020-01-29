package no.hvl.dat102.adt;

import no.hvl.dat102.*;

public interface FilmarkivADT {
	/**
	 * 
	 * @author chris
	 * @param Film film
	 *
	 */
	void leggTilFilm(Film film);

	boolean slettFilm(int filmnr);

	Film[] hentFilmTabell();

	Film[] sokTittel(String delstreng);

	Film[] sokProdusent(String delstreng);
	
	void skrivUtTitler();

	int antallSjanger(Sjanger sjanger);

	int antall();
}
