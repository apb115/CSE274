

public class LinkedBag<E> implements BagInterface<E> {
// =================== Class node
	private class Node {
		E data;
		Node next;

		Node(E data) {
			this(data, null);
		}

		Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}

		public String toString() {
			if (next == null)
				return "" + data;
			return data + ", " + next.toString();
		}
	}

	public Node head;
	public int size;

	public LinkedBag() {
		clear();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean add(E newEntry) {
		Node newNode = new Node(newEntry);
		Node tmp = head;
		if (isEmpty()) {
			head = newNode;
			size++;
			return true;
		}
		
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		// Make new case
		tmp.next = newNode;
		size++;
		return true;
	}

	@Override
	public E remove() {
		E ret = head.data;
		head = head.next;
		size--;
		return ret;
	}

	@Override
	public boolean remove(E anEntry) {
		if (isEmpty())
			return false;

		// find the anEntry and remove it.
		//If you want, implement something similar to what we did in HashSet.
		Node curr = head;
		while (curr != null) {
			if (curr.data == anEntry) {
				curr.data = head.data;
				head = head.next;
				size--;
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public int getFrequencyOf(E anEntry) {
		if (isEmpty())
			return 0;

		int count = 0;
		Node tmp = head;
		while (tmp != null) {
			if (tmp.data == anEntry) { count++; }
			tmp = tmp.next;
		}
		return count;
	}

	@Override
	public boolean contains(E anEntry) {
		if (isEmpty())
			return false;

		Node n = head;
		while (n != null) {
			if (n.data == anEntry) return true;
			n = n.next;
		}

		return false;
	}

	@Override
	public E[] toArray() {
		if (this.size() == 0) return null;
		Node tmp = head;
		String[] newArr = new String[this.size()];
		for (int i = 0; i < this.size(); i++) {
			newArr[i] = tmp.data.toString();
			tmp = tmp.next;
		}
		
		return (E[]) newArr;
	}

	@Override
	public void removeDuplicates() {

		Node tmp = head;
		while (tmp != null) {
			if	(getFrequencyOf(tmp.data) > 1) {
				remove(tmp.data);
			}
			tmp = tmp.next;
		}
	}
	@Override
	public boolean containsAll(BagInterface aBag) {
		if (this.isEmpty()) return aBag.isEmpty();
		if (!this.isEmpty() && aBag.isEmpty()) return true;
		
		LinkedBag<E> tmpLinked = this;
		LinkedBag<E> bagLinked = (LinkedBag<E>) aBag;
		
		bagLinked.removeDuplicates();
		tmpLinked.removeDuplicates();
		E[] bagArr = bagLinked.toArray();
		
		for (int i = 0; i < bagArr.length; i++) {
			if (!(tmpLinked.contains(bagArr[i]))) {
				return false;
			}
		}
		return true;
	}
	
	// HELPER METHOD
	public Node at(int index) {
		if (index >= this.size) throw new IndexOutOfBoundsException();
		Node tmp = head;
		int count = 0;
		while (tmp != null) {
			if (count == index) {
				return tmp;
			}
			tmp = tmp.next;
			count++;
		}
		return tmp;
	}

	@Override
	public boolean sameItems(BagInterface aBag) {
		if (this.isEmpty()) return aBag.isEmpty();
		if (this.size != aBag.size()) return false;
		
		LinkedBag<E> bagLinked = (LinkedBag<E>) aBag;
		Node tmp = head;
		Node tmp2 = bagLinked.head;
		
		if (bagLinked.size() != size()) return false;
		
		for (int i = 0; i < size(); i++) {
			if (at(i).equals(bagLinked.at(bagLinked.size()-1))) {
				if (getFrequencyOf(tmp.data) != bagLinked.getFrequencyOf(tmp2.data)) {
					return false;
				}
			}
			tmp = tmp.next;
			tmp2 = tmp2.next;
		}
		return true;
	}


	//toString method to help you test your code.
	@Override
	public String toString() {
		Node tmp = head;
		String ret = "";
		while (tmp != null) {
			ret = ret + " -> " + tmp.data;
			tmp = tmp.next;
		}
		return ret.substring(4);
	}

}