import java.util.PriorityQueue;
import java.util.Queue;

public class Tester {

	public static void main(String[] args) {
		SortedLinkedPriorityQueue<Student> test = new SortedLinkedPriorityQueue<>();
		test.add(new Student("Bob", 1, true));
		test.add(new Student("Blob", 1, true));
		test.add(new Student("Cam", 1, true));
		test.add(new Student("Dam", 1, true));
		test.add(new Student("Sam", 10, true));
		test.add(new Student("Sam", 10, true));
		test.add(new Student("Am", 1, true));
		test.add(new Student("Aa", 1, true));
		
		while (!test.isEmpty()) {
			System.out.println(test.remove());
		}

	}

}
