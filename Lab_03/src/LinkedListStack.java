import java.util.EmptyStackException;

/**
 * A Linked List based stack.
 * @author Mike Stahr
 *
 */

public class LinkedListStack<Athlete> implements StackInterface<Athlete> {
	
	//======================================================== Inner Node Class
	private class Node {
		Athlete data = null;
		Node next = null;
		
		public Node(Athlete data) {
			this(data, null);
		}
		
		public Node(Athlete data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	//=========================================================================
	
	// private member variable to keep track of the number of nodes
	private int size;
	private Node head;
	
	/*
	 * For the following implementations, refer to the StackInterface for 
	 * documentation on how to handle edge cases
	 * 
	 */
	@Override
	public void push(Athlete item) {
		head = new Node(item, head);
		size++;
	}

	@Override
	public Athlete pop() {
		Athlete a = peek();
		head = head.next;
		size--;
		return a;
	}

	@Override
	public Athlete peek() {	
		if (isEmpty()) 
			throw new EmptyStackException();
		return head.data;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	// Returns (without removing) the Athlete as the index position
	// throws IndexOutOfBoundsException if index is invalid 
	public Athlete get(int index) {
		for (int i = 0; i < index; i++) {
			head = head.next;
		}
		return head.data;
	}

	// Reverses the stack
	public void reverseStack() {
		
		LinkedListStack<Athlete> rev = new LinkedListStack<>();
		LinkedListStack<Athlete> fwd = new LinkedListStack<>();		

		while(!(isEmpty())) {
			rev.push(pop());
		}
		
		while(!(rev.isEmpty())) {
			fwd.push(rev.pop());
		}
		
		while(!(fwd.isEmpty())) {
			push(fwd.pop());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Node tmp = head;
		while (tmp != null) {
			sb.append(tmp.data);
			sb.append("\t");
			tmp = tmp.next;
		}
		return sb.toString();
	}
	
}
