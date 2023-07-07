import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<E> implements BSTInterface<E>  {

	private class Node {
		E data;
		Node left, right;

		Node(E data) {
			this.data = data;
			left = right = null;
		}
	}

	private Node root;
	private int size;
	public Traversal orderType;

	private Comparator<E> comp = new Comparator<E>() {

		@Override
		public int compare(E o1, E o2) {
			return ((Comparable) o1).compareTo(o2);
		}

	};

	public BST() {
		clear();
	}

	public BST(E[] lst) {
		this();
		for (E e : lst)
			add(e);
	}

	public BST(String data) {
		this();
		for (Character c : data.toCharArray())
			add((E) (" " + c));
	}

	@Override
	public boolean add(E e) {
		if (e == null)
			return false;
		if (root == null)
			root = new Node(e);
		else
			recAdd(root, e);
		size++;
		return true;
	}

	private void recAdd(Node n, E e) {
		int d = comp.compare(n.data, e);
		if (d < 0)
			if (n.right == null)
				n.right = new Node(e);
			else
				recAdd(n.right, e);
		else if (n.left == null)
			n.left = new Node(e);
		else
			recAdd(n.left, e);
	}

	@Override
	public boolean add(E e, int index) {
		throw new UnsupportedOperationException("BST does not support index");
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
		orderType = Traversal.IN_ORDER;
	}

	@Override
	public boolean contains(E o) {
		return get(o) != null;
	}

	@Override
	public E get(E target) {
		return recGet(target, root);
	}

	private E recGet(E target, Node node) {
		if (node == null) return null;
		int d = (comp.compare(target, node.data));
		if (d == 0)
			return node.data;
		return recGet(target, (d < 0 ? node.left : node.right));
	}

	@Override
	public int indexOf(E o) {
		throw new UnsupportedOperationException("BST does not support index");
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public boolean remove(int index) {
		throw new UnsupportedOperationException("BST does not support index");
	}

	@Override
	public boolean remove(E o) {
		return false;
	}

	@Override
	public boolean remove() {
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		LinkedList<E> ll = new LinkedList<E>();
		switch(orderType) {
		case BREADTH_FIRST: levelOrder(root, ll); break;
		case DEPTH_FIRST: preOrder(root, ll); break;
		case IN_ORDER: inOrder(root, ll); break;
		case POST_ORDER: postOrder(root, ll); break;
		}

		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				return !ll.isEmpty();
			}

			@Override
			public E next() {
				if(!hasNext()) throw new IndexOutOfBoundsException();
				return ll.remove();
			}

		};

		//return null;
	}

	private void levelOrder(Node node, LinkedList<E> ret) {
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


	private void preOrder(Node node, LinkedList<E> ret) {
		if(node == null) return;
		ret.add(node.data);
		if(node.left != null) preOrder(node.left, ret);
		if(node.right != null) preOrder(node.right, ret);
	}
	private void inOrder(Node node, LinkedList<E> ret) {
		if(node == null) return;
		if(node.left != null) inOrder(node.left, ret);
		ret.add(node.data);
		if(node.right != null) inOrder(node.right, ret);
	}

	private void postOrder(Node node, LinkedList<E> ret) {
		if(node == null) return;
		if(node.left != null) postOrder(node.left, ret);
		if(node.right != null) postOrder(node.right, ret);
		ret.add(node.data);
	}


	@Override
	public E min() {
		if(isEmpty()) return null;
		Node tmp = root;
		while (tmp.left != null)
			tmp = tmp.left;
		return tmp.data;
	}

	@Override
	public E max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> getIterator(BSTInterface.Traversal orderType) {
		// TODO Auto-generated method stub
		return null;
	}

}
