package no.hvl.dat102;

import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;

public class KjedetFilmarkiv implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> start = null;
	// OBS! Ingen referanse til siste, kun start
	
	public KjedetFilmarkiv() {
		this.antall = 0;
	}
	
	@Override
	public Film[] hentFilmTabell() {
		Film[] filmTab = new Film[antall];
		LinearNode<Film> current = start;

		int pos = 0;
		while (current != null) {
			filmTab[pos] = current.getElement();
			pos++;
			current = current.getNeste();
		}
		return filmTab;
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
		// 3. Elementet er midt inni eller bakerst? Slett
		if (start != null) {
			// 2.
			if (start.getElement().getFilmnr() == filmNr) {
				start = start.getNeste();
				antall--;
				slettet = true;
			} else {
				// We only delete one movie at a time, even though
				// there may be movies with duplicate movie numbers.
				while (current != null && !slettet) {
					// 3.
					if (current.getElement().getFilmnr() == filmNr) {
						prev.setNeste(current.getNeste());
						antall--;
						slettet = true;
					}
					prev = current;
					current = current.getNeste();
				}
			}
		}
		return slettet;
	}
	
	@Override
	public Film[] sokTittel(String delstreng) {

		LinearNode<Film> current = start;
		delstreng.toLowerCase();

		// Part one: find amount in order to create array in correct length
		int ant = 0;
		
		while (current != null) {
			if (current.getElement().getTittel().toLowerCase().contains(delstreng)) {
				ant++;
			}
			current = current.getNeste();
		}

		current = start;
		// Part two: create array and copy objects
		Film[] tittelTab = new Film[ant];
		int pos = 0;
		while (current != null) {
			if (current.getElement().getTittel().toLowerCase().contains(delstreng)) {
				tittelTab[pos] = current.getElement();
				pos++;
			}
			current = current.getNeste();
		}

		return tittelTab;
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		
		LinearNode<Film> current = start;
		delstreng.toLowerCase();
		
		//Part one: find amount in order to create array in correct length
		int ant = 0;
		
		while (current != null) {
			if (current.getElement().getProdusent().toLowerCase().contains(delstreng)) {
				ant++;
			}
			current = current.getNeste();
		}
		
		//Part two: create array and copy objects
		Film[] prodTab = new Film[ant];
		int pos = 0;
		while (current != null) {
			if (current.getElement().getProdusent().toLowerCase().contains(delstreng)) {
				prodTab[pos] = current.getElement();
				pos++;
			}
			current = current.getNeste();
		}

		return prodTab;
	}
	
	@Override
	public void skrivUtTitler() {
		System.out.println("=====TITLER=====");
		
		for (int i = 0; i < hentFilmTabell().length; i++) {
			System.out.println(hentFilmTabell()[i].getTittel());
		}
	}
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		
		int antallSjanger = 0;
		LinearNode<Film> current = start;
		
		while (current != null) {
			if (current.getElement().getSjanger() == sjanger) {
				antallSjanger++;
			}
			current = current.getNeste();
		}

		return antallSjanger;
	}
	
	@Override
	public int antall() {
		return antall;
	}
}
