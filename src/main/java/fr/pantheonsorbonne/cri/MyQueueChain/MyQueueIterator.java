package fr.pantheonsorbonne.cri.MyQueueChain;

import java.util.Iterator;

public class MyQueueIterator implements Iterator<String> {

    MyQueueChain.Couche top;
    public MyQueueIterator(MyQueueChain.Couche top){
        this.top = top;
    }
    @Override
    public boolean hasNext() {
        return this.top != null;
    }

    @Override
    public String next() {
        String answer = this.top.getData();
        this.top = this.top.getUnder();
        return answer;
    }
}
