package genericclassandinterfaces;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheListProblem {

    public static void main(String[] args) {

	Person donDraper = new Person("Don Draper", 89);
	Person peggyOlson = new Person("Peggy Olson", 65);
	Person bertCooper = new Person("Bert Cooper", 100);

	List<Person> madMen = new ArrayList<>();
	madMen.add(donDraper);
	madMen.add(peggyOlson);
	madMen.add(bertCooper);

	System.out.println("Initial order:\n" + madMen + "\n");

	Collections.sort(madMen, Ordering
		.natural()
		.onResultOf(new Function<Person, Integer>() {

		    @Override
		    public Integer apply(Person input) {
			return input.getAge();
		    }
		}).reverse()

	);

	System.out.println("Ordered by Guava ordering:\n" + madMen + "\n");

	Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));

	System.out.println("Ordered by java.util.Comparator:\n" + madMen + "\n");
    }
}
