package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

//********************************************************************
// 
//  Representer en samling koe, implementert vha kjedet struktur
//********************************************************************

public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> front, bak;
	
	public KjedetKoe() {
		front = bak = null;
		antall = 0;
	}

	@Override
	public void innKoe(T element) {

		LinearNode<T> nyNode = new LinearNode<T>(element);
		
		if (isEmpty()) {
			front = nyNode;
		} else {
			bak.setNeste(nyNode);
		}
		
		bak = nyNode;
		antall++;
		
	}

	@Override
	public T utKoe() {

		if (isEmpty()) {
			bak = null;
			throw new EmptyCollectionException("Køen er tom.");
		}

		T element = front.getElement();
		front = front.getNeste();
		antall--;
		
		return element;
	}

	@Override
	public T first() {
		
		if ( isEmpty()) {
			throw new EmptyCollectionException("Køen er tom.");
		}
		
		T element = front.getElement();
		return element;
	}

	@Override
	public boolean isEmpty() {
		return (amount() == 0);
	}

	@Override
	public int amount() {
		return antall;
	}

}