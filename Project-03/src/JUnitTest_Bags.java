import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * You can use this JUnit tester as a starting point for testing your implementations.
 * This JUnit tester is NOT complete.  It contains very basic tests.  You should
 * modify it to fit your needs.  Don't forget to test:
 * - Edge cases
 * - Proper resizing of the array (both growing and shrinking)
 * 
 * You can write more tests if you want.  Just follow the structure below, and 
 * put @Test before each test.
 */


public class JUnitTest_Bags {

	BagInterface<String> b1, b2, b3, b4, b5, b6;
	
	// This code here will be run before each test.  You can use these
	// bags in all your testers.
	// You can change the code below to say LinkedBag() instead of ArrayBag().
	@Before
    public void setUpArrayBags() {
        b1 = new ArrayBag(); 
        b2 = new ArrayBag(5); // this constructor only makes sense in ArrayBag
        b5 = new ArrayBag(12);
        b6 = new ArrayBag(13);
	}
	
	@Before
	public void setUpLinkedBags() {
		b3 = new LinkedBag();
		b4 = new LinkedBag();
	}
	
	// This next test only makes sense for ArrayBag. It tests to make sure
	// your code is throwing the proper exception.  You can comment out this
	// one test when testing LinkedBag.
	@Test(expected = IllegalArgumentException.class)
	public void intConstructorThrowsProperException() {
		b2 = new ArrayBag(-14);
	}
	
	// All of the tests below should work correctly for ArrayBag and for LinkedBag
	
	@Test
	public void testSize() {
		assertEquals(0, b1.size());
		b1.add("a");
		assertEquals(1, b1.size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(b1.isEmpty());
	}

	@Test
	public void testAdd() {
		b1.add("a");
		assertTrue(b1.contains("a"));
		assertFalse(b1.contains("b"));
		assertFalse(b1.isEmpty());
		assertEquals(1, b1.size());
	}

	@Test
	public void testRemove() {
		b1.add("a");
		assertTrue(b1.contains("a"));
		b1.remove();
		assertFalse(b1.contains("a"));
		assertEquals(0, b1.size());
	}

	@Test
	public void testRemoveString() {
		b1.add("a");
		assertTrue(b1.contains("a"));
		b1.remove("a");
		assertFalse(b1.contains("a"));
		assertEquals(0, b1.size());
	}

	@Test
	public void testClear() {
		b1.add("a");
		b1.add("b");
		b1.clear();
		assertEquals(0, b1.size());
	}

	// Note: using new String("a") instead of just "a" is helpful because
	// it will help you make sure you used equals() rather than == in your method.
	@Test
	public void testGetFrequencyOf() {
		b1.add("a");
		b1.add("a");
		assertEquals(2, b1.getFrequencyOf(new String("a")));
	}

	@Test
	public void testContains() {
		assertFalse(b1.contains("a"));
	}

	@Test
	public void testToArray() {
		b1.add("a");
		String[] ar = b1.toArray();
		assertEquals(1, ar.length);
		assertEquals("a", ar[0]);
	}

	@Test
	public void testRemoveDuplicates() {
		
		String[] data = {"a", "b", "b", "a", "c"};
		String[] result = {"a", "b", "c"};
		String[] result2 = {"a", "b"};
		String[] result3 = {"a"};
		String[] result4 = {"b"};
		
		for (String s : data) {
			b1.add(s);
		}
		b1.removeDuplicates();
		
		assertEquals(result.length, b1.size());
		for (String s : result) {
			assertTrue(b1.contains(s));
		}
	}

	@Test
	public void testContainsAll() {
		String[] s1 = {"A", "B", "C"};
		String[] s2 = {"A", "A", "B", "A"};
		
		for (String s : s1) b1.add(s);
		for (String s : s2) b2.add(s);
		
		assertTrue(b1.containsAll(b2));
	}

	@Test
	public void testSameItems() {
		
		String[] s1 = {"B", "A", "B", "C"};
		String[] s2 = {"C", "A", "B", "B"};
		
		for (String s : s1) b1.add(s);
		for (String s : s2) b2.add(s);
		
		assertTrue(b1.sameItems(b2));
	}
	
	//LINKED LIST TESTER
	
	
	@Test
	public void testToArrayLinked() {
		b4.add("Hi");
		b4.add("My");
		b4.add("Name");
		b4.add("is");
		String[] s2 = b4.toArray();
		assertTrue(b4.size() == 4);
		assertTrue(b4.contains("Name"));
		assertEquals(s2.length, b4.size());
		b4.clear();
		b3.add("Hello");
		b4.add("My");
		String[] s3 = b3.toArray();
		String[] s4 = b4.toArray();
		assertFalse(s3.equals(s4));
		assertEquals(1, b3.size());
		assertEquals(1, b4.getFrequencyOf("My"));
	}
	
	@Test
	public void testAddLinked() {
		b3.add("Name");
		assertTrue(b3.contains("Name"));
		assertFalse(b3.contains("b"));
		assertFalse(b3.isEmpty());
		assertEquals(1, b3.size());
	}
	
	@Test
	public void testRemoveDuplicatesLinked() {
		String[] data = {"a", "b", "b", "a", "c"};
		String[] result = {"a", "b", "c"};
		
		for (String s : data) {
			b3.add(s);
		}
		
		b3.removeDuplicates();
		assertEquals(result.length, b3.size());
		for (String s : result) {
			assertTrue(b3.contains(s));
		}
	}
	
	@Test
	public void testClearLinked() {
		b3.add("a");
		b3.add("b");
		b3.clear();
		assertEquals(0, b3.size());
	}
	
	@Test
	public void testSizeLinked() {
		assertEquals(0, b3.size());
		b3.add("a");
		assertEquals(1, b3.size());
	}
	
	@Test
	public void testGetFrequencyOfLinked() {
		b3.add("a");
		b3.add("a");
		b3.add("b");
		b3.add("a");
		b3.add("c");
		b3.add("a");
		b3.add("a");
		b3.add("c");
		assertEquals(5, b3.getFrequencyOf("a"));
		assertEquals(1, b3.getFrequencyOf("b"));
		assertEquals(2, b3.getFrequencyOf("c"));
	}
	
	@Test
	public void testContainsAllLinked() {
		String[] s1 = {"A", "B", "C"};
		String[] s2 = {"A", "A", "B", "A"};
		
		for (String s : s1) b3.add(s);
		for (String s : s2) b4.add(s);
		
		assertTrue(b3.containsAll(b4));
	}
	
	@Test
	public void testContainsLinked() {
		assertFalse(b3.contains("a"));
		b3.add("a");
		assertTrue(b3.contains("a"));
	}
	
	@Test
	public void testRemoveStringLinked() {
		b3.add("a");
		assertTrue(b3.contains("a"));
		b3.remove("a");
		assertFalse(b3.contains("a"));
		assertEquals(0, b3.size());
	}
	
	@Test
	public void testSameItemsLinked() {
		String[] s1 = {"B", "A", "B", "C"};
		String[] s2 = {"C", "A", "B", "B"};
		b3.clear();
		b4.clear();
		for (String s : s1) b3.add(s);
		for (String s : s2) b4.add(s);
		
		assertTrue(b3.sameItems(b4));
	}
	
	@Test
	public void testIsEmptyLinked() {
		assertTrue(b3.isEmpty());
	}
	
	@Test
	public void testRemoveLinked() {
		b3.add("a");
		assertTrue(b3.contains("a"));
		b3.remove();
		assertFalse(b3.contains("a"));
		assertEquals(0, b3.size());
	}
}
