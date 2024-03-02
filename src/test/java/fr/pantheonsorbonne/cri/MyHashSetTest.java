package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.MyHashSet.MyHashSet;

public class MyHashSetTest {
    
    @Test
    public void addTest(){
        MyHashSet a = new MyHashSet();
        
        a.add("S");
        assertEquals("S".hashCode()%10, 3);
        assertEquals("\n\n\nS     |\n\n\n\n\n\n\n", a.toString());
        //assertFalse(a.add("S"));
        assertEquals("\n\n\nS     |\n\n\n\n\n\n\n", a.toString());
    }

}
