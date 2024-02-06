package fr.pantheonsorbonne.cri.MyLinkedList;

import java.util.Iterator;

import fr.pantheonsorbonne.cri.MyArrayList.MyOutOfBoundsException;

public class MyLinkedList implements Iterable<Noeud>{
    private Noeud firstNoeud;
    private int tailleListe;

    public MyLinkedList(String firstData) {
        this.firstNoeud = new Noeud(firstData);
        this.tailleListe = 1;
    }

    public MyLinkedList() {
        this.tailleListe = 0;
    }

    public boolean add(String newData) {
        if (this.size() == 0) {
            this.addFirst(newData);
            return true;
        }

        Noeud currentNoeud = this.firstNoeud;
        while (currentNoeud.hasNextNoeud()) {
            currentNoeud = currentNoeud.getNextNoeud();
        }
        currentNoeud.setNextNoeud(new Noeud(newData));
        this.tailleListe++;
        return true;
    }

    public void add(int index, String newData) throws MyOutOfBoundsException {
        if (index < 0 || index > this.size()) {
            throw new MyOutOfBoundsException();
        }

        if (index == 0) {
            this.addFirst(newData);
            return;
        }

        Noeud currentNoeud = this.firstNoeud;
        int compt = 0;
        while (currentNoeud.hasNextNoeud()) {

            if (index == ++compt) {
                currentNoeud.setNextNoeud(new Noeud(newData, currentNoeud.getNextNoeud()));
                this.tailleListe++;
                return;
            }
            currentNoeud = currentNoeud.getNextNoeud();
        }

        this.add(newData);
        this.tailleListe++;
    }

    public void addFirst(String newFirstData) {
        this.firstNoeud = new Noeud(newFirstData, this.firstNoeud);
        this.tailleListe++;
    }

    public void clear() {
        this.firstNoeud = null;
        this.tailleListe = 0;
    }

    public boolean contains(String s) {
        if (this.size() == 0) {
            return false;
        }
        Noeud currentNoeud = this.firstNoeud;
        do {
            if (s.equals(currentNoeud.getData())) {
                return true;
            }
            currentNoeud = currentNoeud.getNextNoeud();
        } while (currentNoeud.hasNextNoeud());

        if (s.equals(currentNoeud.getData())) {
            return true;
        }

        return false;
    }

    public String get(int index) throws MyOutOfBoundsException {
        if (index < 0 || index >= this.size()) {
            throw new MyOutOfBoundsException();
        }
        int i = 0;
        Noeud currentNoeud = this.firstNoeud;
        while (i != index) {
            i++;
            currentNoeud = currentNoeud.getNextNoeud();
        }
        return currentNoeud.getData();
    }

    public String getFirst() throws MyEmptyListException {
        if (this.size() == 0) {
            throw new MyEmptyListException();
        }
        return this.firstNoeud.getData();
    }

    public String getLast() throws MyEmptyListException {
        if (this.size() == 0) {
            throw new MyEmptyListException();
        }

        Noeud currentNoeud = this.firstNoeud;
        while (currentNoeud.hasNextNoeud()) {
            currentNoeud = currentNoeud.getNextNoeud();
        }
        return currentNoeud.getData();
    }

    public boolean offer(String s) {
        return this.add(s);
    }

    public String poll() throws MyEmptyListException {
        if (this.size() == 0) {
            throw new MyEmptyListException();
        }
        String answer = this.firstNoeud.getData();
        if (this.size() > 1) {
            this.firstNoeud = this.firstNoeud.getNextNoeud();
        } else {
            this.clear();
        }
        return answer;
    }

    public void push(String s) {
        this.add(s);
    }

    public String remove() throws MyEmptyListException {
        return this.poll();
    }

    public String removeLast() throws MyEmptyListException {
        if (this.size() == 0) {
            throw new MyEmptyListException();
        }
        String anwser;
        if (this.size() == 1) {
            anwser = this.firstNoeud.getData();
            this.clear();
            return anwser;
        }
        Noeud currNoeud = this.firstNoeud;
        while (currNoeud.getNextNoeud().hasNextNoeud()) {
            currNoeud = currNoeud.getNextNoeud();
        }
        anwser = currNoeud.getNextNoeud().getData();
        currNoeud.setNextNoeud(null);
        return anwser;
    }

    public String remove(int index) throws MyOutOfBoundsException {
        if (index < 0 || index >= this.size()) {
            throw new MyOutOfBoundsException();
        }
        Noeud removedNoeud;
        if (index == 0) {
            removedNoeud = this.firstNoeud;
            this.clear();
            return removedNoeud.getData();
        }
        int i = 0;
        Noeud currentNoeud = this.firstNoeud;
        while (i != index - 1) {
            i++;
            currentNoeud = currentNoeud.getNextNoeud();
        }
        if (currentNoeud.hasNextNoeud()) {
            removedNoeud = currentNoeud.getNextNoeud();
            currentNoeud.setNextNoeud(currentNoeud.getNextNoeud().getNextNoeud());
        } else {
            removedNoeud = currentNoeud.getNextNoeud();
            currentNoeud.setNextNoeud(null);
        }
        tailleListe --;
        return removedNoeud.getData();
    }

    public String set(int index, String s) throws MyOutOfBoundsException {
        if (index < 0 || index >= this.size()) {
            throw new MyOutOfBoundsException();
        }
        tailleListe++;
        int i = 0;
        Noeud currentNoeud = this.firstNoeud;
        while (i != index) {
            i++;
            currentNoeud = currentNoeud.getNextNoeud();
        }
        String data= currentNoeud.getData();
        currentNoeud.setData(s);
        return data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (firstNoeud != null) {
            Noeud currentNoeud = firstNoeud;
            while (currentNoeud.hasNextNoeud()) {
                sb.append(currentNoeud.getData());
                sb.append(", ");
                currentNoeud = currentNoeud.getNextNoeud();
            }
            sb.append(currentNoeud.getData());
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return this.tailleListe;
    }

    @Override
    public Iterator<Noeud> iterator() {
        return new MyLinkedListIterator(this.firstNoeud);
    }

    public boolean addRecur(String s){
        if (this.firstNoeud == null ){
            this.firstNoeud = new Noeud(s);
            return true;
        }
        return this.firstNoeud.addNoeud(s);
    }
}
