package fr.pantheonsorbonne.cri.MyDoubleLinkedList;

public class DoubleNoeud {
    private String data;
    private DoubleNoeud next;
    private DoubleNoeud previous;

    
    public DoubleNoeud(String data){
        this.data = data;
        this.next=null;
        this.previous = null ;
    }
    public DoubleNoeud(String data, DoubleNoeud next, DoubleNoeud previous){
        this.data=data;
        this.next=next;
        this.previous = previous;
    }

    public boolean hasNextNoeud(){
        return this.next != null;
    }

    public boolean hasPreviousNoeud(){
        return this.previous != null;
    }

    public DoubleNoeud getNextNoeud(){
        return this.next;
    }

    public DoubleNoeud getPreviousNoeud(){
        return this.previous;
    }

    public void setNextNoeud(DoubleNoeud next){
        this.next = next;
    }

    public void setPreviousNoeud(DoubleNoeud previous){
        this.previous = previous;
    }

    public void setPreviousAndNextNoeud(DoubleNoeud previous, DoubleNoeud next){
        this.next = next;
        this.previous = previous;
    }

    public String getData(){
        return this.data;
    }
    
    public void setData(String newdata){
        this.data = newdata;
    }

    // public boolean addNoeud(String s){
    //     if(!this.next.hasNextNoeud()){
    //         this.next = new DoubleNoeud(s);
    //         return true;
    //     }
    //     return this.next.addNoeud(s);
    // }
}
