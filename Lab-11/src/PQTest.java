import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.Test;



	class PQTest {

		@Test
		void testIsEmpty() {
			HeapPriorityQueue<Integer> hpq = new HeapPriorityQueue<>();
			assertTrue(hpq.isEmpty());
			hpq.add(1);
			hpq.remove();
			assertTrue(hpq.isEmpty());
		}

		@Test
		void testIsFull() {
			HeapPriorityQueue<Integer> hpq = new HeapPriorityQueue<>();
			hpq.add(1);
			assertFalse(hpq.isFull());
		}

		@Test
		void testClear() {
			HeapPriorityQueue<Integer> hpq = new HeapPriorityQueue<>();
			hpq.add(1);
			hpq.clear();
			assertTrue(hpq.isEmpty());
		}

		@Test
		void testSize() {
			HeapPriorityQueue<Integer> hpq = new HeapPriorityQueue<>();
			hpq.add(1);
			assertEquals(hpq.size(), 1);
			hpq.remove();
			assertEquals(hpq.size(), 0);
		}

		@Test
		void testAdd1() {
			PriorityQueueInterface<String> students = new HeapPriorityQueue<>();
			students.add("Tom");
			students.add("Bob");
			students.add("Sally");
			students.add("Bob");
			students.add("Jack");
			students.add("Zack");
			students.add("Adam");
			assertEquals(students.size(), 7);
			while (!students.isEmpty()) {
				students.remove();
			}
			assertEquals(students.size(), 0);
		}

		@Test
		void testingAdd2() {
			Random rn = new Random();
			int a = 0;
			int b = 99;
			for (int n = 1; n <= 200; n++) {
				HeapPriorityQueue<Integer> hpq = new HeapPriorityQueue<>();
				int bound = rn.nextInt(b - a + 1) + a;

				for (int i = 0; i < bound; i++)
					hpq.add(i);

				while (!hpq.isEmpty())
					hpq.remove();
				assertEquals(hpq.size(), 0);
			}
		}

		@Test
		void testRemove() {

			Random rn = new Random();

			int a = 1;
			int b = 99;

			for (int n = 1; n <= 200; n++) {
				//System.out.println("Starting new empty heap =====================");
				HeapPriorityQueue<Integer> hpq = new HeapPriorityQueue<>();
				int bound = rn.nextInt(b - a + 1) + a;

				for (int i = 0; i < bound; i++)
					hpq.add(rn.nextInt(b - a + 1) + a);
				assertEquals(hpq.size(), bound);

				Integer lastRemoved = hpq.remove();
				//System.out.println(lastRemoved);
				int current;
				while (!hpq.isEmpty()) {
					current = hpq.remove();
					//System.out.println(current);
					assertTrue(lastRemoved.compareTo(current) >= 0);
					lastRemoved = current;
				}
			}
		}
		
		
		@Test
		void testPeek() {
			HeapPriorityQueue<Integer> hpq = new HeapPriorityQueue<>();
			assertEquals(hpq.peek(), null);
			hpq.add(1);
			assertEquals(hpq.peek(), 1);
			hpq.remove();
			assertEquals(hpq.peek(), null);
			hpq.add(1);
			hpq.add(2);
			assertEquals(hpq.peek(), 2);
		}
		
		@Test
		void testToString() {
			HeapPriorityQueue<String> hpq = new HeapPriorityQueue<>();
			
			hpq.add("Adam");
			hpq.add("Zack");
			assertTrue(hpq.toString().substring(0, 5).contains("null"));
			
		}
		
		
		@Test
		void testRemoveThrowsException() {
			HeapPriorityQueue<String> hpq = new HeapPriorityQueue<>();
			

		    Throwable exception = assertThrows(NoSuchElementException.class, () -> hpq.remove());
		    assertEquals(null, exception.getMessage());
			
		}
		

		
		
		@Test
		void testConstructors() {
			String[] arr = new String[] { "A", "B", "C", "D", "E" };
			HeapPriorityQueue<String> hpq = new HeapPriorityQueue<>(arr);	
			assertEquals(hpq.size(), arr.length);
		}

}
