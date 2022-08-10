import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testArrayDeque() {
        ArrayDequeSolution<Integer> dequeSolution = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        String message = new String("");
        for(int i = 0; i <= 10000; i ++) {
            double randomNumber = StdRandom.uniform();
            if (randomNumber < 0.25) {
                dequeSolution.addFirst(i);
                studentArrayDeque.addFirst(i);
                message += "addFirst(" + i + ")\n";
            }
            else if (randomNumber < 0.5) {
                dequeSolution.addLast(i);
                studentArrayDeque.addLast(i);
                message += "addLast(" + i + ")\n";
            }
            else if (randomNumber < 0.75) {
                if (dequeSolution.isEmpty())
                    continue;
                message += "removeFirst()\n";
                assertEquals(message, dequeSolution.removeFirst(), studentArrayDeque.removeFirst());
            }
            else {
                if (dequeSolution.isEmpty())
                    continue;
                message += "removeLast()\n";
                assertEquals(message, dequeSolution.removeLast(), studentArrayDeque.removeLast());
            }
        }
    }
}
