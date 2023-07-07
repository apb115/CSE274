import java.util.NoSuchElementException;

// Put your prologue comments here
// Code to initialize methods of a Linked List
/**
 * @author 
 *  Andrew Boothe
 * @apiNote
 * 		Project-02
 * 		Linked Algorithms
 *
 */
public class LinkedListAlgorithms {

	//==================================================================== Internal Node Class
	private class Node {
		String data;
		Node next;

		Node(String data) {
			this(data, null);
		}
		
		Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		// You may add helper methods here
		public String toString() {
			if(next == null) return data.toString();
			return data + ", " + next.toString();
		}
	}
	//========================================================================================
	
	

	//==================================================================== Properties
	public Node head;
	public int size;

	//==================================================================== Constructors
	
	public Node findNode(int i) {
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
		Node tmp = head;
		for (int j = 0; j <= i; j++) {
			if (j == i) {
				return tmp;
			}
			tmp = tmp.next;
		}
		return tmp;
	}
	
	/**
	 * Creates the empty list.
	 */
	public LinkedListAlgorithms() {
		head = null;
		size = 0;
	}

	/**
	 * Creates a list containing all the elements of the passed array. 
	 * {@code data[0]} will be the first element of the list, {@code data[1]} will
	 * be the second element of the list, and so on.
	 * 
	 * @param data The array of values
	 * @throws NullPointerException - data is null
	 */
	public LinkedListAlgorithms(String[] data) {
		if (data == null)	throw new NullPointerException();
		if (data.length == 0) {
			head = null;
			size = 0;
			return;
		}
		
		head = new Node(data[0]);
		size++;
		Node trav = head;
		for (int i = 1; i < data.length; i++) {
			size++;
			Node tmp = new Node(data[i]);
			trav.next = tmp;
			trav = tmp;
		}
	}

	/**
	 * Constructs a deep copy of the linked list {@code original}
	 * 
	 * @param original The list to be copied
	 * @throws NullPointerException - original is null
	 */
	public LinkedListAlgorithms(LinkedListAlgorithms original) {
		if (original == null) throw new NullPointerException();
		if (original.size == 0) {
			head = null;
			size = 0;
			return;
		}
		head = new Node(original.getAt(0));
		size++;
		Node trav= head;
		for (int i = 1; i < original.size; i++) {
			size++;
			Node tmp = new Node(original.getAt(i));
			trav.next = tmp;
			trav = tmp;
		}
	}

	//==================================================================== Methods
	
	
	// HELPER METHOD
	public boolean isEmpty() {
		return head == null;
	}
	
	
	/**
	 * Returns array with all the elements.
	 * 
	 * @return Array containing all elements.
	 */
	public String[] toArray() {
		String[] newArray = new String[size];
		
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = head.data;
			head = head.next;
		}
		return newArray;
	}

	/**
	 * Formats the elements in the list using leading and ending brackets (i.e., []), with the values comma separated. 
	 * There will be one space between each of these but none at the beginning nor at the end.
	 * Some examples:
	 * if the list is empty, toString() gives []
	 * if the list has these three elements in this order: "hello", "world", "everyone", then the result should be 
	 *      [hello, world, everyone]
	 */
	@Override
	public String toString() {
		if(isEmpty()) return "[]";
		String result = "[";
		Node tmp = head;
		while (tmp.next != null) {
			result += tmp.data + ", ";
			tmp = tmp.next;
		}
		if (tmp.next == null) {
			result += tmp.data + "]";
		}
		return result;
	}

	/**
	 * Returns the number of items in the list
	 * 
	 * @return Number of items in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Determines if two lists contain exactly the same values, in exactly the same
	 * order.
	 * 
	 * @return {@code true} if and only if obj is an list that is equivalent to the
	 *         incoming list.
	 */
	public boolean equalsLinkedList(LinkedListAlgorithms obj) {
		if (size != obj.size) return false;
		Node trav1 = head;
		Node trav2 = obj.head;
		while (trav1 != null) {
			if (!trav1.data.equals(trav2.data)) return false;
			trav1 = trav1.next;
			trav2 = trav2.next;
		}
		return true;
	}

	/**
	 * Determines if {@code key} is in the linked list.
	 * 
	 * @param key The value to be found
	 * @return true if and only if {@code key} is in the list
	 */
	public boolean contains(String key) {
		Node tmp = head;
		while (tmp != null) {
			if (tmp.data == key) {
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}

	/**
	 * Determines the index of {@code key}. -1 is returned if the value is not
	 * present in the linked list. If {@code key} is present present more than once,
	 * the first index is returned.
	 * 
	 * @param key The value to be found
	 * @return The index of the {@code key}
	 */
	public int find(String key) {
		Node tmp = head;
		for (int i = 0; i < size; i++) {
			if (tmp.data == key) {
				return i;
			}
			tmp = tmp.next;
		}
		return -1;
	}

	/**
	 * Returns the value of the first element of the list.
	 * 
	 * @return The first element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getFirst() {
		if(head == null) throw new NoSuchElementException();	
		return head.data;
	}

	/**
	 * Returns the value of the last element of the list.
	 * 
	 * @return The last element of the list.
	 * @throws NoSuchElementException the list is empty
	 */
	public String getLast() {
		if(head == null) throw new NoSuchElementException();	
		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		return tmp.data;
	}

	/**
	 * Returns the value of the {@code ith} element of the list (0 based).
	 * 
	 * @param i The target index
	 * @return The value of the ith element of the list.
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public String getAt(int i) {
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
		Node tmp = head;
		for (int j = 0; j < i; j++) {
			tmp = tmp.next;
		}
		return tmp.data;
	}

	/**
	 * Adds {@code data} to the beginning of the list. All other values in the list
	 * remain but they are "shifted to the right."
	 * 
	 * @param data The value to add to the list
	 */
	public void insertFirst(String data) {
		Node newNode = new Node(data);
		Node tmp = head;
		if (tmp == null) {
			tmp = newNode;
		} else {
			head = newNode;
			head.next = tmp;
		}
		size++;
	}

	/**
	 * Adds {@code data} to the end of the list. All other values in the list remain
	 * in their current positions.
	 * 
	 * @param data The value to add to the list
	 */
	public void insertLast(String data) {
		Node newNode = new Node(data);
		Node tmp = head;
		if (tmp == null) {
			tmp = newNode;
		} else {
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
		size++;
	}

	/**
	 * Adds data to a specific spot in the list. The values in the list remain
	 * intact but {@code data} is inserted in the list at position {@code i}. When
	 * {@code i=0}, the result is the same as {@code insertFirst}.
	 * 
	 * @param i    The target index
	 * @param data The value to add to the list
	 * @throws IndexOutOfBoundsException {@code i} is illegal
	 */
	public void insertAt(int i, String data) {
		if (i < 0 || i > size) throw new IndexOutOfBoundsException();
		int count = 0;
		Node tmp = head;
		while (count < i) {
			tmp = tmp.next;
			count++;
		}
		tmp.data = data;
	}

	/**
	 * Adds {@code newData} the position immediately preceding {@code existingData}.
	 * If the {@code existingData} appears multiple times, only the first one is
	 * used.
	 * 
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertBefore(String newData, String existingData) {
		int find = find(existingData);
		if (find == -1) {
			throw new NoSuchElementException();
		} else {
			insertAt(find-1, newData);
		}
	}

	/**
	 * Adds {@code newData} the position immediately after {@code existingData}. If
	 * the {@code existingData} appears multiple times, only the first one is used.
	 * 
	 * @param newData      The value to add to the list
	 * @param existingData The value used to control where insertion is to take
	 *                     place
	 * @throws NoSuchElementException {@code existingData} is not in the list
	 */
	public void insertAfter(String newData, String existingData) {
		int find = find(existingData);
		if (find == -1) {
			throw new NoSuchElementException();
		} else {
			insertAt(find+1, newData);
		}
	}

	/**
	 * Removes the first element of the list. The remaining elements are kept in
	 * their existing order.
	 * 
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeFirst() {
		if (isEmpty()) throw new NoSuchElementException();
		Node tmp = head;
		String ret = tmp.data;
		head = tmp.next;
		tmp = null;
		size--;
		return ret;
	}

	/**
	 * Removes the last element of the list. The remaining elements are kept in
	 * their existing order.
	 * 
	 * @return The value removed from the list
	 * @throws NoSuchElementException if the list is empty.
	 */
	public String removeLast() {
		if (isEmpty()) throw new NoSuchElementException();
		String ret = "";
		
		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		ret = tmp.data;
		tmp = null;
		
		size--;
		return ret;
	}

	/**
	 * Removes the ith element of the list. The remaining elements are kept in their
	 * existing order.
	 * 
	 * @param i The target index
	 * @return The value removed from the list
	 * @throws IndexOutOfBoundsException i does not represent a legal index
	 */
	public String removeAt(int i) {
		if (i < 0 || i > size) throw new IndexOutOfBoundsException();
		Node tmp = head;
		String ret;
		// gets data at soon-to-be removed element
		for (int j = 0; j <= i; j++) {
			tmp = tmp.next;
		}
		ret = tmp.data;
		// increments around removed element
		for (int k = i; k < size-1; k++) {
			insertAt(k , tmp.data);
			tmp = tmp.next;
		}
		removeLast();
		return ret;
	}

	/**
	 * Removes the first occurrence of data in the linked list.
	 * 
	 * @param data The value to be removed.
	 * @return {@code true} if and only if {@code data} was removed
	 */
	public boolean removeFirstOccurrenceOf(String data) {
		Node tmp = head;
		int count = 0;
		while (tmp.next != null) {
			if (tmp.data == data) {
				// first match gets removed and boolean returned
				removeAt(count);
				return true;
			}
			count++;
			tmp = tmp.next;
		}
		
		
		return false;
	}

	/**
	 * Removes the all occurrence of {@code data} in the linked list.
	 * 
	 * @param data The value to be removed.
	 * @return The number of times {@code data} was removed
	 */
	public int removeAllOccurrencesOf(String data) {
		Node tmp = head;
		int removeCount = 0;
		for (int i = 0; i < size; i++) {
			if (tmp.data == data) {
				// each match gets removed and a count is incremented
				removeAt(i);
				removeCount++;
			}
			tmp = tmp.next;
		}
		return removeCount;
	}

	/**
	 * Reverses the elements in the incoming linked list.
	 */
	public void reverse() {
		Node before = null;
		Node tmp = head;
		Node after = head;
		// reverses and reinitializes linked list
		while(tmp != null) {
			after = after.next;
			tmp.next = before;
			before = tmp;          
			tmp = after;
			head = before;
		}
	}

	/**
	 * Puts all the elements in the list to uppercase.
	 */
	public void toUpper() {
		Node tmp = head;
		while (tmp != null) {
			tmp.data = tmp.data.toUpperCase();
			tmp = tmp.next;
		}
	}

	/**
	 * Returns the comma concatenation of all strings, from left to right.
	 * NO additional characters should be added between words
	 *		Example: 	Linked List = ["Hello", "World" ] 
	 *					the output should be: HelloWorld
	 * 
	 * @return Concatenation of all string in the list
	 */
	public String getConcatenation() {
		String ret = "";
		Node tmp = head;
		while (tmp != null) {
			// adds string data to ret
			ret += tmp.data;
			tmp = tmp.next;
		}
		return ret;
	}

	/**
	 * Returns the alphabetically last value in the list.
	 * 
	 * @return The alphabetically last value in the list
	 * @throws NoSuchElementException list is empty
	 */
	
	// example:
			// Bob -> Sandy -> Al -> Sandy -> Dan
			// getAlphabeticallyLast() returns "Sandy"
	public String getAlphabeticallyLast() {
		String ret = "";
		Node tmp = head;

		while(tmp != null) {
			// sets ret to the last string alphabetically
			if(tmp.data.compareTo(ret) > 0) {
				ret = tmp.data;
			}
			tmp = tmp.next;
		}
		return ret;
	}

	/**
	 * Returns the index where the alphabetically last value resides. If this
	 * value appears multiple times, the first occurrence is used.
	 * 
	 * @return Index value of where maximum value resides
	 * @throws NoSuchElementException list is empty
	 */
	public int indexOfAlphabeticallyLast() {
		String ret = "";
		Node tmp = head;
		while(tmp != null) {
			// sets ret to the last string alphabetically
			if(tmp.data.compareTo(ret) > 0) {
				ret = tmp.data;
			}
			tmp = tmp.next;
		}
		for (int i = 0; i < size; i++) {
			if (getAt(i).equals(ret)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Determines if the two list contain elements that have exactly the same
	 * value, with the same list sizes, but with the elements perhaps in different order.
	 * 
	 * @returns true only if the two lists are permutations of one another.
	 */
	public boolean anagrams(LinkedListAlgorithms other) {
		int count = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = size-1; j >= 0; j--) {
				if (getAt(i).equalsIgnoreCase(other.getAt(j))) {
					// adds a count wherever there is a match in different position
					count++;
				}
			}
		}
		if (count == size) return true;
		return false;
	}

	//==================================================================== Internal Testing
	public static void main(String[] args) {
		String[] items = { "hello", "world" };
		LinkedListAlgorithms LL1 = new LinkedListAlgorithms();
		LinkedListAlgorithms LL2 = new LinkedListAlgorithms(items);
		LinkedListAlgorithms LL3 = new LinkedListAlgorithms(LL1);
	}
}

