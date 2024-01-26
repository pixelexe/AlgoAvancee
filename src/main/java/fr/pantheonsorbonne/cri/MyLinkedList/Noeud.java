package fr.pantheonsorbonne.cri.MyLinkedList;

public class Noeud {
    private String data;
    private Noeud suivant;

    
    public Noeud(String data){
        this.data = data;
        this.suivant=null;
    }
    public Noeud(String data, Noeud suivant){
        this.data=data;
        this.suivant=suivant;
    }

    public boolean hasNextNoeud(){
        return ! (this.suivant==null);
    }

    public Noeud getNextNoeud(){
        return this.suivant;
    }

    public void setNextNoeud(Noeud next){
        this.suivant = next;
    }
}