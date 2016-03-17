package wildcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {

    private final RandomAccessFile _file;

    public PersonSaver(final File file) throws FileNotFoundException {
	_file = new RandomAccessFile(file, "rw");
    }

    public void save(Person person) throws IOException {
        _file.writeUTF(person.getClass().getName());
        _file.writeUTF(person.getName());
        _file.writeInt(person.getAge());
    }

    /**
     * Wild cards are only used for "in" or "out" parameters, is parameter is used for both purposes use a type T instead
     * Use Upper bounds when using an "in" paramater (parameter is used within the method only)
     *
     * <? extends Person>           (upper bounded wildcard, anything which Is or Extends a Person)
     *
     * List<? extends Person>       (list can contain anything as long as it extends a Person)
     * Use '?' over T when usage is on one parameter
     */
    public void saveAll(final List<? extends Person> persons) throws IOException {
        for (Person person : persons) {
            save(person);
        }
    }
}
