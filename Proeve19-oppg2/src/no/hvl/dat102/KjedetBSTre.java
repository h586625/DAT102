package no.hvl.dat102;

//********************************************************************
// KjedetBinærSøkeTre.java
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {

	private int antall;
	private BinaerTreNode<T> rot;

	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		if (element.compareTo(p.getElement()) >= 0) {
			BinaerTreNode<T> hoyre = p.getHoyre();
			leggTilRek(hoyre, element);
			if (hoyre == null) {
				p.setHoyre(new BinaerTreNode<T>(element));
				return p;
			}
		}
		return null;
	}

	@Override
	public T fjernMin() {
		// TODO Blir skriven i forelesing
		return null;
	}//

	@Override
	public T fjernMaks() {
		// TODO Blir skriven i forelesing
		return null;
	}//

	@Override
	public T finnMin() {
		// TODO Blir skriven i forelesing
		return null;
	}//

	@Override
	public T finnMaks() {
		// TODO Blir skriven i forelesing
		return null;
	}//









	// LRP
	public void visPostorden() {
		visRekPostorden(rot);
		System.out.println();
	}

	private void visRekPostorden(BinaerTreNode<T> p) {
		if (p == null) return;

		visRekPostorden(p.getVenstre());

		visRekPostorden(p.getHoyre());

		System.out.print(p.getElement() + " ");
	}

	@Override
	public T finn(T element) {
		return finnRek(element, rot);
	}

	private T finnRek(T element, BinaerTreNode<T> p) {
		return element;
	}

	public boolean erIdentisk(KjedetBSTre<T> t){
		return erIdentiskRek(rot, t.rot);
	}

	private boolean erIdentiskRek(BinaerTreNode<T> t1, BinaerTreNode<T> t2){


		return false;
	}

} // class
