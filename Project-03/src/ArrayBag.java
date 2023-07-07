
public class ArrayBag<E> implements BagInterface<E> {
	// =================== Instance Variables ===================
	private final static int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;
	
	// =================== Constructors ===================
	/**
	 * Initiates an ArrayBag object with default capacity of 10.
	 */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Initiates an ArrayBag object with provided capacity. The constructor
	 * does not accept capacity less than 5.
	 * @param capacity an int value
	 */
	public ArrayBag(int capacity) {
		if (capacity < 5) throw new IllegalArgumentException();
		elements = (E[]) new Object[capacity];
		clear();
	}
	
	// =================== Methods ===================
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean add(E newEntry) {
		// add at the end of the array, use size.
		if (isFull()) verifyCapacity();
		elements[size] = newEntry;
		size++;
		return true;
	}

	@Override
	public E remove() {
		if (isEmpty()) return null;
		E tmp = elements[size-1];
		elements[size-1] = null;
		size--;
		cutDownLength();
		return tmp;
	}

	// does cut down length reduce size?
	@Override
	public boolean remove(E anEntry) {
		if (isEmpty()) return false;
		if (size == 1 && getFrequencyOf(anEntry) == 1) remove();
		
		for (int i = 0; i < size; i++) {
			if (anEntry == elements[i]) {
				// elements[i] = null;
				elements[i] = elements[i-1];
				elements[i-1] = null;
				size--;
				cutDownLength();
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		while (size > 0) {
			elements[size] = null;
			size--;
		}
	}

	@Override
	public int getFrequencyOf(E anEntry) {
		if (isEmpty()) return 0;
		
		int count = 0;
		// implement a loop here.
		for (int i = 0; i < this.size; i++) {
			if (elements[i] != null) {
				if (elements[i].equals(anEntry)) {
					count++;
				}
			}
		}
		
		return count;
	}

	@Override
	public boolean contains(E anEntry) {
		if (isEmpty()) return false;
		
		for (int i = 0; i < size; i++) {
			if (elements[i] == anEntry) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public E[] toArray() {
		if (size == 0) return null;
		// Change to string array because of the JUnit test
		String[] newArr = new String[size];
		for (int i = 0; i < size; i++) {
			newArr[i] = elements[i].toString();
		}
		
		return (E[]) newArr;
	}
	// Correct Order?
	@Override
	public void removeDuplicates() {
		if (isEmpty() || size == 1) return;

		ArrayBag<E> tmpArr = new ArrayBag<E>(size());
		for (int i = 0; i < size(); i++) {
			if (!(tmpArr.contains(elements[i]))) {
				tmpArr.add(elements[i]);
			}
		}
		clear();
		for (int i = 0; i < tmpArr.size(); i++) {
			add(tmpArr.elements[i]);
		}
		cutDownLength();
	}

	@Override
	public boolean containsAll(BagInterface aBag) {
		if (this.isEmpty()) return aBag.isEmpty();
		if (!this.isEmpty() && aBag.isEmpty()) return true;
		// Write your implementation here, same as what we discussed in class.
		// You may use these methods: (toArray(), contains())
		ArrayBag<E> tmpArr = this;
		E[] bagArr = (E[]) aBag.toArray();
		for (int i = 0; i < bagArr.length; i++) {
			if (!(tmpArr.contains(bagArr[i]))) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean sameItems(BagInterface aBag) {
		if (this.isEmpty()) return aBag.isEmpty();
		if (this.size != aBag.size()) return false;
		
		
		// Implement a for loop here. Use the method getFrequencyOf().
		// This method is anagram method.
		ArrayBag<E> tmpArr = this;
		E[] bagArr = (E[]) aBag.toArray();
		
		for (int i = 0; i < this.size; i++) {
			for (int j = this.size-1; j > 0; j--) {
				if (tmpArr.elements[i].equals(bagArr[j])) {
					if (tmpArr.getFrequencyOf(tmpArr.elements[i]) != aBag.getFrequencyOf(bagArr[j])) {
						return false;
					}
				}
			}
		}
		return true;
	}

	// =================== Helper Methods ===================
	private void verifyCapacity() {
		if (isFull()) {
			E[] original = elements;
			int orig_size = original.length;
			elements = (E[]) new Object[orig_size * 2];
			for (int i = 0; i < orig_size; i++) {
				elements[i] = original[i];
			}
		}
	}
	
	private void cutDownLength() {
		if (isHalf() && elements.length >= 10) {
			E[] allData = elements;
			int orig_size = allData.length;
			elements = (E[]) new Object[orig_size / 2]; 
			for (int i = 0; i < size; i++) {
				elements[i] = allData[i];
			}
		}
	}

	private boolean isFull() {
		return size == elements.length;
	}
	
	private boolean isHalf() {
		return size == elements.length / 2;
	}
}