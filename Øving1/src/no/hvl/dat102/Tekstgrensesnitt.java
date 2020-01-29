package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	/*
	 * Create a Scanner object in lesFilm and keep it open Close it in the end
	 * inside Menu when all reading is done
	 */
	public static Film lesFilm() {

		Film nyFilm;

		Scanner leser = new Scanner(System.in);
		System.out.println("Filmnummer");
		int filmnr = leser.nextInt();
		leser.nextLine();
		System.out.println("Produsent");
		String prod = leser.nextLine();
		System.out.println("Tittel");
		String tittel = leser.nextLine();
		System.out.println("Årstall");
		int aarstall = Integer.parseInt(leser.nextLine());
		System.out.println("Sjanger: Action, Drama, History eller Scifi");
		Sjanger sjang = Sjanger.finnSjanger(leser.nextLine());
		System.out.println("Filmselskap");
		String selskap = leser.nextLine();

		nyFilm = new Film(filmnr, prod, tittel, aarstall, sjang, selskap);

		return nyFilm;
	}
	
	public void visFilm(Film film) {
		String filmInformasjon = "Filmen heter: " + film.getTittel() 
				+ "\nProdusenten heter: " + film.getProdusent()
				+ "\nFilm nummeret er: " + film.getFilmnr() 
				+ "\nFilmen ble utgitt i: " + film.getLanseringsAar()
				+ "\nSjangeren er: " + film.getSjanger() 
				+ "\nFilmselskapet som ga ut filmen heter: "
				+ film.getFilmselskap();
		System.out.println(filmInformasjon);
	}
	
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filmer, String delstreng) {
		Film[] filmTabell = filmer.sokTittel(delstreng);
		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i] != null) {
				System.out.println(filmTabell[i].getTittel());
			}
		}
	}
	
	public void skrivUtFilmProdusent(FilmarkivADT filmer, String delstreng) {
		Film[] produsentTabell = filmer.sokProdusent(delstreng);
		for (int i = 0; i < produsentTabell.length; i++) {
			if (produsentTabell[i] != null) {
				System.out.println(produsentTabell[i].getTittel());
			}
		}
	}
	
	public void skrivUtStatistikk(FilmarkivADT filmer) {
		System.out.println("Antall filmer: " + filmer.antall());
		System.out.println("Antall sjangere: ");
		Sjanger[] sjangere = Sjanger.values();
		for (int i = 0; i < sjangere.length; i++) {
			System.out.println(sjangere[i] + ": " + filmer.antallSjanger(Sjanger.values()[i]));
		}
	}
}
