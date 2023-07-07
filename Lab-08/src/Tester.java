
public class Tester {
	
	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();
		System.out.println("true? " + set.isEmpty());
		System.out.println("true? " + set.add("fox"));
		System.out.println("true? " + set.add("ant"));
		System.out.println("true? " + set.add("man"));
		System.out.println("true? " + set.add("cat"));
		System.out.println("true? " + set.add("dog"));
		System.out.println("false? " + set.add("dog"));
		System.out.println("remove true? " + set.remove("man"));
		System.out.println("2? " + set.size());
		System.out.println("false? " + set.isEmpty());
		System.out.println("true? " + set.contains("dog"));
		System.out.println(set.toString());
		for(char c : "ABCDEFGHIJKLMNOPQUSTUVWXYZ".toCharArray())
			set.add("" + c);
		
		System.out.println(set.toString());
	}
	
}
