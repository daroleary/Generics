package intersection;

import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PersonReader {

    public static void main(String[] args) throws FileNotFoundException {
	PersonReader reader = new PersonReader();

	DataInputStream stream = new DataInputStream(new FileInputStream(
		"src/intersection/resources/person"));
	Person person = reader.read(stream);
	System.out.println(person);

	RandomAccessFile randomAccessFile = new RandomAccessFile(
		"src/intersection/resources/person", "rw");
	person = reader.read(randomAccessFile);
	System.out.println(person);
    }

    private <T extends DataInput & Closeable> Person read(final T source) {
	try (T input = source) {
	    return new Person(input.readUTF(), input.readInt());
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }
}
