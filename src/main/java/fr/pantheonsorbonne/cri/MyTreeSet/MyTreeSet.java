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
                currNoeud = currNoeud.getInf();
                continue;
            }

            currNoeud = currNoeud.getSup();
        }
        return false;
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
                    sb.append("Null ");

                }
                else {
                    sb.append(no.getData() + " ");
                }

                try{
                nextEtage[i] = no.getInf();
                } catch (NullPointerException e){
                    nextEtage[i] = null;
                }

                i++;
                try{
                nextEtage[i] = no.getSup();
                } catch (NullPointerException e){
                    nextEtage[i] = null;
                }
                i++;
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

    public static void main(String[] args) {
        MyTreeSet a = new MyTreeSet("j");
        a.add("b");
        a.add("o");
        a.add("a");
        a.add("z");
        System.out.println( a.toString());
    }
    private class Noeud{
        private String data;
        private Noeud inf;
        private Noeud sup;

        public Noeud(String s){
            this.data = s;
        }

        // public void setData(String s){
        //     this.data = s;
        // }

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
