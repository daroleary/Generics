package circularbuffer;

/**
 * Circular Buffer
 *
 * Writes (offer) in data if not already set
 * Reads (poll) the output if present, once read clears the data and points to next available entry
 *
 */
public class StringCircularBuffer {

    private String[] _buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public StringCircularBuffer(int size) {
	_buffer = new String[size];
    }

    public boolean offer(String value) {
        if (_buffer[writeCursor] != null) {
            return false;
        }
        _buffer[writeCursor] = value;
        writeCursor = next(writeCursor);

	return true;
    }

    public String poll() {
        final String value = _buffer[readCursor];

        // should be optional
        if (value != null) {
            // once read we need to null out the buffer
            _buffer[readCursor] = null;
            readCursor = next(readCursor);
        }

        return value;
    }

    private int next(int index) {
        // loop until to end of the buffer and loop around
        return (index + 1) % _buffer.length;
    }
}
