package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.adt.MengdeADTTest;

public class TabellMengdeTest extends MengdeADTTest {

	@Override
	protected MengdeADT<Integer> reset() {
		return new TabellMengde<Integer>();
	}
}
