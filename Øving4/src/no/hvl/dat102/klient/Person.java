package no.hvl.dat102.klient;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int foedselsaar;

	public Person() {
		this("", "", 0);
	}

	public Person(String fornavn, String etternavn, int foedselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.foedselsaar = foedselsaar;
	}

	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	int getFoedselsaar() {
		return foedselsaar;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	@Override
	public String toString() {
		return (foedselsaar + "\t" + etternavn + ", " + fornavn);
	}

	@Override
	public int compareTo(Person denAndrePersonen) {
		int resultat = 0;

		if (foedselsaar > denAndrePersonen.getFoedselsaar()) {
			resultat = -1;
		} else if (foedselsaar < denAndrePersonen.getFoedselsaar()) {
			resultat = 1;
		} else {
			if (etternavn.compareTo(denAndrePersonen.getEtternavn()) < 0) {
				resultat = -1;
			} else if (etternavn.compareTo(denAndrePersonen.getEtternavn()) > 0) {
				resultat = 1;
			} else {
				if (fornavn.compareTo(denAndrePersonen.getFornavn()) < 0) {
					resultat = -1;
				} else if (fornavn.compareTo(denAndrePersonen.getFornavn()) > 0) {
					resultat = 1;
				} else {
					resultat = 0;
				}
			}
		}

		return resultat;
	}

}
