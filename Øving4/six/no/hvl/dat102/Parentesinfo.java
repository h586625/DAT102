package no.hvl.dat102;

//-----------------------------------------
//
//Balansering av uttrykk med parenteser {},(),[]
//} ] ) kalles lukkete symboler (høyre)
// { [ ( kalles for åpne symboler (venstre)
//...{... [...(...)...]...}... lovlig (balansert) utrykk
//...{...(...[...)...]...}...  ulovlig (ikke balansert) uttrykk
//algoritme balansering
//    Lag en tom stabel
//    så lenge( ikke-slutt på strengen og fortsatt balansert){
//      hvis symbolet er åpent
//             stable det på
//      ellers hvis  symbolet er lukket
//           hvis stabelen er tom
//              sett fortsatt = usann, feilmelding
//           ellers
//                stable av symbol (åpent symbol)
//                hvis det åpne symbolet ikke svarer til det sist leste
//                lukkete symbolet
//                    sett fortsatt = usann, feilmelding
//  }
//    hvis stabelen er ikke-tom så feilmelding */

public class Parentesinfo{

	private int linjenr;
	private int posisjon;
	private char venstreparentes;

	public Parentesinfo(){
		linjenr  = -1;
		posisjon = -1;
		venstreparentes = ')';
	}

	public void setLinjenr(int nyttLinjenr){
		linjenr = nyttLinjenr;
	}

	public void setPosisjon(int nyPosisjon){
		posisjon = nyPosisjon;

	}

	public void setVenstreparentes(char nyVenstreparentes){
		venstreparentes = nyVenstreparentes;
	}

	public int getLinjenr(){ return linjenr;}

	public int getPosisjon(){ return posisjon;}

	public char getVenstreparentes(){ return venstreparentes;}


}//class
