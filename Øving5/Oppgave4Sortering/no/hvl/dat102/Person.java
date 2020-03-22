package no.hvl.dat102;

public class Person implements Comparable<Person> {
	private String fornavn;
	private String etternavn;


	public Person() {
		this("", "");

	}
	public Person(String fornavn, String etternavn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}

	// Returnerer en kontakt som en strengrepresentasjon.
	@Override
	public String toString() {
		return (etternavn + ", " + fornavn + "\t");
	}

	// Bruker etternavn og fornavn for å bestemme en
	// leksikografisk ordning.

	@Override
	public int compareTo(Person person) {
		int resultat = 0;
		if (etternavn.equals(person.etternavn)) {
			resultat = fornavn.compareTo(person.fornavn);
		} else {
			resultat = etternavn.compareTo(person.etternavn);
		}
		return resultat;
	}

}