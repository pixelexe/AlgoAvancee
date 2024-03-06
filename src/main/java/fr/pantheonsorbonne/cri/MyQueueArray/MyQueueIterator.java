package fr.pantheonsorbonne.cri.MyQueueArray;

import java.util.Iterator;

public class MyQueueIterator implements Iterator<String> {

    private String[] data;
    private int pointeur = 0;

    public MyQueueIterator (String[] datas){
        this.data = datas;
    }

    @Override
    public boolean hasNext() {
        return this.pointeur < this.data.length && this.data[pointeur] != null;
    }

    @Override
    public String next() {
        return this.data[this.pointeur++];
    }
}
