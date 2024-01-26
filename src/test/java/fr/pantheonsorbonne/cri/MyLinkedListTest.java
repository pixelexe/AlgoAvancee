package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
}
