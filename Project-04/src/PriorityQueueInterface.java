
public interface PriorityQueueInterface<T extends Comparable<? super T>> {
	boolean isEmpty();

	void clear();

	int size();

	void add(T newEntry);

	T peek(); // returns null if empty

	T remove(); // throws NoSuchElementException if empty
}