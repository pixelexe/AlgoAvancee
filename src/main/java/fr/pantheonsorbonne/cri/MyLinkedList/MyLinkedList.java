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

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Noeud currentNoeud = firstNoeud;
        while (currentNoeud.hasNextNoeud()){
            sb.append(currentNoeud.getData());
            sb.append(", ");
            currentNoeud = currentNoeud.getNextNoeud();
        }
        sb.append(currentNoeud.getData());
        sb.append("]");
        return sb.toString();
    }
}
