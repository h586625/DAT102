package no.hvl.dat102.datakontakt;

public class Hobby {
	private String hobbyNavn;

	public Hobby(String hobby){
		hobbyNavn = hobby;
	}

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public void setHobbyNavn(String navn) {
		hobbyNavn = navn;
	}

	public String toString(){
		return hobbyNavn;
	}

	public boolean equals(Object hobby2){ //
		Hobby hobbyDenAndre = (Hobby)hobby2;
		return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
}
