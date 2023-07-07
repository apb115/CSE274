import java.util.Iterator;

public interface BSTInterface<E> extends CollectionInterface<E>, Iterable<E> {
	public enum Traversal {
		BREADTH_FIRST, // Level
		DEPTH_FIRST, // PRE
		IN_ORDER, // IN
		POST_ORDER // POST
	};

	E min();

	E max();

	int height();

	public Iterator<E> getIterator(Traversal orderType);
}