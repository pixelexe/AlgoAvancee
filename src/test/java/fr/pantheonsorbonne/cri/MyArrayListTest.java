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
    /**
     * Rigorous Test :-)
     */
    @Test
    void shouldAnswerWithTrue() throws IndexOutOfBoundsException
    {
        MyArrayList liste = new MyArrayList();
        assertEquals("[]", liste.toString());
        liste.add("a");
        String data1[] = {"a",};
        assertEquals(liste.data.length, data1.length);
        assertArrayEquals(liste.data, data1);
        liste.add("b");
        String data2[] = {"a","b"};
        assertArrayEquals(liste.data, data2);
        liste.add("c");
        String data3[] = {"a","b","c",null};
        assertArrayEquals(liste.data, data3);
        liste.add("d");
        String data4[] = {"a","b","c","d"};
        assertArrayEquals(liste.data, data4);
        liste.add("e");
        String data5[] = {"a","b","c","d","e",null,null,null};
        assertArrayEquals(liste.data, data5);
        liste.add("f");
        String data6[] = {"a","b","c","d","e","f",null,null};
        assertArrayEquals(liste.data, data6);
        assertEquals("a",liste.get(0));
        assertEquals("b",liste.get(1));
        assertEquals("c",liste.get(2));
        assertEquals("d",liste.get(3));
        assertEquals("e",liste.get(4));
        assertEquals("f",liste.get(5));
        assertThrows(IndexOutOfBoundsException.class,()->liste.get(6));
        assertThrows(IndexOutOfBoundsException.class,()->liste.get(7));
        assertEquals("[a, b, c, d, e, f]", liste.toString());
    }

    
}
