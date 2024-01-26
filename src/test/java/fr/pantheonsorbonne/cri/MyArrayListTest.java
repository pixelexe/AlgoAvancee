package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.MyArrayList.MyArrayList;
import fr.pantheonsorbonne.cri.MyArrayList.MyOutOfBoundsException;

class MyArrayListTest
{
    @Test
    void addToStringGetTest() throws IndexOutOfBoundsException, MyOutOfBoundsException
    {
        MyArrayList liste = new MyArrayList();
        assertEquals("[]", liste.toString());
        liste.add("a");
        String data1[] = {"a"};
        assertEquals("[a]", liste.toString());
        liste.add("b");
        String data2[] = {"a","b"};
        assertEquals("[a, b]", liste.toString());
        liste.add("c");
        String data3[] = {"a","b","c",null};
        assertEquals("[a, b, c]", liste.toString());
        liste.add("d");
        String data4[] = {"a","b","c","d"};
        assertEquals("[a, b, c, d]", liste.toString());
        liste.add("e");
        String data5[] = {"a","b","c","d","e",null,null,null};
        assertEquals("[a, b, c, d, e]", liste.toString());
        liste.add("f");
        String data6[] = {"a","b","c","d","e","f",null,null};
        assertEquals("[a, b, c, d, e, f]", liste.toString());
        assertEquals("a",liste.get(0));
        assertEquals("b",liste.get(1));
        assertEquals("c",liste.get(2));
        assertEquals("d",liste.get(3));
        assertEquals("e",liste.get(4));
        assertEquals("f",liste.get(5));
        assertThrows(MyOutOfBoundsException.class,()->liste.get(6));
        assertThrows(MyOutOfBoundsException.class,()->liste.get(7));
        assertThrows(MyOutOfBoundsException.class,()->liste.get(-1));
        assertThrows(MyOutOfBoundsException.class,()->liste.get(8));
        String data7[] = {"a","b","c","d","e","f","",null};
        liste.add("");
        assertEquals("[a, b, c, d, e, f, ]", liste.toString());
        assertEquals("", liste.get(6));
    }

    @Test
    void isEmptyTest()
    {
        MyArrayList liste = new MyArrayList();
        assertEquals(true, liste.isEmpty());
        liste.add("");
        assertEquals(false, liste.isEmpty());
        liste.add("test");
        assertEquals(false, liste.isEmpty());
    }

    @Test 
    void addWithIndex() throws MyOutOfBoundsException{
        MyArrayList liste = new MyArrayList();
        liste.add(0,"a");
        String [] data1 = {"a"};
        assertEquals("[a]", liste.toString());
        liste.add(0,"b");
        String [] data2 = {"b","a"};
        assertEquals("[b, a]", liste.toString());
        liste.add(1, "c");
        String [] data3 = {"b","c","a",null};
        assertEquals("[b, c, a]", liste.toString());
    }

    @Test 
    void removeTest() throws MyOutOfBoundsException{
        MyArrayList data = new MyArrayList();
        for (int i = 1 ; i<12 ; i++){
            data.add(Integer.toString(i));
        }

        assertEquals("6", data.remove(5));
        assertEquals("11", data.get(9));

        assertThrows(MyOutOfBoundsException.class, ()->data.remove(10));
        assertThrows(MyOutOfBoundsException.class, ()->data.remove(100));
        assertThrows(MyOutOfBoundsException.class, ()->data.remove(-1));
    }

    @Test 
    void setTest() throws MyOutOfBoundsException{
        MyArrayList data = new MyArrayList();
        for (int i = 1 ; i<11; i++){
            data.add(Integer.toString(i));
        }

        assertEquals("6", data.set(5, "hello world"));

        assertEquals("5", data.get(4));
        assertEquals("hello world", data.get(5));
        assertEquals("7", data.get(6));

        assertThrows(MyOutOfBoundsException.class, ()->data.set(-1, "a"));
        assertThrows(MyOutOfBoundsException.class, ()->data.set(10, "a"));
        assertThrows(MyOutOfBoundsException.class, ()->data.set(100, "a"));
    }


    @Test
    public void sizeTest() throws MyOutOfBoundsException{
        MyArrayList data = new MyArrayList();
        assertEquals(0, data.size());
        for (int i = 1 ; i<11; i++){
            data.add(Integer.toString(i));
        }

        assertEquals(10, data.size());

        data.remove(4);
        assertEquals(9, data.size());
    }

    @Test
    public void iteratorTest(){
        MyArrayList data = new MyArrayList();
        Iterator<String> ite = data.iterator();
        assertFalse(ite.hasNext());
        for (int i = 1 ; i<11; i++){
            data.add(Integer.toString(i));
        }
        ite = data.iterator();
        
        for (int i = 1; i<11; i++){
            assertEquals(Integer.toString(i), ite.next());
        }
    }

    @Test
    public void containsTest(){
        MyArrayList liste = new MyArrayList();
        liste.add("a");
        liste.add("b");
        liste.add("c");
        liste.add("d");
        assertEquals(true, liste.contains("a"));
        assertEquals(false, liste.contains("a,b"));
        assertEquals(false, liste.contains("e"));
        assertEquals(false, liste.contains("-1"));
        assertEquals(false, liste.contains(""));
        
    }

    @Test 
    public void indexOfTest(){
        MyArrayList data = new MyArrayList();
        assertEquals(-1, data.indexOf("0"));
        for (int i = 0 ; i<11; i++){
            data.add(Integer.toString(i));
        }

        assertEquals(3, data.indexOf("3"));
        assertEquals(0, data.indexOf("0"));
        assertEquals(10, data.indexOf("10"));
        assertEquals(-1, data.indexOf("hello"));
        
    }
}