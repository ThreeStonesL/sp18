package synthesizer;
import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(10);
        assertEquals(10, arb.capacity());
        assertEquals(0, arb.fillCount());
        assertTrue(arb.isEmpty());
        assertFalse(arb.isFull());
        arb.enqueue(0);
        assertFalse(arb.isEmpty());
        assertFalse(arb.isFull());
        assertEquals(1, arb.fillCount());
        assertEquals((Integer) 0, arb.peek());
        assertEquals((Integer) 0, arb.dequeue());
        assertEquals(0, arb.fillCount());
        assertEquals(10, arb.capacity());
        for(int i = 0; i < 10; i ++)
            arb.enqueue(i);
        assertTrue(arb.isFull());
        assertFalse(arb.isEmpty());
        assertEquals(10, arb.fillCount());
        assertEquals(10, arb.capacity());
        assertEquals((Integer) 0, arb.peek());
        assertEquals((Integer) 0, arb.dequeue());
        assertFalse(arb.isFull());
        assertFalse(arb.isEmpty());
        for(int i = 0; i < 9; i++)
            arb.dequeue();
        assertEquals(10, arb.capacity());
        assertEquals(0, arb.fillCount());
        assertTrue(arb.isEmpty());
        assertFalse(arb.isFull());
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        Iterator<Integer> iter = arb.iterator();
        assertFalse(iter.hasNext());
        arb.enqueue(1);
        arb.enqueue(2);
        iter = arb.iterator();
        assertTrue(iter.hasNext());
        assertEquals((Integer)1, iter.next());
        assertTrue(iter.hasNext());
        assertEquals((Integer)2, iter.next());
        assertFalse(iter.hasNext());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
