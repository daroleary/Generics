package collections;

import java.util.ArrayList;
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

	System.out.println(madMen);
    }
}
