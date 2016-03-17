package wildcards;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonStorageTest {

    Partner _donDraper = new Partner("Don Draper", 89);
    Partner _peggyOlson = new Partner("Peggy Olson", 65);
    Employee _bertCooper = new Employee("Bert Cooper", 100);

    private File _file;
    private PersonLoader _loader;
    private PersonSaver _saver;

    @Test
    public void savesAndLoadsPerson() throws Exception {
	Person person = new Person("Bob", 20);
	_saver.save(person);

	assertEquals(person, _loader.load());
    }

    @Test
    public void savesAndLoadsArraysOfPeople() throws Exception {
	List<Person> persons = new ArrayList<>();
	persons.add(_donDraper);
	persons.add(_bertCooper);

	_saver.saveAll(persons);

	assertEquals(_donDraper, _loader.load());
	assertEquals(_bertCooper, _loader.load());
    }

    @Test
    public void loadsListsOfPeople() throws IOException, ClassNotFoundException {
	_saver.save(_donDraper);
	_saver.save(_peggyOlson);
	_saver.save(_bertCooper);

	List<Person> people = new ArrayList<>();
	_loader.loadAll(people);

	assertEquals(_donDraper, people.get(0));
	assertEquals(_peggyOlson, people.get(1));
	assertEquals(_bertCooper, people.get(2));
    }

    @Before
    public void setUp() throws Exception
    {
	_file = File.createTempFile("tmp", "people");
	_loader = new PersonLoader(_file);
	_saver = new PersonSaver(_file);
    }

    @After
    public void tearDown()
    {
	if (_file.exists()) {
	    _file.delete();
	}
    }
}
