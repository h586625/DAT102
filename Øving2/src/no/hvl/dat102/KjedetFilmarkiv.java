package no.hvl.dat102;

import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;

public class KjedetFilmarkiv implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> start;
	// OBS! Ingen referanse til siste, kun start
	
	public KjedetFilmarkiv() {
		this.start = new LinearNode<Film>();
		this.antall = 0;
	}
	
	@Override
	public Film[] hentFilmTabell() {
		
	}
	
	@Override
	public void leggTilFilm(Film film) {
		LinearNode<Film> nyNode = new LinearNode<Film>(film);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
	
	public boolean inneholder(Film element) {
		LinearNode<Film> denne = start;
		while (denne != null && !element.equals(denne.getElement())) {
			denne = denne.getNeste();
		}
		return (denne != null);
	}
	
	@Override
	public boolean slettFilm(int filmNr) {
		boolean slettet = false;
		LinearNode<Film> prev = null;
		LinearNode<Film> current = start;
		// 1. Tom liste? Ikke foreta noe
		// 2. Elementet er det første. Oppdater start
		// 3. Elementet er midt inni eller bak? Slett
		if (start != null) {
			if (start.getNeste() == null) {
				start = null;
			} else {
				while (current != null) {
					if (current.getElement().getFilmnr() == filmNr) {
						prev.setNeste(current.getNeste());
						prev = current;
					}
				}
			}
			antall--;
			slettet = true;
		}
		return slettet;
	}
	
	public int sokNr(int filmNr) {
		
		return -1;
	}
	
	@Override
	public Film[] sokTittel(String delstreng) {
		
	}
	
	@Override
	public Film[] sokProdusent(String delstreng) {
		
	}
	
	@Override
	public void skrivUtTitler() {
		
	}
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		
	}
	
	@Override
	public int antall() {
		
	}
}
