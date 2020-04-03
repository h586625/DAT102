package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.tabell.TabellKoe;

public class TabellKoeTest extends KoeADTTest {

	@Override
	protected KoeADT<Integer> reset() {
		return new TabellKoe<Integer>();
	}

	
}