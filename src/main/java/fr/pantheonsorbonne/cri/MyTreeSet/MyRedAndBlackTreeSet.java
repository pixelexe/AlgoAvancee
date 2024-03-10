package fr.pantheonsorbonne.cri.MyTreeSet;

import fr.pantheonsorbonne.cri.MyArrayList.MyOutOfBoundsException;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class MyRedAndBlackTreeSet {

    private Noeud racine;

    private class Noeud{
        private boolean isBlack;
        private String data;
        private Noeud left;
        private Noeud right;
        private Noeud pere;

        public Noeud(String s){
            this.data = s;
            this.setRed();
        }

        public Noeud(String s, Noeud pere){
            this.data = s;
            this.setRed();
            this.pere = pere;
        }

        public void setRed(){
            this.isBlack=false;
        }

        // public void setData(String s){
        //     this.data = s;
        // }
    

        public void setBlack(){
            this.isBlack = true;
        }

        public boolean isBlack(){
            return this.isBlack;
        }

        public boolean isRed(){
            return ! this.isBlack;
        }

        public String getData(){
            return this.data;
        }

        public void setLeft(String s, Noeud pere){
            this.left = new Noeud(s, pere);
            this.left.setPere(this);
        }

        public void setLeft(Noeud filsGauche){
            this.left = filsGauche;
        }

        public Noeud getLeft(){
            return this.left;
        }

        public void setRight(String s, Noeud pere){
            this.right = new Noeud(s, pere);
            this.right.setPere(this);
        }

        public void setRight(Noeud filsDroit){
            this.right = filsDroit;
        }

        public Noeud getRight(){
            return this.right;
        }

        public void setPere(Noeud n){
            this.pere = n;
        }

        public Noeud getPere(){
            return this.pere;
        }

        public boolean isTheRoot(){
            return this.pere == null;
        }

        public boolean isLeftSon(){
            return this.data.compareTo(this.pere.data)<0;
        }

        public Noeud getBrother() throws MyTreeSetException{
            if (this.isTheRoot()){
                throw new MyTreeSetException();
            }
            if(isLeftSon()){
                return this.pere.getRight();
            }
            return this.pere.getLeft();
        }
    }

    public MyRedAndBlackTreeSet(){
    }

    public MyRedAndBlackTreeSet(String s){
        this.racine = new Noeud(s);
    }

    // public void rotationGauche(Noeud r) throws MyTreeSetException{
    //     // if (r.getLeft() == null || r == null){
    //     //     return ;
    //     // }
    //     // Noeud un = r.getBrother(r.getLeft());
    //     // Noeud deux = r;
    //     // Noeud pere = r.getPere();
    //     // deux.setPere(un);
    //     // if (pere.getLeft().equals(r)){
    //     //     pere.setLeft(un.getData(), pere);
    //     // }
    //     // else{
    //     //     pere.setRight(un.getData(), pere);
    //     // }
    //     // un.setPere(pere);
    // }

    public void rotationGauche(Noeud x){
        Noeud X = x;
        Noeud Y = x.getPere();
        Noeud A = x.getLeft();
        Noeud PP = x.getPere().getPere();

        if (PP != null){
            if (Y.isLeftSon()){
                PP.setLeft(X);
            }
            else{
                PP.setRight(X);
            }
        }

        X.setPere(PP);
        Y.setPere(X);
        X.setLeft(Y);
        Y.setRight(A);
        if (A!= null)
            A.setPere(Y);

        if (X.getPere() == null){
            this.racine = X;
        }
    }

    public void rotationDroite(Noeud x){
        Noeud X = x;
        Noeud Y = x.getPere();
        Noeud A = x.getRight();
        Noeud PP = x.getPere().getPere();

        if (PP != null){
            if (Y.isLeftSon()){
                PP.setLeft(X);
            }
            else{
                PP.setRight(X);
            }
        }
        X.setPere(PP);
        Y.setPere(X);
        X.setRight(Y);
        Y.setLeft(A);
        if (A != null)
            A.setPere(Y);

        if (X.getPere() == null){
            this.racine = X;
        }
    }

    public boolean add(String s) throws MyTreeSetException{
        // Si l'arbre est vide :
        if (this.racine == null){
            this.racine = new Noeud(s);
            return true;
        }
       
        // Sinon on parcourt l'arbre en partant de la racine
        Noeud currNoeud = this.racine;
        for(;;){
            // La valeur à insérer est le noeud courant
            if (s.equals(currNoeud.getData())){
                return false;
            }
            
            // La valeur à insérer est plus petite
            if (s.compareTo(currNoeud.getData()) < 0){
                // Il n'y a pas de plus petit noeud
                if (currNoeud.getLeft() == null){
                    // On insère un noeud rouge et on répare
                    currNoeud.setLeft(s, currNoeud);
                    
                    this.repareArbre(currNoeud.getLeft());
                    return true;
                }
                // Il y a un plus petit noeud; on suit le chemin
                currNoeud = currNoeud.getLeft();
                continue;
            }
            // La valeur à insérer est plus grande; il n'y a pas de plus grand noeud
            if (currNoeud.getRight() == null){
                // On insère un noeud rouge et on répare
                currNoeud.setRight(s, currNoeud);
                
                this.repareArbre(currNoeud.getRight());
                return true;
            }
            // Il y a un plus grand noeud; on suit le chemin
            currNoeud = currNoeud.getRight();
            continue;
        }    
    }

    private void repareArbre(Noeud courant) throws MyTreeSetException{
        Noeud x = courant;
        Noeud p = courant.getPere();
        
        // Si le père direct est noir, l'arbre est équilibré
        // x peut etre la racine en cas de rappel de la méthode
        if (x.isTheRoot() || p.isBlack()){
            return;
        }

        // Sinon, si le père direct est la racine, iel devient noir
        if (p.isTheRoot()){
            p.setBlack();
            return;
        }

        // Sinon, on stocke le père et le frère (potentiellement null) du père direct
        Noeud pp = p.getPere();
        Noeud f = p.getBrother();
        
        // Si le frère est rouge, p et f deviennent noirs, pp devient rouge et on relance l'algo plus haut 
        if (f != null && f.isRed()){
            f.setBlack();
            p.setBlack();
            pp.setRed();
            repareArbre(pp);
            return;
        }

        // Sinon, le frère est noir ;
            // Si le père est de gauche :
            if (p.isLeftSon()){
            // Si la valeur rajoutée est à gauche :
            if (x.isLeftSon()){
                rotationDroite(p);
                p.setBlack();
                pp.setRed();
                return;
            }
            // Sinon, la valeur rajoutée est à droite: 
            else{
                rotationGauche(x);
                rotationDroite(x);
                x.setBlack();
                pp.setRed();
                return;
            }
        }
        // Sinon, le père est de droite :
    
        // Si la valeur rajoutée est à gauche :
        if (x.isLeftSon()){
            rotationDroite(x);
            rotationGauche(x);
            x.setBlack();
            pp.setRed();
            return;
            
        }
        // Sinon, la valeur rajoutée est à droite: 
        else{
            rotationGauche(p);
            p.setBlack();
            pp.setRed();
            return;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int n = 2;
        Noeud[] etage = new Noeud[] {this.racine};
        boucle:
        while (true){
            Noeud[] nextEtage = new Noeud[n];
            int i = 0;
            for (Noeud no : etage){
                if (no == null){
                    sb.append("/ ");

                }
                else {
                    if (no.isRed()){
                        sb.append("\u001B[31m" + no.getData() + "\u001B[0m" + " ");
                    }
                    else {
                        sb.append(no.getData() + " ");
                    }
                }

                if (no == null){
                    nextEtage[i++] = null;
                    nextEtage[i++] = null;
                    continue;
                }
                
                nextEtage[i++] = no.getLeft();
                nextEtage[i++] = no.getRight();
            }

            sb.append("\n");
            etage = nextEtage;
            n*=2;
            for (Noeud a : etage){
                if (a != null){
                    continue boucle;
                }
            }
            break;
        }
        return sb.toString();
    }

    public boolean contains(String s){
        if (this.racine == null){
            return false;
        }

        Noeud currNoeud = this.racine;
        while (currNoeud != null){
            if (s.equals(currNoeud.getData())){
                return true;
            }

            if (s.compareTo(currNoeud.getData()) < 0){
                currNoeud = currNoeud.getLeft();
                continue;
            }

            currNoeud = currNoeud.getRight();
        }
        return false;
    }

    public static void main(String[] args) throws MyOutOfBoundsException, MyTreeSetException {

        for (int i = 1; i <= 10; i++) {

            Random rand = new Random();
            MyRedAndBlackTreeSet list = new MyRedAndBlackTreeSet();
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
}}

