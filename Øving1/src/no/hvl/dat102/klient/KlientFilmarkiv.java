package no.hvl.dat102.klient;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.*;


public class KlientFilmarkiv {
	
	public static void main(String[] args) {		
		FilmarkivADT filmer = new Filmarkiv(10);
		Meny meny = new Meny(filmer);
		
		System.out.println();
		filmer.skrivUtTitler();
		System.out.println();
				
		Fil.skrivTilFil(filmer, "filtest.txt");
		Filmarkiv fil = Fil.lesFraFil("filmfil.txt");
		fil.skrivUtTitler();
		meny.start();
	}
}
