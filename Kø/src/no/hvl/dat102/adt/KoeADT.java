package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;

public interface KoeADT<T> {

	/**
	 * @param element :
	 * The element you want to add to the end of the queue
	 */
	public void innKoe(T element);

	/**
	 * @return T element : 
	 * The element taken out/removed from the first position in the queue
	 * @exception EmptyCollectionException when the queue is empty
	 */
	public T utKoe();

	/**
	 * @return T element :
	 * Giving a reference to the first element in the queue, without removing the element
	 * @exception EmptyCollectionException when the queue is empty
	 */
	public T first();

	/**
	 * @return boolean : true if empty and false if not
	 */
	public boolean isEmpty();

	/**
	 * @return integer representing the amount 
	 */
	public int amount();

}