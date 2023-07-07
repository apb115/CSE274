import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Project02JUnitTester {

	@Test
	void testEmptyConstructor() {
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms();
		assertTrue(LL1.size() == 0);
		assertEquals(LL1.head, null);
	}

	
	@Test
	void testArrayConstructor() {
		String[] items = {"hello", "world"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		assertTrue(LL1.size() == 2);
		assertFalse(LL1.head == null);
		//assertEquals("hello", LL1.getAt(0));
	}
	
	@Test
	void testCopyConstructor() {
		String[] items = {"hello", "world"};
		LinkedListAlgorithms LL2 = new LinkedListAlgorithms(items);
		LinkedListAlgorithms LL3 = new LinkedListAlgorithms(LL2);
		assertTrue(LL3.size() == 2);
		assertFalse(LL3.head == null);
		//assertEquals("hello", LL3.getAt(0));
		assertFalse(LL2 == LL3);
	}
	
	@Test
	void testToArray() {
		String[] items = {"hello", "world"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		String[] items2 = LL1.toArray();
		assertTrue(items2.length == 2);
		assertTrue(items2[0] == "hello");
	}
	
	@Test
	void testToString() {
		String[] items = {"hello", "world"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		String result = LL1.toString();
		assertTrue(result.length() > 10);
		assertTrue(result.charAt(1) == 'h');
	}
	
	@Test
	void testSize() {
		String[] items = {"hello", "world"};
		String[] items2 = {};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LinkedListAlgorithms LL2 = new LinkedListAlgorithms(items2);
		assertTrue(LL1.size() == 2);
		assertFalse(LL1.size() == 1);
		assertTrue(LL2.size() == 0);
	}
	
	@Test
	void testEqualsLinkedList() {
		String[] items = {"hello", "world"};
		String[] items2 = {"hello", "my", "world"};
		String[] items3 = {"hello", "world"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LinkedListAlgorithms LL2 = new LinkedListAlgorithms(items2);
		LinkedListAlgorithms LL3 = new LinkedListAlgorithms(items3);
		assertFalse(LL1.equalsLinkedList(LL2));
		assertTrue(LL1.equalsLinkedList(LL3));
	}
	
	@Test
	void testContains() {
		String test1 = "my";
		String test2 = "Boothe";
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		assertTrue(LL1.contains(test1));
		assertFalse(LL1.contains(test2));		
	}
	
	@Test
	void testFind() {
		String[] items = {"hi", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		assertTrue(LL1.find("name") == 2);
		assertTrue(LL1.find("Andrew") == 4);
		assertTrue(LL1.find("Boothe") == -1);
	}
	
	@Test
	void testGetFirst() {
		String[] items = {"hi", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		assertTrue(LL1.getFirst().equals("hi"));
		assertFalse(LL1.getFirst().equals("name"));
	}
	
	@Test
	void testGetLast() {
		String[] items = {"hi", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		assertTrue(LL1.getLast().equals("Andrew"));
		assertFalse(LL1.getLast().equals("name"));
	}
	
	@Test
	void testGetAt() {
		String[] items = {"hi", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		assertTrue(LL1.getAt(4).equals("Andrew"));
		assertTrue(LL1.getAt(2).equals("name"));
		assertTrue(LL1.getAt(0).equals("hi"));
	}
	
	@Test
	void testInsertFirst() {
		String test1 = "First";
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LL1.insertFirst(test1);
		assertTrue(LL1.getAt(0).equals(test1));
		assertFalse(LL1.getAt(0).equals("hello"));
		
	}
	
	@Test
	void testInsertLast() {
		String test1 = "Last";
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LL1.insertLast(test1);
		assertTrue(LL1.getAt(LL1.size()-1).equals(test1));
		assertFalse(LL1.getAt(LL1.size()-1).equals("Andrew"));
	}
	
	@Test
	void testInsertAt() {
		String test1 = "Middle";
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LL1.insertAt(2, test1);
		assertTrue(LL1.getAt(2).equals(test1));
		assertFalse(LL1.getAt(2).equals("Andrew"));
	}
	
	@Test
	void testInsertBefore() {
		String test1 = "Middle";
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LL1.insertBefore(test1, "my");
		assertTrue(LL1.getAt(0).equals(test1));
		assertTrue(LL1.getAt(1).equals("my"));
	}
	
	@Test
	void testInsertAfter() {
		String test1 = "Middle";
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LL1.insertAfter(test1, "my");
		assertTrue(LL1.getAt(2).equals(test1));
		assertTrue(LL1.getAt(1).equals("my"));
	}
	
	@Test
	void testRemoveFirst() {
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		int sizecheck = LL1.size() -1;
		LL1.removeFirst();
		assertTrue(LL1.size() == sizecheck);
		assertTrue(LL1.getAt(0).equals("my"));
		assertTrue(LL1.getAt(3).equals("Andrew"));
	}
	
	@Test
	void testRemoveLast() {
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		int sizecheck = LL1.size() -1;
		LL1.removeLast();
		assertTrue(LL1.size() == sizecheck);
		assertFalse(LL1.getAt(0).equals("is"));
		assertTrue(LL1.getAt(3).equals("is"));
	}
	
	@Test
	void testRemoveAt() {
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		int sizecheck = LL1.size() -1;
		LL1.removeAt(2);
		assertTrue(LL1.size() == sizecheck);
		assertTrue(LL1.getAt(2).equals("is"));
		assertFalse(LL1.getAt(3).equals("is"));
	}
	
	@Test
	void testRemoveFirstOccurrenceOf() {
		String[] items = {"hello", "my", "name", "hello", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		int sizecheck = LL1.size() -1;
		LL1.removeFirstOccurrenceOf("hello");
		assertTrue(LL1.size() == sizecheck);
		assertTrue(LL1.getAt(2).equals("hello"));
		assertTrue(LL1.getAt(0).equals("my"));
	}
	
	@Test
	void testRemoveAllOccurrencesOf() {
		String[] items = {"hello", "my", "name", "hello", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		int sizecheck = LL1.size() -2;
		int test1 = LL1.removeAllOccurrencesOf("hello");
		assertTrue(LL1.size() == sizecheck);
		assertTrue(test1 == 2);
		assertFalse(LL1.contains("hello"));
		assertFalse(LL1.getAt(0).equals("Hello"));
	}
	
	@Test
	void testReverse() {
		String[] items = {"hello", "my", "name", "is", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		int sizechecker = LL1.size();
		LL1.reverse();
		assertTrue(LL1.size() == sizechecker);
		assertTrue(LL1.getFirst().equals("Andrew"));
		assertTrue(LL1.getLast().equals("hello"));
	}
	
	@Test
	void toUpper() {
		String[] items = {"hello", "my", "name", "hello", "Andrew"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LL1.toUpper();
		assertFalse(LL1.getAt(1).equals("my"));
		assertTrue(LL1.getFirst().equals("HELLO"));
		assertTrue(LL1.getAt(2).equals("NAME"));
	}
	
	@Test
	void testGetConcatenation() {
		String[] items = {"hello", "world"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		String test1 = LL1.getConcatenation();
		assertTrue(test1.equals("helloworld"));
	}
	
	@Test
	void testGetAlphabeticallyLast() {
		String[] items = {"hello", "my", "name", "hello", "Andrew"};
		String[] items2 = {"My", "name", "zs", "Doctor", "Zenon"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LinkedListAlgorithms LL2 = new LinkedListAlgorithms(items2);
		String test1 = LL1.getAlphabeticallyLast();
		String test2 = LL2.getAlphabeticallyLast();
		assertTrue(test1.equals("name"));
		assertTrue(test2.equals("zs"));
	}
	
	@Test
	void testIndexOfAlphabeticallyLast() {
		String[] items = {"hello", "my", "name", "hello", "Andrew"};
		String[] items2 = {"My", "name", "ys", "Doctor", "zenon"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LinkedListAlgorithms LL2 = new LinkedListAlgorithms(items2);
		int test1 = LL1.indexOfAlphabeticallyLast();
		int test2 = LL2.indexOfAlphabeticallyLast();
		assertTrue(test1 == 2);
		assertTrue(test2 == 4);
	}
	@Test
	void testAnagrams() {
		String[] items = {"Hello", "mY", "name", "IS", "AnDReW"};
		String[] items2 = {"my", "hello", "Andrew", "is", "name"};
		String[] items3 = {"hello", "my", "name", "Andrew", "Boothe"};
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms(items);
		LinkedListAlgorithms LL2 = new LinkedListAlgorithms(items2);
		LinkedListAlgorithms LL3 = new LinkedListAlgorithms(items3);
		assertTrue(LL1.anagrams(LL2));
		assertFalse(LL1.anagrams(LL3));
		assertFalse(LL2.anagrams(LL3));
	}
}
