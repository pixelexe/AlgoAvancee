package fr.pantheonsorbonne.cri.MyLinkedList;

import java.util.Iterator;

public class MyLinkedListIterator implements Iterator<Noeud>{
    private Noeud currentNoeud;

    public MyLinkedListIterator(Noeud Noeud){
        this.currentNoeud = Noeud;
    }

    @Override
    public boolean hasNext() {
        return this.currentNoeud.hasNextNoeud();
    }


    @Override
    public Noeud next() {
        currentNoeud = currentNoeud.getNextNoeud();
        return currentNoeud;
    }
}
