

import java.util.Iterator;

public class DoublyLinkedCollectionIteration<E> implements CollectionInterface<E>, Iterable<E> {
	//====================================================================================== Internal Classes
	private class Node {
		E data;
		Node next;
		Node prev;

		public Node(E data) {
			this(data, null, null);
		}

		public Node(E data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		//============================================= Internal Node methods
		void remove() {
			if(this == head) head = next;
			if(this == tail) tail = prev;
			if(prev != null) prev.next = next;
			if(next != null) next.prev = prev;
		}

		Node insertLeft(Node n) {
			n.next = this;
			n.prev = prev;
			if(prev != null) prev.next = n;
			prev = n;
			if(this == head) head = n;
			return n;					
		}

		Node insertRight(Node n) {
			n.prev = this;
			n.next = next;
			if(next != null) next.prev = n;
			next = n;
			if(this == tail) tail = n;
			return n;
		}

		Node find(E data) {
			if(data.equals(this.data)) return this;
			if(next == null) return null;
			return next.find(data);
		}

		Node get(int i) {
			if(i == 0) return this;
			if(next == null) return null;
			return next.get(--i);
		}

		public String toString() {
			if(next == null) return data.toString();
			return data + ", " + next.toString(); 
		}	
	}

	//====================================================================================== Properties
	private Node head;
	private Node tail;
	private int size;

	//====================================================================================== Constructors
	public DoublyLinkedCollectionIteration() 			{		clear();					}

	//====================================================================================== Methods
	@Override	public boolean isEmpty() 		{		return head == null;		}
	@Override	public boolean remove()			{		return remove(size-1);		}
	@Override	public int size() 				{		return size;				}
	@Override	public boolean contains(E o)	{		return indexOf(o) > -1;		}
	@Override	public boolean add(E e) 		{		return add(e, size);		}
	
	
	@Override
	public boolean add(E e, int index) {
		if (index < 0 || index > size) throw new IndexOutOfBoundsException();
		if(isEmpty()) {
			head = tail = new Node(e);	
		} else {
			if(index == size) 			tail = tail.insertRight(new Node(e));
			else if (index == 0)		head = head.insertLeft(new Node(e));
			else head.get(index).insertLeft(new Node(e));		
		}
		size++;
		return true;	
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		return head.get(index).data;		
	}

	@Override
	public int indexOf(E o) {
		if(!isEmpty()) {
			Node tmp = head;
			int i = 0;
			while(tmp != null) {
				if(tmp.data.equals(o)) return i;
				i++;
				tmp = tmp.next;
			}
		}
		return -1;
	}

	@Override
	public boolean remove(int index) {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		return remove(head.get(index));		
	}
	
	@Override
	public boolean remove(E o) {
		if(isEmpty()) return false;
		return remove(head.find(o));
	}


	@Override
	public String toString() {
		if(isEmpty()) return "[]";
		return "[" + head.toString() + "]";
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node prev = null, curr = head;
			@Override
			public boolean hasNext() {
				return curr != null;
			}

			@Override
			public E next() {
				prev = curr;
				curr = curr.next;
				return prev.data;
			}
			
			@Override
			public void remove() {
				prev.remove();
				prev = null;
			}
		};		
	}



}
