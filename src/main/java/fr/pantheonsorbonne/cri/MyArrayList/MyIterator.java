package fr.pantheonsorbonne.cri.MyArrayList;

import java.util.Iterator;

public class MyIterator implements Iterator<String>{

    private String[] data;
    private int pointeur = 0;

    public MyIterator(String[] datas){
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