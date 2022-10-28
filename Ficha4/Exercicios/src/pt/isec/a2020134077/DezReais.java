package pt.isec.a2020134077;

import java.util.Iterator;

public class DezReais implements Iterable {
    //Exercício 1:
    private int CAPACITY;
    private Double []tab;
    private int lastPos;

    public DezReais() {
        CAPACITY = 10;
        tab = new Double[CAPACITY];
        lastPos = 0;
    }

    public Double getTab(int pos) {
        if(pos < 0 || pos > 10)
            return -1.0;
        return tab[pos];
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public int getLastPos() {
        return lastPos;
    }

    public void addNumbers(double n){
        if(lastPos == 10)
            throw new RuntimeException();
        tab[lastPos] = n;
        lastPos++;
    }


    //Exercício 2:
    @Override
    public Iterator iterator() {
        return new ItDezReais(this);
    }


}
