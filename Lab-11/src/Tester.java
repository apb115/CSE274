
public class Tester {

	public static void main(String[] args) {
		
		HeapPriorityQueue<String> hp = new HeapPriorityQueue<String>();
		
		// ADD
		hp.add("I");
		hp.add("Go");
		hp.add("To");
		hp.add("Miami");
		hp.add("University");
		System.out.println(hp);
		System.out.println(hp.size()); // 5
		
		// REMOVE
		hp.remove();
		hp.remove();
		System.out.println(hp);
		System.out.println(hp.size()); // 4
		
		// CLEAR
		hp.clear();
		System.out.println(hp);
		System.out.println(hp.size()); // 0
		
		// ISEMPTY
		System.out.println(hp.isEmpty()); // True
		
		// PEEK
		System.out.println(hp.peek()); // null
		hp.add("Andrew");
		hp.add("Boothe");
		System.out.println(hp.peek()); // Boothe
		
		
		
	}

}
