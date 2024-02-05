package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.MyArrayList.MyArrayList;
import fr.pantheonsorbonne.cri.MyArrayList.MyOutOfBoundsException;
import fr.pantheonsorbonne.cri.MyLinkedList.MyEmptyListException;
import fr.pantheonsorbonne.cri.MyLinkedList.MyLinkedList;
import fr.pantheonsorbonne.cri.MyLinkedList.Noeud;

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
        MyLinkedList mll = new MyLinkedList();
        assertThrows(MyEmptyListException.class, ()->mll.removeLast());
        mll.add("1");
        assertEquals("1", mll.removeLast());
        assertEquals("[]", mll.toString());

        mll.add("1");
        mll.add("2");
        assertEquals("2", mll.removeLast());
        assertEquals("[1]", mll.toString());

        mll.add("2");
        mll.add("3");
        mll.add("4");
        assertEquals("4", mll.removeLast());
        assertEquals("[1, 2, 3]", mll.toString());
    }

    @Test
    public void removeWithIndexTest() throws MyOutOfBoundsException{
        MyLinkedList mll = new MyLinkedList();
        assertThrows(MyOutOfBoundsException.class, ()->mll.remove(0));
        assertThrows(MyOutOfBoundsException.class, ()->mll.remove(1));
        assertThrows(MyOutOfBoundsException.class, ()->mll.remove(-1));

        mll.add("1");
        assertEquals("[1]", mll.toString());
        assertEquals("1", mll.remove(0));
        assertEquals("[]", mll.toString());

        mll.add("1");
        mll.add("2");
        mll.add("3");
        assertEquals("2", mll.remove(1));
        assertEquals("[1, 3]", mll.toString());
        mll.clear();

        mll.add("1");
        mll.add("2");
        mll.add("3");
        assertEquals("3", mll.remove(2));
        assertEquals("[1, 2]", mll.toString());
        
    }

    @Test
    public void setWithIndexTest() throws MyOutOfBoundsException{
        MyLinkedList mll = new MyLinkedList();
        assertThrows(MyOutOfBoundsException.class, ()->mll.set(0,"1"));
        assertThrows(MyOutOfBoundsException.class, ()->mll.set(1 ,"1"));
        assertThrows(MyOutOfBoundsException.class, ()->mll.set(-1,"1"));

        mll.add("1");
        mll.add("2");
        mll.add("3");
        mll.add("4");
        assertEquals("[1, 2, 3, 4]", mll.toString());
        assertEquals("3", mll.set(2, "5"));
        assertEquals("[1, 2, 5, 4]", mll.toString());

        mll.clear();
        mll.add("1");
        mll.add("2");
        assertEquals("[1, 2]", mll.toString());
        assertEquals("1", mll.set(0, "5"));
        assertEquals("[5, 2]", mll.toString());
        assertEquals("2", mll.set(1, "5"));
        assertEquals("[5, 5]", mll.toString());
        

    }

    @Test
    public void MyLinkedListIteratorTest() throws MyOutOfBoundsException{
        MyLinkedList data = new MyLinkedList("test");
        Iterator<Noeud> ite = data.iterator();
        assertFalse(ite.hasNext());

        for (int i = 1 ; i<11; i++){
            data.add(Integer.toString(i));
        }
        assertEquals("[test, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", data.toString());

        ite = data.iterator();
        for (int i = 1; i<11; i++){
            assertEquals(data.get(i), ite.next().getData());
        }
    }
}
