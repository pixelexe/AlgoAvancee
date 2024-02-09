package fr.pantheonsorbonne.cri;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.MyTreeSet.MyTreeSet;

public class MyTreeSetTest {
    
    @Test
    void addTest(){
        MyTreeSet tree = new MyTreeSet("test");
        assertEquals(true, tree.add("t"));
        assertEquals(false, tree.add("test"));
        assertEquals(true,tree.add(""));
        assertEquals(false, tree.add(""));
        assertEquals(true, tree.add("tes"));
        assertEquals(true, tree.add("te"));
    }

    @Test
    void containsTest(){
        MyTreeSet tree = new MyTreeSet("test");
        assertEquals(true, tree.add("t"));
        assertEquals(false, tree.add("test"));
        assertEquals(true,tree.add(""));
        assertEquals(false, tree.add(""));
        assertEquals(true, tree.add("tes"));
        assertEquals(true, tree.add("te"));

        assertEquals(true, tree.contains("test"));
        assertEquals(true, tree.contains("t"));
        assertEquals(true, tree.contains("te"));
        assertEquals(true, tree.contains("tes"));
        assertEquals(true, tree.contains(""));
        assertEquals(false, tree.contains("null"));
    }

    @Test
    void toStringTest(){
        MyTreeSet tree = new MyTreeSet("test");
        tree.add("a");
        tree.add("z");
        assertEquals("test \na z \n", tree.toString());
    }
}
