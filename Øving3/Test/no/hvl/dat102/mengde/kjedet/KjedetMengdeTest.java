package no.hvl.dat102.mengde.kjedet;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.adt.MengdeADTTest;

public class KjedetMengdeTest extends MengdeADTTest {

	@Override
	protected MengdeADT<Integer> reset() {
		return new KjedetMengde<Integer>();
	}
}
