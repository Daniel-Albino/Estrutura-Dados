package pt.isec.a2020134077.ex3;

import java.util.Objects;

public class Quadrado <T extends Number> extends Figura{

    private T l;

    public Quadrado(String nome, T l) {
        super(nome);
        this.l = l;
    }

    public T getL() {
        return l;
    }

    @Override
    public Double getArea() {
        return l.doubleValue()*l.doubleValue();
    }

    @Override
    public int compareTo(Object o) {
        Figura aux = (Figura) o;

        if(Objects.equals(getArea(), aux.getArea()))
            return 0;
        return -1;
    }
}
