package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class MyArrayListTest
{
    @Test
    void add_toString_get_Test() throws IndexOutOfBoundsException, MyOutOfBoundsException
    {
        MyArrayList liste = new MyArrayList();
        assertEquals("[]", liste.toString());
        liste.add("a");
        String data1[] = {"a"};
        assertEquals(liste.data.length, data1.length);
        assertArrayEquals(liste.data, data1);
        assertEquals("[a]", liste.toString());
        liste.add("b");
        String data2[] = {"a","b"};
        assertArrayEquals(liste.data, data2);
        assertEquals("[a, b]", liste.toString());
        liste.add("c");
        String data3[] = {"a","b","c",null};
        assertArrayEquals(liste.data, data3);
        assertEquals("[a, b, c]", liste.toString());
        liste.add("d");
        String data4[] = {"a","b","c","d"};
        assertArrayEquals(liste.data, data4);
        assertEquals("[a, b, c, d]", liste.toString());
        liste.add("e");
        String data5[] = {"a","b","c","d","e",null,null,null};
        assertArrayEquals(liste.data, data5);
        assertEquals("[a, b, c, d, e]", liste.toString());
        liste.add("f");
        String data6[] = {"a","b","c","d","e","f",null,null};
        assertArrayEquals(liste.data, data6);
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
    }

    @Test
    void isEmptyTest()
    {
        MyArrayList liste = new MyArrayList();
        assertEquals(true, liste.isEmpty());
        liste.add("test");
        assertEquals(false, liste.isEmpty());
    }

    @Test 
    void addWithIndex() throws MyOutOfBoundsException{
        MyArrayList liste = new MyArrayList();
        liste.add(0,"a");
        String [] data1 = {"a"};
        assertArrayEquals(data1,liste.data);
        assertEquals(liste.flag, 1);
        liste.add(0,"b");
        String [] data2 = {"b","a"};
        assertEquals(liste.flag, 2);
        assertEquals(data2.length, liste.data.length);
        assertEquals(liste.data[0], "b");
        assertEquals(liste.data[1], "a");
        assertEquals(data2.length, liste.data.length);
        assertArrayEquals(data2,liste.data);
        liste.add(1, "c");
        String [] data3 = {"b","c","a",null};
        assertEquals(liste.data[0], "b");
        assertEquals(liste.data[1], "c");
        assertEquals(liste.data[2], "a");
        assertEquals(data3.length, liste.data.length);
        assertArrayEquals(data3, liste.data);
        
    }

    
























/* */

    // @Test 
    // void remove
}
