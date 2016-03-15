package circularbuffer;

public class TypeUnsafeExample {

    public static void main(String[] args) {

	StringCircularBuffer buffer = new StringCircularBuffer(10);

	buffer.offer("a");
	buffer.offer("bc");
	buffer.offer("d");

	String value = concatenate(buffer);
	System.out.println(value);
    }

    private static String concatenate(StringCircularBuffer buffer) {

	StringBuilder result = new StringBuilder();

	String value;
	while ((value = buffer.poll()) != null) {
	    result.append(value);
	}

	return result.toString();
    }
}
