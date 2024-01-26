package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.MyArrayList.MyOutOfBoundsException;
import fr.pantheonsorbonne.cri.MyLinkedList.MyEmptyListException;
import fr.pantheonsorbonne.cri.MyLinkedList.MyLinkedList;

public class MyLinkedListTest {
    @Test
    public void addTest(){
        MyLinkedList mll = new MyLinkedList("a");
        assertEquals(mll.toString(), "[a]");
        mll.add("b");
        assertEquals(mll.toString(), "[a, b]");
        mll.add("c");
        assertEquals(mll.toString(), "[a, b, c]");
    }

    @Test
    public void addFirstTest(){
        MyLinkedList mll = new MyLinkedList("b");
        mll.addFirst("a");
        assertEquals(mll.toString(), "[a, b]");
    }

    @Test
    public void addIndexTest() throws MyOutOfBoundsException{
        MyLinkedList mll = new MyLinkedList("0");
        for (int i = 1; i<10; i++){
            mll.add(Integer.toString(i));
        }
        assertEquals(mll.toString(), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
        //
        assertThrows(MyOutOfBoundsException.class, ()->mll.add(-1, "a"));
        assertThrows(MyOutOfBoundsException.class, ()->mll.add(11, "a"));

        mll.add(2, "Hello World");
        assertEquals("[0, 1, Hello World, 2, 3, 4, 5, 6, 7, 8, 9]", mll.toString());
        mll.add(0, "GoodBye World");
        assertEquals("[GoodBye World, 0, 1, Hello World, 2, 3, 4, 5, 6, 7, 8, 9]", mll.toString());
        
        mll.add(12, "Owari");
        assertEquals("[GoodBye World, 0, 1, Hello World, 2, 3, 4, 5, 6, 7, 8, 9, Owari]", mll.toString());

    }

    @Test
    public void clearTest(){
        MyLinkedList mll = new MyLinkedList();
        assertEquals(0, mll.size());
        for (int i = 1; i<10; i++){
            mll.add(Integer.toString(i));
        }
        assertEquals(9, mll.size());
        mll.clear(); 
        assertEquals(0, mll.size());
        assertEquals("[]", mll.toString());
    }

    @Test
    public void containsTest(){
        MyLinkedList mll = new MyLinkedList();
        for (int i = 1; i<10; i++){
            mll.add(Integer.toString(i));
        }
        assertTrue(mll.contains("1"));
        assertTrue(mll.contains("9"));
        assertFalse(mll.contains("0"));
        assertFalse(mll.contains("10"));
    }

    @Test
    public void getTest() throws MyOutOfBoundsException{
        MyLinkedList mll = new MyLinkedList();
        for (int i = 0; i<10; i++){
            mll.add(Integer.toString(i));
        }
        assertEquals(10, mll.size());
        assertThrows(MyOutOfBoundsException.class, ()->mll.get(-1));
        assertThrows(MyOutOfBoundsException.class, ()->mll.get(10));
        assertEquals("0", mll.get(0));
        assertEquals("9", mll.get(9));
        assertEquals("3", mll.get(3));
    }

    @Test
    public void getFirstTest() throws MyEmptyListException{
        MyLinkedList mll = new MyLinkedList();
        assertThrows(MyEmptyListException.class, ()->mll.getFirst() );
        mll.add("a");
        assertEquals("a", mll.getFirst());
        mll.add("b");
        assertEquals("a", mll.getFirst());
    }

    @Test 
    public void getLastTest() throws MyEmptyListException{
        MyLinkedList mll = new MyLinkedList();
        assertThrows(MyEmptyListException.class, ()->mll.getFirst() );
        mll.add("a");
        assertEquals("a", mll.getLast());
        mll.add("b");
        assertEquals("b", mll.getLast());
    }

    @Test 
    public void pollTest() throws MyEmptyListException{
        MyLinkedList mll = new MyLinkedList();
        assertThrows(MyEmptyListException.class, ()->mll.poll());
        mll.add("1");
        assertEquals("1", mll.poll());
        assertEquals("[]", mll.toString());

        mll.add("1");
        mll.add("2");
        assertEquals("1", mll.poll());
        assertEquals("[2]", mll.toString());
    }

    @Test 
    public void removeLastTest() throws MyEmptyListException{
        
    }
}
