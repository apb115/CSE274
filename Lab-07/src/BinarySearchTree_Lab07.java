import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 	Lab-07: BinarySearchTree Implementation
 	
 	Rules:
 		1. Allow Tester to iterate through all nodes using the in-order traversal as the default.
 			This means, in Tester the following code should work for an instance of this class
 			called bst that is storing Student objects for the data:
 				
 				BinarySearchTree_Lab07<String> bst = new BinarySearchTree_Lab07<String>();
 				bst.add("Man");		bst.add("Soda");	bst.add("Flag");
 				bst.add("Home");	bst.add("Today");	bst.add("Jack");
 			
 				for(String s : bst) 
 					System.out.println(s);
*/

/*
 Names: Andrew Boothe, Vimal Vimod
 Project: Lab-07
 Date: 4/3/2022
 */


public class BinarySearchTree_Lab07<T> implements Iterable<T> {
//====================================================================================== Properties
	private Node root;
	private int nodeCount; 
	//====================================================================================== Constructors
	public BinarySearchTree_Lab07() {
		root = null;
		nodeCount = 0;
	}
	
	// Constructor that takes an array of items and populates the tree
	public BinarySearchTree_Lab07(T[] items) {
		this();
		for (T o : items) add(o);
	}
	
	//====================================================================================== Methods
	public void add(T data) {	// Implement recursively and do NOT allow duplicates
		root = recAdd(root, data);
	}
	
	private Node recAdd(Node n, T data) {
		if (n == null) {
			nodeCount++;
			return new Node(data);
		}
		int d = ((Comparable) data).compareTo(n.data);
		if (d < 0) {
			n.left = recAdd(n.left, data);
		} if (d > 0) {
			n.right = recAdd(n.right, data);
		}
		return n;
	}
	
	private void levelOrder(Node node, LinkedList<T> ret) {
		if(node == null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()) {
			Node tmp = q.remove();
			ret.add(tmp.data);
			if(tmp.left != null) q.add(tmp.left);
			if(tmp.right != null)  q.add(tmp.right);
		}
	}


	private void preOrder(Node node, LinkedList<T> ret) {
		if(node == null) return;
		ret.add(node.data);
		if(node.left != null) preOrder(node.left, ret);
		if(node.right != null) preOrder(node.right, ret);
	}
	private void inOrder(Node node, LinkedList<T> ret) {
		if(node == null) return;
		if(node.left != null) inOrder(node.left, ret);
		ret.add(node.data);
		if(node.right != null) inOrder(node.right, ret);
	}

	private void postOrder(Node node, LinkedList<T> ret) {
		if(node == null) return;
		if(node.left != null) postOrder(node.left, ret);
		if(node.right != null) postOrder(node.right, ret);
		ret.add(node.data);
	}
	
	// Returns the traversal of this tree as an array
	public String[] preOrder_Traversal() {
		LinkedList<T> ll = new LinkedList<T>();
		preOrder(root, ll);	
		// right here ll is not empty, filled by preOrder
		String[] ret = new String[ll.size()];
		int i = 0;
		while(!ll.isEmpty()) ret[i++] = ll.remove().toString();
		return ret;
	}
	
	public String[] inOrder_Traversal() {
		LinkedList<T> ll = new LinkedList<T>();
		inOrder(root, ll);
		String[] ret = new String[ll.size()];
		int i = 0;
		while (!ll.isEmpty()) {
			ret[i++] = ll.remove().toString();
		}
		return ret;
	}
	
	public String[] postOrder_Traversal() {
		LinkedList<T> ll = new LinkedList<T>();
		postOrder(root, ll);
		String[] ret = new String[ll.size()];
		int i = 0;
		while (!ll.isEmpty()) {
			ret[i++] = ll.remove().toString();
		}
		return ret;
	}
	public String[] breadthFirst_Traversal() {
		LinkedList<T> ll = new LinkedList<T>();
		levelOrder(root, ll);
		String[] ret = new String[ll.size()];
		int i = 0;
		return breadthFirst_Traversal(ret, ll, i);
	}
	
	private String[] breadthFirst_Traversal(String[] ret, LinkedList<T> ll, int i) {
		ret[i++] = ll.remove().toString();
		return ll.isEmpty() ? ret : breadthFirst_Traversal(ret, ll, i);
	}

	// Since this is a binary SEARCH tree, you should write
	// an efficient solution to this that takes advantage of the order
	// of the nodes in a BST.  Your algorithm should be, on average,
	// O(h) where h is the height of the BST.
	public boolean contains(T data) {
		if (isEmpty()) return false;
		return recContains(data, root);
	}
	
	private boolean recContains(T data, Node n) {
		if (n == null) return false;
		int d = ((Comparable)	data).compareTo(n.data);
		if (d < 0) {
			return recContains(data, n.left);
		} else if (d > 0) {
			return recContains(data, n.right);
		} else if (d == 0) {
			return true;
		}
		return false;
	}
	
	// returns the smallest value in the tree
	// or throws an IllegalStateException() if the
	// tree is empty.  Write the recursive version 
	public T min() { return min(root); }		// this method is done for you.
			
	private T min(Node n) {	// Write this method.
		if (isEmpty()) return null;
		while (n.left != null) {
			n = n.left;
		}
		return n.data;
	}
	
	// returns the largest value in the tree
	// or throws an IllegalStateException() if the
	// tree is empty.  Write the recursive version
	public T max() { return max(root); }		// this method is done for you.

	private T max(Node n) {	// Write this method.
		if (isEmpty()) return null;
		while (n.right != null) {
			n = n.right;
		}
		return n.data;
	}
	
	// Returns whether the tree is empty
	public boolean isEmpty() {
		if (root == null) return true;
		return false;
	}
	
	// returns the height of this BST. If a BST is empty, then
	// consider its height to be -1.
	public int getHeight() {
		if (isEmpty()) return 0;
		return getHeight(root);
	}
	
	private int getHeight(Node n) {
		int leftHeight = -1, rightHeight = -1;
		if (n.left != null) leftHeight = getHeight(n.left);
	    if (n.right != null) rightHeight = getHeight(n.right);
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	// returns the number of leaf nodes
	public int leafCount() {
		return leafCount(root);
	}
	private int leafCount(Node n) {
		if (n == null) { return 0;
		} else if (n.left != null || n.right != null) {
		return leafCount(n.left) + leafCount(n.right);
		}	else {
		return 1;
		}
	}
		
	
	// returns the "level" of the value in a tree.
	// the root is considered level 0
	// the children of the root are level 1
	// the children of the children of the root are level 2
	// and so on.  If a value does not appear in the tree, return -1
	//              15
	//             /  \
	//            10  28
	//              \   \
	//              12  40
	//                 /
	//                30
	// In the tree above:
	// getLevel(15) would return 0
	// getLevel(10) would return 1
	// getLevel(30) would return 3
	// getLevel(8) would return -1
	public int getLevel(T n) {
		if (!contains(n)) return -1;
		return getLevel(n, root);
	}
	
	private int getLevel(T n, Node node) {
		if (n.equals(node.data)) return 0;
		int d = ((Comparable) n).compareTo(node.data);
		// recursive call w/ ternary if statement
		// is value of d < 0 or otherwise? Node.left if first, node.right if second
		return getLevel(n, d > 0 ? node.right : node.left) +1;
		
	}

	
	// *********************************************************
	// EXTRA CREDIT: 5pts
	// *********************************************************
	// A tree is height-balanced if at each node, the heights
	// of the node's two subtrees differs by no more than 1.
	//  Special note about null subtrees:
	//            10
	//              \
	//               20
	// Notice in this example that 10's left subtree is null,
	// and its right subtree has height 0. We would consider this
	// to be a balanced tree. If the tree is empty, return true;
	public boolean isBalanced() {
		return isBalanced(root);
	}

	
	private boolean isBalanced(Node n) {
		if (isEmpty()) {
			return true;
		}
		if (nodeCount == 2 && (n.left == null || n.right == null)) {
			return true;
		}
		int leftHeight = getHeight(n.left);
		int rightHeight = getHeight(n.right);
		int sub = Math.abs(leftHeight - rightHeight);
		if (sub <= 1 && isBalanced(n.left) && isBalanced(n.right)) {
			return true;
		} 
		return false;
	}
	


	
	//====================================================================================== Inner Node Class
	private class Node {
		private T data;
		private Node left, right;
		
		private Node(T data) {
			this.data = data;
			left = right = null;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		LinkedList<T> ll = new LinkedList<T>();
		inOrder(root, ll);
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return !ll.isEmpty();
			}

			@Override
			public T next() {
				if(!hasNext()) throw new IndexOutOfBoundsException();
				return ll.remove();
			}
		};

	}
}

