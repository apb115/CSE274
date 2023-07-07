
public class Tester {
	public static void main(String[] args) {
		BST<String> bst = new BST<String>("MSPTVZUGBJ");
		
		// bst.orderType = BSTInterface.Traversal.IN_ORDER;
		for(String s: bst) 
			System.out.print(s + " ");
		
		System.out.println("");
		bst.orderType = BSTInterface.Traversal.BREADTH_FIRST;
		for(String s: bst) 
			System.out.print(s + " ");
	}
	
	
}
