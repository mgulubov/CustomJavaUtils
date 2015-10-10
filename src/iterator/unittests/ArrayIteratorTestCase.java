package iterator.unittests;

import iterator.Iterator;
import iterator.ArrayIterator;

public class ArrayIteratorTestCase extends AbstractIteratorTestCase {

	@Override
	protected Iterator<String> getStringCollection() {
		return new ArrayIterator<String>(new String[0]);
	}

	@Override
	protected Iterator<String> getStringCollection(String[] stringArray) {
		return new ArrayIterator<String>(stringArray);
	}

	@Override
	protected Iterator<String> getStringCollection(String[] stringArray, int startIndex) {
		return new ArrayIterator<String>(stringArray, startIndex);
	}

	@Override
	protected Iterator<String> getStringCollection(String[] stringArray, int startIndex, int length) {
		return new ArrayIterator<String>(stringArray, startIndex, length);
	}

	@Override
	protected Iterator<Integer> getIntegerCollection() {
		return new ArrayIterator<Integer>(new Integer[0]);
	}

	@Override
	protected Iterator<Integer> getIntegerCollection(Integer[] intArray) {
		return new ArrayIterator<Integer>(intArray);
	}

	@Override
	protected Iterator<Integer> getIntegerCollection(Integer[] intArray, int startIndex) {
		return new ArrayIterator<Integer>(intArray, startIndex);
	}

	@Override
	protected Iterator<Integer> getIntegerCollection(Integer[] intArray, int startIndex, int length) {
		return new ArrayIterator<Integer>(intArray, startIndex, length);
	}

}
