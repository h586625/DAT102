package no.hvl.dat102.klient;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.*;


public class KlientFilmarkiv {
	
	/**
	 * When we start the program, user will get questioned if he/she wishes to 
	 * work on an existing archive OR create a new archive
	 */
	public static void main(String[] args) {
		FilmarkivADT filmer = new KjedetFilmarkiv();
	
		Meny meny = new Meny(filmer);
		meny.start();
	}
}
