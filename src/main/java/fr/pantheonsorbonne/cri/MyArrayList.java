package fr.pantheonsorbonne.cri;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList implements Iterable<String>{
    int flag;
    String[] data;

    public MyArrayList() {
        this.data = new String[1];
        this.flag = 0;
    }

    private void ensureCapacity(int n) {
        if (n <= data.length) {
            return;
        } 
        else {//
            String[] tab2 = new String[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                tab2[i] = data[i];
            }
            data = tab2;
        }
    }

    public boolean add(String s) {
        ensureCapacity(this.flag + 1);
        this.data[this.flag++] = s;
        return true;
    }

    public void add(int index, String element) throws MyOutOfBoundsException{
        if (flag != 0){
        if (index>=flag || index<0){
            throw new MyOutOfBoundsException();
        }
    }
        this.ensureCapacity(flag+1);
        for (int i = this.flag; i>index ; i--){
            this.data[i] = this.data[i-1];
        }
        flag++;
        this.data[index] = element;

    }

    public String get(int i) throws MyOutOfBoundsException{
        if (i>=flag || i<0){
            throw new MyOutOfBoundsException();
        }
        return data[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.flag; i++) {
            sb.append(this.data[i]);
            if (i!= flag-1){
                sb.append(", ");
            }
            
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean contains(String value){
        for (int i = 0; i<this.data.length ; i++){
            if (this.data[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(String value){
        for (int i = 0; i<this.data.length ; i++){
            if (this.data[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return (Arrays.equals(this.data, new String[1]));
    }

    public String remove(int index) throws MyOutOfBoundsException{
        if (index>=flag || index<0){
            throw new MyOutOfBoundsException();
        }
        String retrieve = this.data[index];
        for (int i = index ; i<this.data.length-1; i++){
            this.data[i] = this.data[i+1];
        }
        this.flag--;
        return retrieve;
    }


    public String set(int placement, String element) throws MyOutOfBoundsException{
        if (placement>=flag || placement<0){
            throw new MyOutOfBoundsException();
        }
        String retrieve = this.data[placement];
        this.data[placement] = element;
        return retrieve; 
    }

    public int size(){
        return flag;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator(this.data);
    }
}

