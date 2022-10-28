package pt.isec.a2020134077;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DezReaisMutavel implements Iterable{
    private int CAPACITY;
    private Double []tab;
    private int lastPos;
    private int modificacoes;

    public DezReaisMutavel() {
        CAPACITY = 10;
        tab = new Double[CAPACITY];
        lastPos = 0;
        modificacoes = 0;
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

    //Exercício 4
    public void removeNumbers(int pos){
        if(lastPos == 0)
            throw new IllegalStateException();
        if(pos < 0 || pos > 10)
            throw new NoSuchElementException();
        modificacoes++;
        for(int j=pos;j<lastPos-1;j++)
            tab[j] = tab[j+1];
        if(lastPos > -1)
            lastPos--;
    }

    public int getModificacoes() {
        return modificacoes;
    }

    @Override
    public Iterator iterator() {
        //return new ItDezReaisMutavel(this);
        return new ItDezReaisMutavel(this);
    }

    public int nextPositiveIndex(int pos) {
        if(pos < 0 || pos > 10)
            return -1;
        for(int i = pos; i < getCAPACITY(); i++){
            if(tab[i] > 0)
                return i;
        }
        return -1;
    }

    public Double getNumbers(int pos) {
        if(pos < 0 || pos > getCAPACITY())
            return -1.0;
        return tab[pos];
    }
}
