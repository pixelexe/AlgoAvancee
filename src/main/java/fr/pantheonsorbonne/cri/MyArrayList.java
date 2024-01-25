package fr.pantheonsorbonne.cri;

import java.util.Arrays;

public class MyArrayList{
    int flag;
    String[] data;

    public MyArrayList() {
        this.data = new String[1];
        this.flag = 0;
    }

    private void ensureCapacity(int n) {
        if (n < data.length) {
            return;
        } else {//
            String[] tab2 = new String[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                tab2[i] = data[i];
            }
            data = tab2;
        }
    }

    public void add(String s) {
        ensureCapacity(this.flag + 1);
        this.data[this.flag++] = s;
    }

    public String get(int i) {
        return data[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.flag; i++) {
            sb.append(this.data[i] + ", ");
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

    public String remove(int index){
        return "";
    }

    public static void main(String[] args) {
        MyArrayList liste = new MyArrayList();
        System.out.println(liste.toString().equals("[]"));
        liste.add("a");
        liste.add("b");
        liste.add("c");
        liste.add("d");
        liste.add("e");
        liste.add("f");
        System.out.println(liste.get(3) == "d");
        System.out.println(liste.toString().equals("[a, b, c, d, e, f, ]"));
    }
}

