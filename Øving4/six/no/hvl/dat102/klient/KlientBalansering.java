package no.hvl.dat102.klient;

import no.hvl.dat102.Balansering;

public class KlientBalansering {
	public static void main(String[] args){
		final String filnavn = "data3.txt";
		//Leser inn en tekst fra fil
		Balansering balansering = new Balansering();
		balansering.lesFraFil(filnavn);
	}//main

}//class
