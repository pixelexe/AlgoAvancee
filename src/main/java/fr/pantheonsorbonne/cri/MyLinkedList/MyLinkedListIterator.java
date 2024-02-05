package fr.pantheonsorbonne.cri.MyLinkedList;

import java.util.Iterator;

public class MyLinkedListIterator implements Iterator<Noeud>{
    private Noeud currentNoeud;

    public MyLinkedListIterator(Noeud currentNoeud){
        this.currentNoeud = currentNoeud;
    }

    @Override
    public boolean hasNext() {
        return this.currentNoeud.hasNextNoeud();
    }

    
    @Override
    public Noeud next() {
        return this.currentNoeud.getNextNoeud();
    }
}
