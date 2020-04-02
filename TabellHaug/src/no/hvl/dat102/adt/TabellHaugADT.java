package no.hvl.dat102.adt;

public interface TabellHaugADT<T> {
	int antall();

	boolean erTom();

	void leggTilElement(T el);

	T fjernMinste();
}
