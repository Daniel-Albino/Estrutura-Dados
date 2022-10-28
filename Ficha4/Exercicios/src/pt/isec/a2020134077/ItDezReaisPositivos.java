package pt.isec.a2020134077;

import java.util.Iterator;

public class ItDezReaisPositivos implements Iterator<Double> {

    private DezReaisMutavel dezReaisMutavel;
    private int pos;

    public ItDezReaisPositivos(DezReaisMutavel dezReaisMutavel) {
        this.dezReaisMutavel = dezReaisMutavel;
        this.pos = -1;
    }

    @Override
    public boolean hasNext() {
        return dezReaisMutavel.nextPositiveIndex(pos + 1) > 0;
    }

    @Override
    public Double next() {
        pos = dezReaisMutavel.nextPositiveIndex(++pos);
        return dezReaisMutavel.getNumbers(pos);
    }
}
