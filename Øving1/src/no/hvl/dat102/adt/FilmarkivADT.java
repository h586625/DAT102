package no.hvl.dat102.adt;

import no.hvl.dat102.*;

public interface FilmarkivADT {

	Film[] hentFilmTabell();
	
	void leggTilFilm(Film film);

	boolean slettFilm(int filmnr);
	
	int sokNr(int filmnr);

	Film[] sokTittel(String delstreng);

	Film[] sokProdusent(String delstreng);
	
	void skrivUtTitler();

	int antallSjanger(Sjanger sjanger);

	int antall();
}
