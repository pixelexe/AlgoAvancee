package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.MyQueueArray.MyQueueArray;
import fr.pantheonsorbonne.cri.MyQueueArray.MyQueueEmptyException;

public class MyQueueArrayTest {
    
    @Test
    public void testPush() throws MyQueueEmptyException {
        MyQueueArray queue = new MyQueueArray();
        queue.push("test");
        assertEquals(queue.toString(), "[test]");
        queue.push("test2");
        queue.push("test3");
        assertEquals(queue.toString(), "[test, test2, test3]");
        assertEquals(queue.poll(), "test3");
        assertEquals(queue.peek(), "test2");
        assertEquals(queue.toString(), "[test, test2]");
    }
}
