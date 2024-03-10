package fr.pantheonsorbonne.cri.MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import fr.pantheonsorbonne.cri.MyTreeSet.MyRedAndBlackTreeSet;
import fr.pantheonsorbonne.cri.MyTreeSet.MyTreeSet;
import fr.pantheonsorbonne.cri.MyTreeSet.MyTreeSetException;

public class MyArrayList implements Iterable<String> {
    private int flag;
    private String[] data;

    public MyArrayList() {
        this.data = new String[1];
        this.flag = 0;
    }

    private void ensureCapacity(int n) { // O(n) Ou O(1)
        if (n <= data.length) {
            return;
        } else {//
            String[] tab2 = new String[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                tab2[i] = data[i];
            }
            data = tab2;
        }
    }

    public boolean add(String s) { // O(1) en général
        ensureCapacity(this.flag + 1);
        this.data[this.flag++] = s;
        return true;
    }

    public void add(int index, String element) throws MyOutOfBoundsException { // O(n)
        if (flag != 0) {
            if (index >= flag || index < 0) {
                throw new MyOutOfBoundsException();
            }
        }
        this.ensureCapacity(flag + 1);
        for (int i = this.flag; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        flag++;
        this.data[index] = element;

    }

    public String get(int i) throws MyOutOfBoundsException { // O(1)
        if (i >= flag || i < 0) {
            throw new MyOutOfBoundsException();
        }
        return data[i];
    }

    public String toString() { // O(n)
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.flag; i++) {
            sb.append(this.data[i]);
            if (i != flag - 1) {
                sb.append(", ");
            }

        }
        sb.append("]");
        return sb.toString();
    }

    public boolean contains(String value) { // O(n)
        for (int i = 0; i < this.flag; i++) {
            if (this.data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String value) { // O(n)
        for (int i = 0; i < this.flag; i++) {
            if (value.equals(this.data[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() { // 0(1)
        return this.data[0] == null;
    }

    public String remove(int index) throws MyOutOfBoundsException { // O(n)
        if (index >= flag || index < 0) {
            throw new MyOutOfBoundsException();
        }
        String retrieve = this.data[index];
        for (int i = index; i < this.data.length - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.flag--;
        return retrieve;
    }

    public String set(int placement, String element) throws MyOutOfBoundsException { // O(1)
        if (placement >= flag || placement < 0) {
            throw new MyOutOfBoundsException();
        }
        String retrieve = this.data[placement];
        this.data[placement] = element;
        return retrieve;
    }

    public int size() { // O(1)
        return flag;
    }

    @Override
    public Iterator<String> iterator() { // O(1)
        return new MyIterator(this.data);
    }

    // System.out.println("--------------------------------------------------");

    // for (int i = 1; i <= 10; i++) {
    // Random rand = new Random();
    // MyTreeSet list = new MyTreeSet();
    // for (int j = 0; j < 100000*i; j++) {
    // list.add(i+"");
    // }

    // for (int j = 0; j < 100000*i; j++) {
    // list.contains(rand.nextInt(100000*i)+"");
    // }

    // }
    public static void main(String[] args) throws MyOutOfBoundsException, MyTreeSetException {

        for (int i = 1; i <= 10; i++) {

            Random rand = new Random();
            MyArrayList list = new MyArrayList();
            long debut = System.currentTimeMillis();
            for (int k = 0; k < 100; k++) {
                list = new MyArrayList();
                for (int j = 0; j < 100000 * i; j++) {
                    list.add(rand.nextInt(100000 * i) + "");
                }
            }
            long fin = (System.currentTimeMillis() - debut) / 100;
            System.out.println("Temps d'execution pour " + 100000 * +i + " elements : " + fin + "ms");

            debut = System.currentTimeMillis();
            for (int j = 0; j < 500 * i; j++) {
                list.contains(rand.nextInt(100000 * i) + "");
            }
            fin = (System.currentTimeMillis() - debut) / 500;
            System.out.println("Temps d'execution pour 1 contains en moyenne : " + fin + "ms");

        }
    }
}