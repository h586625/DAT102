package no.hvl.dat102.adt;

//error when trying to add import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public abstract class KoeADTTest {

	// Reference to queue
	private KoeADT<Integer> koe;

	// Test data
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Get a new queue before each test
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/**
	 * Testing that the new queue is empty
	 */
	@Test
	public void newKoeIsEmpty() {
		assertTrue(koe.isEmpty());
	}

	/**
	 * Testing adding element to queue
	 */
	@Test
	public void addAndDelete() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("Sletting feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing add and delete with duplicates
	 */
	@Test
	public void addAndDeleteDuplicate() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("XXXX feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing the first element
	 */
	@Test
	public void firstElement() {
		try {
			koe.innKoe(e2);
			koe.utKoe();
			koe.innKoe(e3);
			koe.innKoe(e4);
			koe.utKoe();
			assertEquals(e4, koe.first());

		} catch (EmptyCollectionException e) {
			fail("XXXX feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing that a queue with some elements is not empty
	 */
	@Test
	public void isNotEmpty() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.isEmpty());
	}

	/**
	 * Testing that a queue with no elements is empty
	 */
	@Test
	public void addDeleteIsEmpty() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.isEmpty());
		} catch (EmptyCollectionException e) {
			fail("XXXX feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing the size of the queue
	 */
	@Test
	public void size() {
		koe.innKoe(e2);
		koe.innKoe(e1);
		koe.innKoe(e1);
		assertEquals(3, koe.amount());
	}

	/**
	 * Attempt to delete from an empty queue will result in "underflow exception"
	 * 
	 * @throws EmptyCollectionException expected exception
	 */
	@Test
	public void deleteFromEmptyIsUnderflowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 * 
		 * @Override public void execute() throws Throwable { stabel.pop(); } });
		 */

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
}