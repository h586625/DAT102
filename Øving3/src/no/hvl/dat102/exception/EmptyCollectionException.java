package no.hvl.dat102.exception;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen når samlingen er tom
//********************************************************************
public class EmptyCollectionException extends RuntimeException {
	private static final long serialVersionUID = -8753198378448860919L;

	/******************************************************************
	 * Setter opp et unntak med passende melding.
	 ******************************************************************/
	public EmptyCollectionException(String samling) {
		super("" + samling + " er tom.");
	}
}
