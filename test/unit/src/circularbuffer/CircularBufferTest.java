package circularbuffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularBufferTest {

    private CircularBuffer buffer;

    @Before
    public void setup() {
        buffer = new CircularBuffer(2);
    }

    @Test
    public void poll_shouldPollElement_successfully() {

        assertTrue(buffer.offer(1));

        assertEquals(1, buffer.poll());
        assertNull(buffer.poll());
    }

    @Test
    public void offer_shouldNotOfferWhenBufferIsFull_successfully() {

        assertTrue(buffer.offer(1));
        assertTrue(buffer.offer(2));
        assertFalse(buffer.offer(3));
    }

    @Test
    public void poll_shouldRecycleBuffer_successfully() {

        assertTrue(buffer.offer(1));
        assertTrue(buffer.offer(2));
        assertEquals(1, buffer.poll());
        assertTrue(buffer.offer(3));
        assertEquals(2, buffer.poll());
        assertEquals(3, buffer.poll());
    }
}
