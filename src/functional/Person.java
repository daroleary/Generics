package functional;

import java.util.Objects;

public final class Person {

    private final String _name;
    private final int _age;

    public Person(String name, int age) {
	Objects.requireNonNull(name);

	_name = name;
	_age = age;
    }

    public String getName() {

	return _name;
    }

    public int getAge() {
	return _age;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}

	Person person = (Person) o;

	if (_age != person._age) {
	    return false;
	}
	return _name.equals(person._name);

    }

    @Override
    public int hashCode() {
	int result = _name.hashCode();
	result = 31 * result + _age;
	return result;
    }

    @Override
    public String toString() {
	return "Person{" +
	       "_name='" + _name + '\'' +
	       ", _age=" + _age +
	       '}';
    }
}
