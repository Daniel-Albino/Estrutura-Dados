package pt.isec.a2020134077;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItDezReais implements Iterator {
    private DezReais dezReais;
    private int pos;
    public ItDezReais(DezReais dezReais) {
        this.dezReais = dezReais;
        pos = -1;
    }


    @Override
    public boolean hasNext() {
        return pos + 1 < dezReais.getLastPos();
    }

    @Override
    public Double next() {
        if(!hasNext())
            throw new NoSuchElementException(); //Exercício 3
        return dezReais.getTab(++pos);
    }
}
