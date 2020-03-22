package no.hvl.dat102;

public class Kontakt implements Comparable<Kontakt> {
	private String fornavn;
	private String etternavn;
	private String telefonnr;

	public Kontakt(String fnavn, String enavn, String telefon) {
		this.fornavn    = fnavn;
		this.etternavn  = enavn;
		this.telefonnr  = telefon;
	}

	//Returnerer en kontakt som en strengrepresentasjon.
	@Override
	public String toString () {
		return etternavn + ", " + fornavn + "\t" +  telefonnr;
	}

	// Bruker etternavn og fornavn for aa bestemme en
	// leksikografisk ordning.


	@Override
	public int compareTo(Kontakt kontakt){
		int resultat = 0;
		if (etternavn.equals(kontakt.etternavn)){
			resultat = fornavn.compareTo(kontakt.fornavn);
		} else {
			resultat = etternavn.compareTo(kontakt.etternavn);
		}

		return resultat;
	}

}