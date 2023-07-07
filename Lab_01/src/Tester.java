import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		
		// Initialize basic array
		WordList w1 = new WordList();
		w1.add("A");
		w1.add("B");
		w1.add("C");
		w1.add("D");
		w1.add("E");
		w1.add("F");
		w1.add("G");
		w1.add("H");
		w1.add("J");
		
		// Print items of array
		System.out.println(w1);
		
		// Size()
		System.out.println(w1.size());
		
		// Add(index)
		// String test1 = "Z";
		// w1.add(test1);
		// System.out.println(w1);
		
		// Add(String, index)
		String test2 = "X";
		w1.add(4, test2);
		System.out.println(w1);
		System.out.println(w1.size());
		
		// Remove(index)
		// w1.remove(2);
		// System.out.println(w1);
		
		// Clear()
		// w1.clear();
		// System.out.println(w1);
		
		// Contains()
		// System.out.println(w1.contains("A"));
		
		
		// Remove(String)
		// w1.remove("B");
		// System.out.println(w1);
		
		// Get()
		// System.out.println(w1.get(0));
		
		// Set()
		// w1.set(3, "J");
		// System.out.println(w1);		
		
		// toString()
		// System.out.println(w1.toString());
	
		
		
		
	}
	


}
