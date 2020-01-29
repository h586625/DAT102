package no.hvl.dat102.klient;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.*;


public class KlientFilmarkiv {
	
	/**
	 * When we start the program, user will get questioned if he/she wishes to 
	 * work on an existing archive OR create a new archive
	 */
	public static void main(String[] args) {
		FilmarkivADT filmer = Fil.lesFraFil("filmfil.txt");
		if (filmer == null) {
			// Initialize an empty movie archive with 10 free slots
			// if the default file is empty or non-existent.
			filmer = new Filmarkiv(10);
		}
	
		Meny meny = new Meny(filmer);
		meny.start();
	}
}
