package fr.pantheonsorbonne.cri.MyTreeSet;

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

        // public void setData(String s){
        //     this.data = s;
        // }
        
        public void turnRed(){
            this.isBlack = false;
        }

        public void turnBlack(){
            this.isBlack = true;
        }

        public boolean isBlack(){
            return this.isBlack;
        }

        public String getData(){
            return this.data;
        }

        public void setLeft(String s, Noeud pere){
            this.left = new Noeud(s, pere);
        }

        public Noeud getLeft(){
            return this.left;
        }

        public void setRight(String s, Noeud pere){
            this.right = new Noeud(s, pere);
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

        public Noeud getBrother(Noeud n){
            if (n.isTheRoot()){
                throw new 
            }
        }
    }

    public MyRedAndBlackTreeSet(){
    }

    public MyRedAndBlackTreeSet(String s){
        this.racine = new Noeud(s);
    }

    public void rotationGauche(Noeud r){
        if(r.getLeft() == null || r == null){
            return ;
        }

        Noeud un = r.getBrother(r.getLeft());
        Noeud deux = r;
        Noeud pere = r.getPere();
        
    }

    public boolean add(String s){
        if (this.racine == null){
            this.racine = new Noeud(s);
            return true;
        }
       
        Noeud currNoeud = this.racine;
        for(;;){
            if (s.equals(currNoeud.getData())){
                return false;
            }
            
            if (s.compareTo(currNoeud.getData()) < 0){
                if (currNoeud.getLeft() == null){
                    currNoeud.setLeft(s, currNoeud);
                    this.repareArbre(currNoeud);
                    return true;
                }
                currNoeud = currNoeud.getLeft();
                continue;
            }
            
            if (currNoeud.getRight() == null){
                currNoeud.setRight(s, currNoeud);
                this.repareArbre(currNoeud);
                return true;
            }
            currNoeud = currNoeud.getRight();
            continue;
        }    
    }

    private void repareArbre(Noeud pereDeAjout){
        if (pereDeAjout.isTheRoot()){
            pereDeAjout.turnBlack();
        }

    }

}

