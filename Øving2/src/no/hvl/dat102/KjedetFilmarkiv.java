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
		// 3. Elementet er midt inni eller bak? Slett
		if (start != null) {
			// 2.
			if (start.getNeste() == null) {
				start = null;
			} else {
				while (current != null) {
					// 3.
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
	
	@Override
	public Film[] sokTittel(String delstreng) {

		LinearNode<Film> current = start;

		// Part one: find amount in order to create array in correct length
		int ant = 0;
		while (current != null) {
			if (current.getElement().getTittel().contains(delstreng)) {
				ant++;
			}
			current = current.getNeste();
		}

		current = start;
		// Part two: create array and copy objects
		Film[] tittelTab = new Film[ant];
		int pos = 0;
		while (current != null) {
			if (current.getElement().getTittel().contains(delstreng)) {
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
		
		//Part one: find amount in order to create array in correct length
		int ant = 0;
		while (current != null) {
			if (current.getElement().getProdusent().contains(delstreng)) {
				ant++;
			}
			current = current.getNeste();
		}
		
		//Part two: create array and copy objects
		Film[] prodTab = new Film[ant];
		int pos = 0;
		while (current != null) {
			if (current.getElement().getProdusent().contains(delstreng)) {
				prodTab[pos] = current.getElement();
				pos++;
			}
			current = current.getNeste();
		}

		return prodTab;
	}
	
	@Override
	public void skrivUtTitler() {
		
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
	
	public static void main(String[] args) {
		KjedetFilmarkiv arkiv = new KjedetFilmarkiv();
		arkiv.leggTilFilm(
				new Film(1, "Quentin Tarantino", "Once Upon a Time In Hollywood", 2019, Sjanger.DRAMA, "New Line Cinema"));
		arkiv.leggTilFilm(
				new Film(2, "Quentin Tarantino", "Django Unchained", 2012, Sjanger.ACTION, "New Line Cinema"));
		arkiv.leggTilFilm(
				new Film(3, "Tony Kaye", "American History X", 1998, Sjanger.DRAMA, "New Line Cinema"));
		
		Tekstgrensesnitt.skrivUtFilmDelstrengITittel(arkiv, "In");
		
		
	}
}
