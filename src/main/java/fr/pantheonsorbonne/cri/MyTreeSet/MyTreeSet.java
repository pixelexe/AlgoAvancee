package fr.pantheonsorbonne.cri.MyTreeSet;

public class MyTreeSet {
    
    private Noeud racine;

    public MyTreeSet(){
        this.racine = null;
    }

    public MyTreeSet(String s){
        this.racine = new Noeud(s);
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
                if (currNoeud.getInf() == null){
                    currNoeud.setInf(s);
                    return true;
                }
                currNoeud = currNoeud.getInf();
                continue;
            }
            
            if (currNoeud.getSup() == null){
                currNoeud.setSup(s);
                return true;
            }
            currNoeud = currNoeud.getSup();
            continue;
        }

        
    }











    private class Noeud{
        private String data;
        private Noeud inf;
        private Noeud sup;

        public Noeud(String s){
            this.data = s;
        }

        public void setData(String s){
            this.data = s;
        }

        public String getData(){
            return this.data;
        }

        public void setInf(String s){
            this.inf = new Noeud(s);
        }

        public Noeud getInf(){
            return this.inf;
        }

        public void setSup(String s){
            this.sup = new Noeud(s);
        }

        public Noeud getSup(){
            return this.sup;
        }
    }
}
