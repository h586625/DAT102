package no.hvl.dat102.adt;

import no.hvl.dat102.*;

public interface FilmarkivADT {

	/**
	 * A get method for returning the movie array.
	 * @return Film[]
	 */
	Film[] hentFilmTabell();
	
	/**
	 * Add a movie to the movie array.
	 * @param Film film
	 */
	void leggTilFilm(Film film);

	/**
	 * Delete a movie from the movie array.
	 * @param int filmnr
	 * @return boolean
	 */
	boolean slettFilm(int filmnr);
	
	/**
	 * Search for a movie title using a substring.
	 * E.g. sokTittel("Lo") -> Lord of the rings, ...
	 * @param String delstreng
	 * @return Film[]
	 */
	Film[] sokTittel(String delstreng);

	/**
	 * Search for a movie producer using a substring.
	 * E.g. sokProdusent("St") -> Steven Spielberg, ...
	 * @param String delstreng
	 * @return Film[]
	 */
	Film[] sokProdusent(String delstreng);
	
	/**
	 * Prints all the movie titles from the movie array.
	 */
	void skrivUtTitler();

	/**
	 * Returns the amount of enum Sjanger used 
	 * by the movies in the movie array.
	 * @param Sjanger sjanger
	 * @return int
	 */
	int antallSjanger(Sjanger sjanger);

	/**
	 * Returns the first index in the movie array
	 * that's unused.
	 * @return int
	 */
	int antall();
}
