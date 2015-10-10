package iterator;

import iterator.exceptions.IteratorOutOfBoundsException;
/**
 * <h1>Iterable</h1>
 * The Iterable interface provides a standard way of obtaining an iterator 
 * from a collection that supports it.
 * 
 * @author Wolfy
 * @version 1.0
 * @since October 05 2015
 */
public interface Iterable<T> {
	/**
	 * Creates an iterator for all elements of the current collection. 
	 * This method is overloaded.
	 * 
	 * @return Returns a new Iterator for the current collection
	 * @throws IteratorOutOfBoundsException {@literal-} An exception is thrown if
	 * the collection has no elements, or is null.
	 */
	public Iterator<T> iterator() throws IteratorOutOfBoundsException;
	/**
	 * Creates an iterator for the elements of the current collection, 
	 * within the range: startIndex {@literal-} collection.length{@literal-}1. 
	 * The range is inclusive on both ends.
	 * This method is overloaded.
	 * 
	 * @param startIndex {@literal-} The startIndex. Its value should be {@literal >}= 0 
	 * and {@literal <} collection.length
	 * @return Returns a new Iterator for the current collection, within the given range.
	 * @throws IteratorOutOfBoundsException {@literal-} An Exception is thrown if 
	 * the startIndex parameter is not within the ranges described above.
	 */
	public Iterator<T> iterator(int startIndex) throws IteratorOutOfBoundsException;
	/**
	 * Creates an iterator for the elements of the current collection,
	 * within the range: startIndex {@literal-} (startIndex+length){@literal-}1.
	 * The range is inclusive on both ends.
	 * 
	 * @param startIndex {@literal-} The startIndex. 
	 * Its value should be {@literal >}= 0 and {@literal <} collection.length
	 * @param length {@literal-} The length. 
	 * The value of startIndex+length should be {@literal >} 0 and {@literal <}= collections.length
	 * @return Returns a new Iterator for the current collection, within the given range.
	 * @throws IteratorOutOfBoundsException {@literal-} An exception is thrown if 
	 * any of the parameter values is not within the ranges described above.
	 */
	public Iterator<T> iterator(int startIndex, int length) throws IteratorOutOfBoundsException;
}
