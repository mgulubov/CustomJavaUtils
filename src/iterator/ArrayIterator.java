package iterator;

import iterator.exceptions.IteratorOutOfBoundsException;

/**
 * <h1>ArrayIterator</h1>
 * An Iterator implementation for Array objects.
 * 
 * @author Wolfy
 * @version 1.0
 * @since October 05 2015
 */
public class ArrayIterator<T> implements Iterator<T> {
	private final T[] array;
	private final int startIndex;
	private final int endIndex;
	private int currentIndex;
	
	/**
	 * The standard constructor takes an array as a parameter.
	 * If not specified through one of the other two constructors,
	 * the range will always be set to 0 {@literal -} (array.lenght{@literal -}1).
	 * 
	 * @param array The array that will be iterated.
	 * @throws IteratorOutOfBoundsException An exception is thrown 
	 * if the array is null or has no elements.
	 */
	public ArrayIterator(T[] array) throws IteratorOutOfBoundsException {
		this(array, 0, array.length);
	}
	
	/**
	 * The start position of the iterator can be specified with the startIndex parameter.
	 * 
	 * @param array The array that will be iterated.
	 * @param startIndex The starting position of the iterator.
	 * @throws IteratorOutOfBoundsException An exception is thrown
	 * if the array is null or has no elements, or if the startIndex is
	 * {@literal < 0}, {@literal >}= array.length, or {@literal >} endIndex.
	 */
	public ArrayIterator(T[] array, int startIndex) throws IteratorOutOfBoundsException {
		this(array, startIndex, array.length - startIndex);
	}
	
	/**
	 * The start and end positions of the iterator can be specified
	 * with the startIndex and length parameters.
	 * 
	 * @param array The array that will be iterated.
	 * @param startIndex The starting position of the iterator.
	 * @param length The total number of elements that will be iterated.
	 * @throws IteratorOutOfBoundsException An exception is thrown if
	 * the array is null or empty, or startIndex
	 * {@literal <} 0, startIndex {@literal >}= array.length, or 
	 * startIndex {@literal >} endIndex, or
	 * endIndex {@literal <} 0, endIndex {@literal >}= array.length, or
	 * endIndex {@literal <} startIndex.
	 */
	public ArrayIterator(T[] array, int startIndex, int length) 
			throws IteratorOutOfBoundsException {	
		this.array = array;
		this.startIndex = startIndex;
		this.endIndex = startIndex + (length - 1);
		this.currentIndex = -2;
		
		this.validateParameters();
	}
	
	@Override
	public void first() {
		this.currentIndex = this.startIndex;
	}

	@Override
	public void next() {
		if (this.hasStarted()) {
			this.currentIndex++;
		}
	}

	@Override
	public void previous() {
		if (this.hasStarted()) {
			this.currentIndex--;
		}		
	}

	@Override
	public void last() {
		this.currentIndex = this.endIndex;
	}

	@Override
	public T current() throws IteratorOutOfBoundsException {
		if (this.isDone()) {
			throw new IteratorOutOfBoundsException(
					String.format("currentIndex is out of bounds: %d", this.currentIndex));
		}
		
		return this.array[this.currentIndex];
	}

	@Override
	public boolean isDone() {
		return this.currentIndex < this.startIndex || this.currentIndex > this.endIndex;
	}
	
	private void validateParameters() {
		this.validateArray();
		this.validateStartIndex();
		this.validateEndIndex();
	}
	
	private void validateArray() {
		if (this.array == null) {
			throw new IteratorOutOfBoundsException("Array can't be null");
		}
	}
	
	private void validateStartIndex() {
		if (this.startIndex < 0) {
			throw new IteratorOutOfBoundsException("startIndex can't be < 0");
		}
		
		if (this.startIndex >= this.array.length) {
			throw new IteratorOutOfBoundsException("startIndex can't be >= array.length");
		}
		
		if (this.startIndex > this.endIndex) {
			throw new IteratorOutOfBoundsException("startIndex can't be > endIndex");
		}
	}
	
	private void validateEndIndex() {
		if (this.endIndex < 0) {
			throw new IteratorOutOfBoundsException("endIndex can't be < 0");
		}
		
		if (this.endIndex >= this.array.length) {
			throw new IteratorOutOfBoundsException("endIndex can't be >= array.length");
		}
		
		if (this.endIndex < this.startIndex) {
			throw new IteratorOutOfBoundsException("endIndex can't be < startIndex");
		}
	}

	private boolean hasStarted() {
		return this.currentIndex != -2;
	}
}
