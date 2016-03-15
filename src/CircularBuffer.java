/**
 * Circular Buffer
 *
 * Writes (offer) in data if not already set
 * Reads (poll) the output if present, once read clears the data and points to next available entry
 * 
 */
public class CircularBuffer {

    private Object[] _buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
	_buffer = new Object[size];
    }

    public boolean offer(Integer value) {
        if (_buffer[writeCursor] != null) {
            return false;
        }
        _buffer[writeCursor] = value;
        writeCursor = next(writeCursor);

	return true;
    }

    public Object poll() {
        final Object value = _buffer[readCursor];

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
