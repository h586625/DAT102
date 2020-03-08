package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class KlientPerson {

	public static void main(String[] args) {

		Person anne = new Person("Anne", "Iversen", 1995);
		Person ole = new Person("Ole", "Vik", 1996);
		Person bendik = new Person("Bendik", "Ness", 1997);
		Person ida = new Person("Ida", "Mjelde", 1991);
		Person arne = new Person("Arne", "Mjelde", 1991);

		//Muligheten for å skrive inn detaljer til en person
		Scanner leser = new Scanner(System.in);
		String fornavn, etternavn;
		int foedselsaar;
		System.out.println("Fornavn: ");
		fornavn = leser.next();
		System.out.println("Etternavn: ");
		etternavn = leser.next();
		System.out.println("Fødselsår: ");
		foedselsaar = Integer.parseInt(leser.next());

		leser.close();

		Person personManuell = new Person(fornavn, etternavn, foedselsaar);

		OrdnetListeADT<Person> liste = new TabellOrdnetListe<Person>();

		liste.leggTil(anne);
		liste.leggTil(ole);
		liste.leggTil(bendik);
		liste.leggTil(ida);
		liste.leggTil(arne);
		liste.leggTil(personManuell);

		Person person = null;

		while(!liste.erTom()) {
			person = liste.fjernFoerste();
			System.out.println(person);
		}

	} //main
}
