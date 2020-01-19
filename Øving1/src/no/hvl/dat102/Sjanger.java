package no.hvl.dat102;

public enum Sjanger {
	ACTION, DRAMA, HISTORY, SCFI;
	
/*
 * Konstruktøren er gitt implisitt og er private
	
*/

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}// metode

}// class
