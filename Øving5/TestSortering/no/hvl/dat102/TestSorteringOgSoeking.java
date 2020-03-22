package no.hvl.dat102;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSorteringOgSoeking {

	private static final int SIZE = 1000;
	private static Integer[] elementer;
	private Integer[] kopier = new Integer[SIZE];

	@BeforeAll
	public static void initialiser() {
		// Creates a new array with n(SIZE) random integers
		elementer = new Integer[SIZE];
		Random rInt = new Random();
		for (int i = 0; i < elementer.length; i++) {
			elementer[i] = rInt.nextInt();
		}
	}

	@BeforeEach
	public final void setup() {
		for (int i = 0; i < kopier.length;  i++) {
			kopier[i] = elementer[i];
		}
	}

	@Test
	public final void testUtvalgssortering() {
		SorteringOgSoeking.utvalgsSortering(kopier);
		boolean sortert = erSortert(kopier);
		assertTrue(sortert);
	}

	private static <T extends Comparable<T>> boolean erSortert(T[] data) {
		boolean sortert = true;
		for (int i = 0; i < data.length-1 && sortert; i++) {
			sortert = data[i].compareTo(data[i + 1]) <= 0;
		}
		return sortert;
	}

}