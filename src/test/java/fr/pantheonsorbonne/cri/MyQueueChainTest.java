package fr.pantheonsorbonne.cri;

import fr.pantheonsorbonne.cri.MyQueueChain.MyQueueChain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueChainTest {

    @Test
    public void pushAndPeekTest(){
        MyQueueChain a = new MyQueueChain();
        assertTrue(a.isEmpty());
        assertThrows(NullPointerException.class, a::peek);
        a.push("A");


        a.push("B");
        assertEquals("B", a.peek());
        a.poll();
        assertEquals("A", a.peek());
        a.poll();
        assertThrows(NullPointerException.class, a::peek);
    }

    @Test
    public void pollTest(){
        MyQueueChain a = new MyQueueChain();
        a.push("a");
        assertFalse(a.isEmpty());
        assertEquals("a", a.poll());
        assertTrue(a.isEmpty());
    }


}
