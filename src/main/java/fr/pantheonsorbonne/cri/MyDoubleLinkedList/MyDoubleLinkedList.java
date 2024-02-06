package fr.pantheonsorbonne.cri.MyDoubleLinkedList;

import fr.pantheonsorbonne.cri.MyArrayList.MyOutOfBoundsException;

public class MyDoubleLinkedList {
    private DoubleNoeud firstNoeud;
    private DoubleNoeud lastNoeud;
    private int tailleListe;

    public MyDoubleLinkedList(String firstData) {
        this.firstNoeud = new DoubleNoeud(firstData);
        this.tailleListe = 1;
    }

    public MyDoubleLinkedList() {
        this.tailleListe = 0;
    }

    public boolean add(String newData) {
        addLast(newData);
        return true;
        
    }

    public void add(int index, String newData) throws MyOutOfBoundsException {
        if(index<0 || index >this.size()){
            throw new MyOutOfBoundsException();
        }
        if (index == 0){
            addFirst(newData);
            return;
        }
        int milieu = this.size()/2;
        DoubleNoeud answer ;
        if (milieu>index){
            answer = this.firstNoeud;
            for (int i = 0; i<index;i++){
                answer = answer.getNextNoeud();
            }
        }
        else{
            answer = this.lastNoeud;
            for (int i = this.size(); i >= index; i--) {
                answer = answer.getPreviousNoeud();
            }
        }
        DoubleNoeud newDoubleNoeud = new DoubleNoeud(newData, answer.getNextNoeud(), answer.getPreviousNoeud());
        answer.getNextNoeud().setPreviousNoeud(newDoubleNoeud);
        answer.getPreviousNoeud().setNextNoeud(newDoubleNoeud);
        tailleListe++;
    }

    public void addFirst(String newFirstData) {
        if (tailleListe == 0){
            this.firstNoeud = new DoubleNoeud(newFirstData);
            return;
        }

        DoubleNoeud premierNoeud = new DoubleNoeud(newFirstData);
        this.firstNoeud.setPreviousNoeud(premierNoeud);
        premierNoeud.setNextNoeud(firstNoeud);
        this.firstNoeud = premierNoeud;
        tailleListe++;
    }

    public void addLast(String newLastData){
        if (tailleListe == 0){
            this.firstNoeud = new DoubleNoeud(newLastData);
            return;
        }

        DoubleNoeud dernierNoeud = new DoubleNoeud(newLastData);
        this.lastNoeud.setNextNoeud(dernierNoeud);
        dernierNoeud.setPreviousNoeud(firstNoeud);
        this.lastNoeud = dernierNoeud;
        tailleListe++;
    }

    public boolean contains(String s) {
        DoubleNoeud noeud = this.firstNoeud;
        if(noeud.getData().equals(s)){
            return true;
        }
        for(int i = 0; i<this.size();i++){
            noeud.getNextNoeud();
            if(noeud.getData().equals(s)){
                return true;
            }
        }
        return false;
    }

    public String get(int index) throws MyOutOfBoundsException {
        if (index<0 || index >this.size()){
            throw new MyOutOfBoundsException();
        }
        if (index == 0 ){
            return this.firstNoeud.getData();
        }
        if(index == this.size()){
            return this.firstNoeud.getData();
        }
        int milieu = this.size()/2;
        DoubleNoeud answer ;
        if (milieu>index){
            answer = this.firstNoeud;
            for (int i = 0; i<index;i++){
                answer = answer.getNextNoeud();
            }
        }
        else{
            answer = this.lastNoeud;
            for (int i = this.size(); i >= index; i--) {
                answer = answer.getPreviousNoeud();
            }
        }
        return answer.getData();
    }

    public String getFirst() throws MyEmptyDoubleLinkedListExeption {
        if(this.size()<=0){
            throw new MyEmptyDoubleLinkedListExeption();
        }
        return this.firstNoeud.getData();
    }

    public String getLast() throws MyEmptyDoubleLinkedListExeption {
        if(this.size()<=0){
            throw new MyEmptyDoubleLinkedListExeption();
        }
        return this.lastNoeud.getData();
    }

    public boolean offer(String s) {
        return add(s);
    }

    public String poll() throws MyEmptyDoubleLinkedListExeption {
        if (this.size()==0){
            throw new MyEmptyDoubleLinkedListExeption();
        }
        DoubleNoeud answer = this.firstNoeud;
        this.firstNoeud = this.firstNoeud.getNextNoeud();
        firstNoeud.setPreviousNoeud(null);
        tailleListe--;
        return answer.getData();
    }

    public void push(String s) {
        add(s);
    }

    public String remove() throws MyEmptyDoubleLinkedListExeption {
        if(this.size() == 0){
            throw new MyEmptyDoubleLinkedListExeption();
        }
        DoubleNoeud answer = this.lastNoeud;
        if (this.size() == 1){
           this.firstNoeud = null;
        }
        else{
            this.lastNoeud = answer.getPreviousNoeud();
            this.lastNoeud.setNextNoeud(null);
        }
        tailleListe --;
        return answer.getData();
    }

    public String removeLast() throws MyEmptyDoubleLinkedListExeption {
        return remove();
        
    }

    public String remove(int index) throws MyOutOfBoundsException, MyEmptyDoubleLinkedListExeption {
        if (index<0 || index >this.size()){
            throw new MyOutOfBoundsException();
        }
        if (index == this.size()){
            return remove();
        }
        if (index == 0){
            return poll();
        }

        int milieu = this.size()/2;
        DoubleNoeud answer ;
        if (milieu>index){
            answer = this.firstNoeud;
            for (int i = 0; i<index;i++){
                answer = answer.getNextNoeud();
            }
        }
        else{
            answer = this.lastNoeud;
            for (int i = this.size(); i >= index; i--) {
                answer = answer.getPreviousNoeud();
            }
        }

        answer.getPreviousNoeud().setNextNoeud(answer.getNextNoeud());
        answer.getNextNoeud().setPreviousNoeud(answer.getPreviousNoeud());
        tailleListe--;
        return answer.getData();
    }

    public String set(int index, String s) throws MyOutOfBoundsException {
        if (index<0 || index >this.size()){
            throw new MyOutOfBoundsException();
        }
        int milieu = this.size()/2;
        DoubleNoeud answer ;
        if (milieu>index){
            answer = this.firstNoeud;
            for (int i = 0; i<index;i++){
                answer = answer.getNextNoeud();
            }
        }
        else{
            answer = this.lastNoeud;
            for (int i = this.size(); i >= index; i--) {
                answer = answer.getPreviousNoeud();
            }
        }
        String stringAnswer = answer.getData();
        answer.setData(s);
        return stringAnswer;
    }

    public String toString() {
        return "";
    }

    public int size() {
        return this.tailleListe;
    }
}
