package fr.pantheonsorbonne.cri.MyLinkedList;

public class MyLinkedList {
    private Noeud firstNoeud;

    public MyLinkedList(String firstData){
        this.firstNoeud = new Noeud(firstData);
    }

    public boolean add(String newData){
        Noeud currentNoeud = this.firstNoeud;
        while (currentNoeud.hasNextNoeud()){
            currentNoeud = currentNoeud.getNextNoeud();
        }
        currentNoeud.setNextNoeud(new Noeud(newData));
        return true;
    }
}
