package fr.pantheonsorbonne.cri.MyHashSet;

import java.util.LinkedList;
import java.util.List;

public class MyHashSet {

    
    private List<Couple> [] data;
    private int size = 0;
    private static final double T = 0.7;

    public MyHashSet(){
        this.data = new LinkedList[10];
        for (int i = 0; i < data.length; i++){
            data[i] = new LinkedList<Couple>();
        }
    }
    
    //HS AL et TS
    //Tester les différentes fonctionnalités avec graphes

    // Class Couple
    private class Couple{
        private int hash;
        private String value;

        private boolean equals(Couple c){
            return this.value.equals(c.getValue());
        }

        public Couple(int hash, String value){
            this.hash = hash;
            this.value = value;
        }

        public int getHash(){
            return this.hash;
        }

        public String getValue(){
            return this.value;
        }

        public void setValue(String value){
            this.value = value;
        }

        public void setHash(int hash){
            this.hash = hash;
        }
    }

    //Méthodes
    private void grow(){
        if (size / data.length > T){
            List<Couple>[] tab = new LinkedList[data.length * 2];
            for (int i = 0; i < data.length; i++){
                
                for(int j = 0; j < data[i].size(); j++){
                    int hash = data[i].get(j).getHash();
                    int index = hash % tab.length;
                    tab[index].add(data[i].get(j));
                }
            }
            this.data = tab;
        }
    }

    public boolean add(String s){
        int hash = s.hashCode();
        Couple couple = new Couple(hash, s);
        int index = hash % data.length;
        if (this.data[index].size() == 0){
            this.data[index].add(couple);
            this.size ++;
            grow();
            return true;
        }
        if (this.data[index].contains(couple)){
            return false;
        }

        this.data[index].add(couple);
        this.size ++ ;
        grow();
        return true;
    }

    private boolean contains(String s){
        
        int hash = s.hashCode();
        int index = hash % data.length;
        if (data[index].size() != 0){
            for (int i = 0; i < data[index].size(); i++){
                if (data[index].get(i).getHash() == hash){
                    return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        StringBuilder stringB = new StringBuilder();
        
        for (List<Couple> list : data) {
            if (list != null){
            for (Couple c : list){
                stringB.append(c.getValue());
                stringB.append("     |");
            }
        }
        stringB.append("\n");
    }

        return stringB.toString();
    }


}
