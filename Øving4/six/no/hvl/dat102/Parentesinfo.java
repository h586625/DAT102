package no.hvl.dat102;

public class Parentesinfo {

	private int linjenr;
	private int posisjon;
	private char venstreparentes;

	public Parentesinfo() {
		linjenr = -1;
		posisjon = -1;
		venstreparentes = ')';
	}

	public Parentesinfo(int linjenr, int posisjon, char parentes) {
		this.linjenr = linjenr;
		this.posisjon = posisjon;
		this.venstreparentes = parentes;
	}

	public void setLinjenr(int nyttLinjenr) {
		linjenr = nyttLinjenr;
	}

	public void setPosisjon(int nyPosisjon) {
		posisjon = nyPosisjon;
	}

	public void setVenstreparentes(char nyVenstreparentes) {
		venstreparentes = nyVenstreparentes;
	}

	public int getLinjenr(){ return linjenr; }

	public int getPosisjon(){ return posisjon; }

	public char getVenstreparentes(){ return venstreparentes; }

	public String toStringIkkeBalansert() {
		return String.format("Åpningsparentes \"%c\" \npå linjenr. %d, \ntegn nr. %d \nhar feil lukkeparentes.", venstreparentes, linjenr, posisjon);
	}

	public String toStringRest() {
		return String.format("Åpningsparentes \"%c\" \npå linjenr. %d, \ntegn nr. %d \nmangler tilsvarende lukkeparentes.", venstreparentes, linjenr, posisjon);
	}
	public String toStringTomStabel() {
		return String.format("Lukkeparentes \"%c\" \npå linjenr. %d, \ntegn nr. %d \nmangler tilsvarende åpningsparentes.", venstreparentes, linjenr, posisjon);
	}
}
