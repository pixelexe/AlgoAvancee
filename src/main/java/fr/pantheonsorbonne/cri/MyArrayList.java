package fr.pantheonsorbonne.cri;

public class MyArrayList{
    int flag;
    String[] data;

    public MyArrayList(String[] data, int flag) {
        this.data = data;
        this.flag = flag;
    }

    private void ensureCapacity(int n) {
        if (n < data.length) {
            return;
        } else {//
            String[] tab2 = new String[data.length * 2];// on crée un nouveau tableau de taille double
            for (int i = 0; i < data.length; i++) {// on copie les éléments du tableau dans le nouveau tableau
                tab2[i] = data[i];// on copie les éléments du tableau dans le nouveau tableau
            }
            data = tab2;// on remplace le tableau par le nouveau tableau
        }
    }

    public void add(String s) {
        ensureCapacity(this.flag + 1);
        this.data[this.flag++] = s;
    }

    public String get(int i) {
        return data[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.flag; i++) {
            sb.append(this.data[i] + ", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList liste = new MyArrayList(new String[1], 0);
        System.out.println(liste.toString().equals("[]"));
        liste.add("a");
        liste.add("b");
        liste.add("c");
        liste.add("d");
        liste.add("e");
        liste.add("f");
        System.out.println(liste.get(3) == "d");
        System.out.println(liste.toString().equals("[a, b, c, d, e, f, ]"));
    }
}

