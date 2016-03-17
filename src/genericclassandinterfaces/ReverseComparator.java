package genericclassandinterfaces;

import com.google.common.primitives.Ints;

import java.util.Comparator;

/**
 * Comparator<T>           (parent is of generic type T)
 * Comparator<T>           (delegateComparator # delegate is of generic type T)
 * ReverseComparator<T>    (class is of generic type T)
 *
 */
public class ReverseComparator<T> implements Comparator<T> {

    private final Comparator<T> _delegateComparator;

    public ReverseComparator(Comparator<T> delegateComparator) {
	_delegateComparator = delegateComparator;
    }

    @Override
    public int compare(T o1, T o2) {
	return -1 * _delegateComparator.compare(o1, o2);
    }
}
