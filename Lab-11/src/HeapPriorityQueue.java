import java.util.Arrays;
import java.util.NoSuchElementException;

public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	private T[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	public HeapPriorityQueue() {
		this(DEFAULT_CAPACITY);
	}

	public HeapPriorityQueue(int initialCapacity) {
		elements = (T[]) new Comparable[initialCapacity + 1];
	}

	public HeapPriorityQueue(T[] entries) {
		this(entries.length + 1);
		size = entries.length;
		for (int i = 0; i < entries.length; i++) {
			elements[i+1] = entries[i];
		}
		for (int rIndex = size / 2; rIndex > 0; rIndex--) {
			reheapDown(rIndex);
		}
	}

	@Override
	public boolean isEmpty() {
		return elements[1] == null;
	}

	@Override
	public void clear() {
		for (int index = 1; index <= size; index++)
			elements[index] = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(T newEntry) {
		verifyCapacity();
		elements[++size] = newEntry;
		reheapUp(size);
	}

	private void reheapUp(int index) {

		int parentIndex = index / 2;
		while (parentIndex > 0 && elements[index].compareTo(elements[parentIndex]) > 0) {
			swap(index, parentIndex);
			index = parentIndex;
			parentIndex = index / 2;
		}
	}

	private void swap(int index, int parentIndex) {
		T tmp = elements[index];
		elements[index] = elements[parentIndex];
		elements[parentIndex] = tmp;
	}

	private void verifyCapacity() {
		if (isFull()) {
			elements = Arrays.copyOf(elements, elements.length*2);
		}
	}

	@Override
	public T peek() {
		return isEmpty() ? null : elements[1];
	}

	@Override
	public T remove() {
		if (isEmpty())
			throw new NoSuchElementException();
		T ret = elements[1];
		elements[1] = elements[size];
		elements[size] = null;
		reheapDown(1);
		size--;
		return ret;
	}
	
	private int getMaxChildIndex(int index) {
		if (elements[(index*2)+1] != null && elements[(index*2)] == null) return (index*2)+1;
		if (elements[(index*2)+1] == null && elements[(index*2)] != null) return (index*2);
		if (elements[(index*2)+1] == null && elements[(index*2)] == null) return -1;
		if (elements[(index*2)+1].compareTo(elements[(index*2)]) > 0) return (index*2)+1;
		return index*2;
	}

	private void reheapDown(int index) {
		int leftI = index * 2;
		int rightI = index * 2 + 1;
		int child = 0;
		boolean check = false;
		if (leftI >= size) {
			return;
		}
		child = leftI;
		while (check == false) {
			if (rightI < size) {
				if (elements[rightI].compareTo(elements[leftI]) > 0) {
					child = rightI;
				}
			}
			if (elements[index].compareTo(elements[child]) < 0) {
				swap(child, index);
				reheapDown(child);
			}
			check = true;
		}
	}
	
	public boolean isFull() {
		
		return size == elements.length-1;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[ ]";
		return Arrays.toString(elements);
	}

}
