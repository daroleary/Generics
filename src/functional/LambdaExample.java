package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExample {

    public static void main(String[] args) {
	Person donDraper = new Person("Don Draper", 89);
	Person peggyOlson = new Person("Peggy Olson", 65);
	Person bertCooper = new Person("Bert Cooper", 100);

	List<Person> people = new ArrayList<>();
	people.add(donDraper);
	people.add(peggyOlson);
	people.add(bertCooper);

	Map<Boolean, List<Person>> oldAndYoungPeople = people.stream()
		.collect(Collectors.partitioningBy(person -> person.getAge() > 80));

	System.out.println(oldAndYoungPeople);


	Map<Boolean, Long> oldAndYoungCounts = people.stream()
		.collect(Collectors.partitioningBy(person -> person.getAge() > 80,
						   Collectors.counting()));
	System.out.println(oldAndYoungCounts);

    }

}
