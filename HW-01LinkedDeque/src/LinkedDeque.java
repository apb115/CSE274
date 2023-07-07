import java.util.NoSuchElementException;

import LinkedQueue.Node;

// import LinkedQueue.node

public class LinkedDeque<E> implements DequeInterface<E>{
	//----------------------------------------------- Internal Node class
	private class Node {
		private E data;
		private Node next;
		
		private Node(E next) {
			this(next, null);
		}
		
		private Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	//-------------------------------------------------------------------
	
	//====================================================================================== Properties
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	//====================================================================================== Constructors
	public LinkedDeque() {
		head = tail = null;
		size = 0;
	}
	
	//====================================================================================== Methods
	@Override
	public boolean add(E e) {
		Node newNode = new Node(e);
		
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
		return true;
	}

	@Override
	public E remove() {
		E removed;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			removed = head.data;
			head = head.next;
			size--;
		}
		return removed;
	}

	@Override
	public boolean addFirst(E e) {
		Node newNode = new Node(e, null);

			newNode.next = head;
			head = newNode;
		size++;
		return true;
	}

	@Override
	public boolean addLast(E e) {
		Node newNode = new Node(e, null);
		
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
		return true;
	}

	@Override
	public boolean contains(E e) {
		Node test = head;
		while (test != null) {
			if(test.data == e) {
				return true;
			}
			test = test.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E peekFirst() {
			if (isEmpty())
				return null;
			else
				return head.data;
	}

	@Override
	public E peekLast() {
		if (isEmpty())
			return null;
		else
			return tail.data;
	}

	@Override
	public E removeFirst() {
		E removed;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			removed = head.data;
			head = head.next;
			size--;
		}
		return removed;
	}

	@Override
	public E removeLast() {
		E removed;
		Node test = head;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			while (test.next.next != null) {
				test = test.next;
			}
			removed = tail.data;
			tail.data = null;
			tail = test;
		}
		size--;
		return removed;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}

	@Override
	public String toString() {
		if (size() == 0) return "";
		String ret = "";
		Node tmp = head;
		while(tmp != null) {
			ret += "->" + tmp.data;
			tmp = tmp.next;
			}
		return ret.substring(2);
	}
	//----------------------------------------------- Internal Private Helper Methods
	
	
	//-------------------------------------------------------------------------------
	

}
