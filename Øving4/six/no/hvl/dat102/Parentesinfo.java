package no.hvl.dat102;

public class Parentesinfo{

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
		return String.format("Åpnesymbol %c på linje nr %d, tegn nr %d har feil lukkeparentes", venstreparentes, linjenr, posisjon);
	}

	public String toStringRest() {
		return String.format("Åpnesymbol %c på linje nr %d, teikn nr %d mangler tilsvarande lukkeparentes", venstreparentes, linjenr, posisjon);
	}
	public String toStringTomStabel() {
		return String.format("Lukkesymbol %c på linjenr %d, teikn nr %d mangler tilsvarende åpneparentes.", venstreparentes, linjenr, posisjon);
	}
}
