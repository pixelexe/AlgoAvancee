package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.MyHashSet.MyHashSet;

public class MyHashSetTest {
    
    @Test
    public void addTest(){
        MyHashSet a = new MyHashSet();
        
        a.add("S");
        assertEquals("S".hashCode()%10, 3);
        assertEquals("&&&S|&&&&&&&", a.toString());
        assertFalse(a.add("S"));
        assertTrue(a.add("A"));
        assertEquals("&&&S|&&A|&&&&&", a.toString());
        assertTrue(a.add("B"));
        assertEquals("&&&S|&&A|&B|&&&&", a.toString());
        for (int i = 97 ; i < 117; i++){
            a.add(Character.toString(i));
        }
        assertEquals("&&&S|&&&&&&&&&&&&&&a|&b|&c|&d|&e|&f|&g|&h|&A|i|&B|j|&k|&l|&m|&n|&o|&p|&q|&r|&s|&t|&&&&", a.toString());
        assertTrue(a.contains("s"));
    }
}
