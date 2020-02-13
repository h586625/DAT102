package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.exception.EmptyCollectionException;

public class TabellKoe<T> implements KoeADT<T> {
	private final static int STDK = 100;
	private int bak;
	private T[] koe;

	/******************************************************************
	 * Oppretter en tom kø med standard størrelse.
	 ******************************************************************/
	public TabellKoe() {
		this(STDK);
	}

	/******************************************************************
	 * Oppretter en tom kø med kapasitet gitt ved parameter
	 ******************************************************************/
	public TabellKoe(int startKapasitet) {
		bak = 0; // index for adding new elements and number of elements in the queue
		koe = (T[]) (new Object[startKapasitet]);
	}

	@Override
	public void innKoe(T element) {

		if (koe.length == bak) {
			utvid();
		}

		koe[bak] = element;
		bak++;
	}

	//Hjelpemetode
	public void utvid() {

		T[] hjelpeTab = (T[]) (new Object[(int) Math.ceil(1.1 * koe.length)]); 
		for (int pos = 0; pos < koe.length; pos++) {
			hjelpeTab[pos] = koe[pos];
		}
		koe = hjelpeTab;
	}

	@Override
	public T utKoe() {

		if (isEmpty()) {
			throw new EmptyCollectionException("Køen er tom.");
		}

		T element = koe[0];
		bak--;

		for (int pos = 0; pos < bak; pos++) {
			koe[pos] = koe[pos + 1];
		}

		return element;
	}

	@Override
	public T first() {
		if (isEmpty()) {
			throw new EmptyCollectionException("Køen er tom.");
		}
		
		T firstElement = koe[0];
		return firstElement;
	}

	@Override
	public boolean isEmpty() {
		return (bak == 0);
	}

	@Override
	public int amount() {
		return bak;
	}

}