package iterator.exceptions;

/**
 * <h1>IteratorOutOfBoundsException</h1>
 * Exception thrown by Iterator objects.
 * Extends native IndexOutOfBoundsException.
 * 
 * @author Wolfy
 * @version 1.0
 * @since October 10 2015
 */
public class IteratorOutOfBoundsException extends IndexOutOfBoundsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8247092867926947298L;
	
	/**
	 * Constructor that accepts a message. The message is then forwarded
	 * to the same constructor of the native IndexOutOfBoundsException class.
	 * @param message The message to be included in the exception
	 */
	public IteratorOutOfBoundsException(String message) {
		super(message);
	}
}
