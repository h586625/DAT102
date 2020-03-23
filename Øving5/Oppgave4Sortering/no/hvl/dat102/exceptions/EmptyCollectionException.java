package no.hvl.dat102.exceptions;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerersituasjonen n�r samlingen er tom.
//********************************************************************

public class EmptyCollectionException extends RuntimeException{

	private static final long serialVersionUID = 4534696810511417364L;

	/******************************************************************
     Setter opp dette unntaket med passende melding.
	 ******************************************************************/
	public EmptyCollectionException (String collection){
		super (" Denne " + collection + " er tom.");
	}
}