package fr.pantheonsorbonne.cri.MyQueueChain;

public class MyQueueChain {

    Couche currentTop;
    public static class Couche {
        private String data;
        private Couche under;

        public Couche(String data, Couche under){
            this.data = data;
            this.under = under;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setUnder(Couche under){
            this.under = under;
        }

        public String getData(){
            return this.data;
        }

        public Couche getUnder(){
            return this.under;
        }
    }
    public boolean isEmpty(){
        return this.currentTop == null;
    }

    public void push(String ajout){
        Couche coucheAjout = new Couche(ajout, null);
        if (this.isEmpty()){
            currentTop = coucheAjout;
            return;
        }
        coucheAjout.setUnder(this.currentTop);
        currentTop = coucheAjout;
    }

    public String peek(){
        return this.currentTop.getData();
    }

    public String poll(){
        Couche extract = this.currentTop;
        this.currentTop = extract.getUnder();

        return extract.getData();
    }

}
