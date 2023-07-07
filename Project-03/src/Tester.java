
public class Tester {

	public static void main(String[] args) {
		String[] data = {"a", "b", "c", "d", "e", "a", "b", "b", "d"};
		String[] result = {"a", "b", "c"};
		BagInterface<String> b1;
		b1 = new ArrayBag();
		
		for (String s : data) {
			b1.add(s);
		}
		String[] data2 = b1.toArray();
		for (int i = 0; i < data2.length; i++) {
			System.out.println(data2[i]);
		}
		
		b1.removeDuplicates();
		String[] data3 = b1.toArray();
		for (int i = 0; i < data3.length; i++) {
			System.out.println(data3[i]);
		}
	}

}
