package fr.pantheonsorbonne.cri;

import java.util.Iterator;

public class MyIterator implements Iterator<String>{

    private String[] data;
    private int pointeur = 0;

    public MyIterator(String[] datas){
        this.data = datas;
    }

    @Override
    public boolean hasNext() {
        if (this.pointeur < this.data.length && this.data[pointeur] != null){
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        return this.data[this.pointeur++];
    }
    
}