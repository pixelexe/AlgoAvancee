package fr.pantheonsorbonne.cri.MyHashSet;

import fr.pantheonsorbonne.cri.MyArrayList.MyOutOfBoundsException;
import fr.pantheonsorbonne.cri.MyTreeSet.MyRedAndBlackTreeSet;
import fr.pantheonsorbonne.cri.MyTreeSet.MyTreeSetException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MyHashSet {

    
    private List<Couple>[] data;            //Array de Lists
    private int size = 0;                   //Nombre d'objets dans l'array
    private static final double T = 0.7;    //Taux de remplissage max    

    @SuppressWarnings("unchecked")
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

        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != Couple.class){
                return false;
            }

            return this.value.equals(((Couple) obj).getValue());
        };
        

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

        // public void setValue(String value){
        //     this.value = value;
        // }

        // public void setHash(int hash){
        //     this.hash = hash;
        // }
    }

    //Méthodes
    @SuppressWarnings("unchecked")
    private void grow(){
        if (size / this.data.length > T){
            //Création de l'array plus grand
            List<Couple>[] tab = new LinkedList[data.length * 2];
            //Insertion des LinkedList vides
            for(int i = 0; i < tab.length; i++){
                tab[i] = new LinkedList<>();
            }
            //Replaçage des valeurs de l'ancien Array dans le nouveau
            for (List<Couple> a : this.data){
                for (Couple c : a){
                    int index = c.getHash() % tab.length;
                    tab[index].add(c);
                }
            }
            //Ecrasement de l'ancien Array
            this.data = tab;
        }
    }

    public boolean add(String s){
        int hash = s.hashCode();
        Couple couple = new Couple(hash, s);
        int index = hash % data.length;
        if (this.data[index].contains(couple)){
            return false;
        }
        this.data[index].add(couple);
        this.size ++ ;
        grow();
        return true;
    }

    public boolean contains(String s){
        
        return (data[s.hashCode() % data.length].contains(new Couple(0, s)));
        // [Bon emplacement dans le tableau] contient un couple dont la Value est s ?
    }

    public String toString(){
        StringBuilder stringB = new StringBuilder();
        
        for (List<Couple> list : data) {
            for (Couple c : list){
                stringB.append(c.getValue());
                stringB.append("|");
            }
        
        stringB.append("&");
    }

        return stringB.toString();
    }

    public static void main(String[] args) throws MyOutOfBoundsException, MyTreeSetException {

        for (int i = 1; i <= 10; i++) {

            Random rand = new Random();
            MyHashSet list = new MyHashSet();
            long debut = System.currentTimeMillis();

            for (int j = 0; j < 100000*i; j++) {
                list.add(rand.nextInt(1000000)+"");
            }
            long fin = (System.currentTimeMillis() - debut);
            System.out.println("Temps d'execution pour "+ 100000*+i+" elements : "+fin+"ms");

            debut = System.currentTimeMillis();
            for (int j = 0; j < 100*i; j++) {
                list.contains(rand.nextInt(100000*i)+"");
            }
            fin = (System.currentTimeMillis() - debut )/100;
            System.out.println("Temps d'execution pour 1 contains en moyenne : "+fin+"ms");

        }
    }
}
