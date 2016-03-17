package typebounds;

/**
 *
 * SortedPair<T extends Comparable>     (means T is bounded by an Object which implements the interface Comparable)
 * <T extends Comparable<T>>            (in order to complete it, You need to indicate what the Comparable Interface is generic to, which is of type T)
 */
public class SortedPair<T extends Comparable<T>> {

    private final T _first;
    private final T _second;

    public SortedPair(T left, T right) {
	if (left.compareTo(right) < 0) {
	    _first = left;
	    _second = right;
	} else {
	    _first = right;
	    _second = left;
	}
    }

    public T getFirst() {
	return _first;
    }

    public T getSecond() {
	return _second;
    }
}
