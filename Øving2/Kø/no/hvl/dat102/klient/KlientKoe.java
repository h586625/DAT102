package no.hvl.dat102.klient;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.KjedetKoe;
import no.hvl.dat102.sirkulaer.SirkulaerKoe;
import no.hvl.dat102.tabell.TabellKoe;

public class KlientKoe {
	public static void main(String[] args) {

		String str = "Jeg er en String";
		int lengde = str.length();
		
		KjedetKoe<Character> tegnKoe = new KjedetKoe<Character>();
		for (int i = 0; i < lengde; i++) {
			tegnKoe.innKoe((str.charAt(i)));
		}
		
		System.out.println("Kjedet kø:");
		System.out.println("Amount: " + tegnKoe.amount());
		
		try {
			while (!tegnKoe.isEmpty()) {
				Character tegn = tegnKoe.utKoe();
				System.out.println(tegn);
			}
			System.out.println();
		} catch (EmptyCollectionException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("================");
		System.out.println();
		
		SirkulaerKoe<Character> tegnKoe2 = new SirkulaerKoe<Character>();
		for (int i = 0; i < lengde; i++) {
			tegnKoe2.innKoe((str.charAt(i)));
		}
		
		System.out.println("Sirkulær kø:");
		System.out.println("Amount: " + tegnKoe2.amount());
		
		try {
			while (!tegnKoe2.isEmpty()) {
				Character tegn = tegnKoe2.utKoe();
				System.out.println(tegn);
			}
			System.out.println();
		} catch (EmptyCollectionException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("================");
		System.out.println();
		
		TabellKoe<Character> tegnKoe3 = new TabellKoe<Character>();
		for (int i = 0; i < lengde; i++) {
			tegnKoe3.innKoe((str.charAt(i)));
		}
		
		System.out.println("Tabell kø:");
		System.out.println("Amount: " + tegnKoe3.amount());
		
		try {
			while (!tegnKoe3.isEmpty()) {
				Character tegn = tegnKoe3.utKoe();
				System.out.println(tegn);
			}
			System.out.println();
		} catch (EmptyCollectionException ex) {
			System.out.println(ex.getMessage());
		}
	}// main

}// class
