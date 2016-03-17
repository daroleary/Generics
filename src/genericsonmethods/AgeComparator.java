package genericsonmethods;

import com.google.common.primitives.Ints;

import java.util.Comparator;

public class AgeComparator<T extends Person> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
	return Ints.compare(o1.getAge(), o2.getAge());
    }
}
