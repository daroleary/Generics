package reflection;

public class Logger {

    private String _value;

    public Logger(final String value) {
	_value = value;
    }

    public void log() {
	System.out.println(_value);
    }
}
