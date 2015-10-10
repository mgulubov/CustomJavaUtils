package iterator;

import iterator.exceptions.IteratorOutOfBoundsException;

/**
 * <h1>Iterator</h1>
 * The Iterator interface declares standard methods for iterating through collections.
 * 
 * @author Wolfy
 * @version 1.0
 * @since October 10 2015
 */
public interface Iterator<T> {
	/**
	 * Sets the iterator pointer to the first element of the collection.
	 * The first element is determined through the startIndex variable, 
	 * specified during the initialization of the iterator object.
	 * Either first(), or last() has to be called, when the iterator is initialized.
	 */
	public void first();
	/**
	 * Moves the iterator pointer one position to the right. 
	 * Has no effect if first(), or last() was not called when the iterator was initialized.
	 */
	public void next();
	/**
	 * Moves the iterator pointer one position to the left. 
	 * Has no effect if first(), or last() was not called when the iterator was initialized.
	 */
	public void previous();
	/**
	 * Sets the iterator pointer to the last element of the collection.
	 * The last element is determined through the endIndex variable,
	 * specified during the initialization of the iterator object.
	 * Either first(), or last() has to be called, when the iterator is initialized.
	 */
	public void last();
	/**
	 * Attempts to get the current position value from the collection.
	 * If the current position is invalid, an exception is thrown instead.
	 * 
	 * @return Returns the current position value if the current position is valid.
	 * @throws IteratorOutOfBoundsException {@literal-} An exception is thrown if isDone() returns true
	 * and current() method is called.
	 */
	public T current() throws IteratorOutOfBoundsException;
	/**
	 * Checks whether the current position is within the iterator range.
	 * The range is specified during the initialization of the iterator object and is determined
	 * through the starnIndex and endIndex variables.
	 * @return Returns True if the current position is outside the iterator range.
	 */
	public boolean isDone();
}
