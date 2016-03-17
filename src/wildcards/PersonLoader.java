package wildcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader {

    private final RandomAccessFile _file;

    public PersonLoader(final File file) throws FileNotFoundException {
	_file = new RandomAccessFile(file, "rw");
    }

    public Person load() throws ClassNotFoundException {

	try {
	    final String className = _file.readUTF();
	    final String personName = _file.readUTF();
	    final int age = _file.readInt();

	    // unbounded wildcard, anything which is an Object
	    final Class<?> personClass = Class.forName(className);
	    final Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
	    return (Person) constructor.newInstance(personName, age);

	} catch (IOException e) {
	    return null;
	} catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    /**
     * Wild cards are only used for "in" or "out" parameters, is parameter is used for both purposes use a type T instead
     * Use Lower bounds when using an "out" paramater (the final parameter is used solely outside of the method)
     *
     * <? super Person>        (lower bound wildcards, anything which either Is, Extends or Implements a person)
     * List<? super Person>    (List supports any Object which either Is, Extends or Implements a Person)
     */
    public void loadAll(final List<? super Person> people) throws IOException, ClassNotFoundException {
	Person person;
	while ((person = load()) != null) {
	    people.add(person);
	}
    }
}
