package wildcards;

public class Partner extends Person {

    public Partner(String name, int age) {
	super(name, age);
    }

    @Override
    public String toString() {
	return "Partner{" +
	       "name='" + getName() + "\'" +
	       ", age=" + getAge() +
	       "}";
    }
}
