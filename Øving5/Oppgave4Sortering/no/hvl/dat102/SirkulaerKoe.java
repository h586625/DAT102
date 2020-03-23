package no.hvl.dat102;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int front, bak, antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STDK);
	}

	@SuppressWarnings("unchecked")
	public SirkulaerKoe(int startKapasitet) {
		front = bak = antall = 0;
		koe = ((T[]) (new Object[startKapasitet]));
	}

	@Override
	public void innKoe(T element) {

		if (amount() == koe.length) {
			utvid();
		}

		koe[bak] = element;
		bak = (bak+1) % koe.length;
		antall++;
	}

	public void utvid() {
		@SuppressWarnings("unchecked")
		T[] hjelpeTab = (T[])(new Object[koe.length*2]);

		for (int pos = 0; pos < antall; pos++) {
			hjelpeTab[pos] = koe[front];
			front = (front+1) % koe.length;
		}

		front = 0;
		bak = antall;
		koe = hjelpeTab;
	}

	@Override
	public T utKoe() {

		if (amount() == 0) {
			throw new EmptyCollectionException("Køen");
		}

		T element = koe[front];
		koe[front] = null;
		front = (front+1) % koe.length;
		antall--;

		return element;
	}

	@Override
	public T first() {
		if (isEmpty()) {
			throw new EmptyCollectionException("Køen");
		}
		return koe[front];
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