package iterator.unittests;

import junit.framework.TestCase;
import iterator.Iterator;
import iterator.exceptions.IteratorOutOfBoundsException;

import org.junit.Test;

public abstract class AbstractIteratorTestCase extends TestCase {
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	private static final Integer VALUE_ONE = 1;
	private static final Integer VALUE_TWO = 2;
	private static final Integer VALUE_THREE = 3;
	private static final Integer VALUE_FOUR = 4;
	private String[] stringCollection;
	private Integer[] intCollection;
	private Iterator<String> testingStringCollection;
	private Iterator<Integer> testingIntegerCollection;
	
	protected abstract Iterator<String> getStringCollection();
	protected abstract Iterator<String> getStringCollection(String[] stringArray);
	protected abstract Iterator<String> getStringCollection(String[] stringArray, int startIndex);
	protected abstract Iterator<String> getStringCollection(String[] stringArray,
															int startIndex,
															int length);
	protected abstract Iterator<Integer> getIntegerCollection();
	protected abstract Iterator<Integer> getIntegerCollection(Integer[] intArray);
	protected abstract Iterator<Integer> getIntegerCollection(Integer[] intArray, int startIndex);
	protected abstract Iterator<Integer> getIntegerCollection(Integer[] intArray,
															int startIndex,
															int length);
	
	protected void setUp() throws Exception {
		this.stringCollection = new String[] {
				VALUE_A, VALUE_B, VALUE_C, VALUE_D
		};
		
		this.intCollection = new Integer[] {
				VALUE_ONE, VALUE_TWO, VALUE_THREE, VALUE_FOUR
		};
	}
	
	protected void tearDown() throws Exception {
		this.stringCollection = null;
		this.intCollection = null;
	}

	@Test
	public void testStringIteratorEmptyCollectionStartIndex() {
		try {
			this.testingStringCollection = this.getStringCollection(new String[0], 1);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//Expected
		}
		
		try {
			this.testingStringCollection = this.getStringCollection(new String[0], -1);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//Expected
		}
		
		try {
			this.testingStringCollection = this.getStringCollection(new String[0], 0);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testStringIteratorEmptyCollectionStartIndexLength() {
		try {
			this.testingStringCollection = this.getStringCollection(new String[0], 1, 0);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//Expected
		}
		
		try {
			this.testingStringCollection = this.getStringCollection(new String[0], -1, 1);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//Expected
		}
		
		try {
			this.testingStringCollection = this.getStringCollection(new String[0], 0, -1);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testStringIteratorNonEmptyCollection() {
		this.testingStringCollection = this.getStringCollection(this.stringCollection);
		
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingStringCollection.first();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_A, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_B, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_C, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_D, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingStringCollection.last();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_D, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_C, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_B, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_A, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testStringIteratorNonEmptyCollectionStartIndex() {
		this.testingStringCollection = this.getStringCollection(this.stringCollection, 1);
		
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingStringCollection.first();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_B, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_C, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_D, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingStringCollection.last();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_D, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_C, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_B, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testStringIteratorNonEmptyCollectionStartIndexLength() {
		this.testingStringCollection = this.getStringCollection(this.stringCollection, 1, 2);
		
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingStringCollection.first();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_B, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_C, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingStringCollection.last();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_C, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_B, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testStringIteratorNonEmptyCollectionAroundTheWorld() {
		this.testingStringCollection = this.getStringCollection(this.stringCollection);
		
		this.testingStringCollection.first();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_A, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_B, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_C, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_D, this.testingStringCollection.current());
		
		this.testingStringCollection.next();
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_D, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_C, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_B, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertFalse(this.testingStringCollection.isDone());
		assertEquals(VALUE_A, this.testingStringCollection.current());
		
		this.testingStringCollection.previous();
		assertTrue(this.testingStringCollection.isDone());
		try {
			this.testingStringCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	public void testStringIteratorNonEmptyCollectionNextPreviousHaveNoEffectWithoutFirstLast() {
		this.testingStringCollection = this.getStringCollection(this.stringCollection, 0, 1);
		
		assertTrue(this.testingStringCollection.isDone());
		
		this.testingStringCollection.next();
		assertTrue(this.testingStringCollection.isDone());
		
		this.testingStringCollection.next();
		assertTrue(this.testingStringCollection.isDone());
		
		this.testingStringCollection.previous();
		assertTrue(this.testingStringCollection.isDone());
		
		this.testingStringCollection.previous();
		assertTrue(this.testingStringCollection.isDone());
		
		this.testingStringCollection.previous();
		assertTrue(this.testingStringCollection.isDone());
		
		this.testingStringCollection.previous();
		assertTrue(this.testingStringCollection.isDone());
	}
	
	@Test
	public void testIntegerIteratorEmptyCollectionStartIndex() {
		try {
			this.testingIntegerCollection = this.getIntegerCollection(new Integer[0], 1);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//Expected
		}
		
		try {
			this.testingIntegerCollection = this.getIntegerCollection(new Integer[0], -1);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//Expected
		}
		
		try {
			this.testingIntegerCollection = this.getIntegerCollection(new Integer[0], 0);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testIntegerIteratorEmptyCollectionStartIndexLength() {
		try {
			this.testingIntegerCollection = this.getIntegerCollection(new Integer[0], 1, 0);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//Expected
		}
		
		try {
			this.testingIntegerCollection = this.getIntegerCollection(new Integer[0], -1, 1);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//Expected
		}
		
		try {
			this.testingIntegerCollection = this.getIntegerCollection(new Integer[0], 0, -1);
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testIntegerIteratorNonEmptyCollection() {
		this.testingIntegerCollection = this.getIntegerCollection(this.intCollection);
		
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingIntegerCollection.first();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_ONE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_TWO, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_THREE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_FOUR, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingIntegerCollection.last();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_FOUR, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_THREE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_TWO, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_ONE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testIntegerIteratorNonEmptyCollectionStartIndex() {
		this.testingIntegerCollection = this.getIntegerCollection(this.intCollection, 1);
		
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingIntegerCollection.first();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_TWO, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_THREE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_FOUR, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingIntegerCollection.last();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_FOUR, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_THREE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_TWO, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testIntegerIteratorNonEmptyCollectionStartIndexLength() {
		this.testingIntegerCollection = this.getIntegerCollection(this.intCollection, 1, 2);
		
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingIntegerCollection.first();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_TWO, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_THREE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingIntegerCollection.last();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_THREE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_TWO, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
	
	@Test
	public void testIntegerIteratorNonEmptyCollectionAroundTheWorld() {
		this.testingIntegerCollection = this.getIntegerCollection(this.intCollection);
		
		this.testingIntegerCollection.first();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_ONE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_TWO, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_THREE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_FOUR, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.next();
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_FOUR, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_THREE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_TWO, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertFalse(this.testingIntegerCollection.isDone());
		assertEquals(VALUE_ONE, this.testingIntegerCollection.current());
		
		this.testingIntegerCollection.previous();
		assertTrue(this.testingIntegerCollection.isDone());
		try {
			this.testingIntegerCollection.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			//expected
		}
	}
}
