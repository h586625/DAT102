package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	public Film lesFilm() {
		System.out.println("Skriv inn film du leter etter.");
		Scanner leser = new Scanner(System.in);
		String film = leser.nextLine();
		
		//for(int i = 0; i < )
		
		return null;
	}
	
	public void visFilm(Film film) {
		
	}
	
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filmer, String delstreng) {
		Film[] filmTabell = filmer.sokTittel(delstreng);
	}
	
	public void skrivUtFilmProdusent(FilmarkivADT filmer, String delstreng) {
		
	}
	
	public void skrivUtStatistikk(FilmarkivADT filmer) {
		
	}
	
	// evt. andre metoder
	
	public static void main(String[] args) {
		Filmarkiv filmarkiv = new Filmarkiv(10);
		filmarkiv.leggTilFilm(new Film());
		filmarkiv.leggTilFilm(new Film());
	}
	
}
